package org.ipi.vote.service;

import org.ipi.vote.controller.VoteController;
import org.ipi.vote.model.CompositionPropositionDTO;
import org.ipi.vote.model.PropositionDto;
import org.ipi.vote.model.VoteStatut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.stream.LongStream;

import static org.ipi.vote.model.PropositionStatutDTO.ENCOURS;
import static org.ipi.vote.model.PropositionStatutDTO.TERMINE;
import static org.ipi.vote.model.VoteStatut.*;

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public boolean updatePropositionAfterVote(long propId, long voterId, long voterEquipe, VoteStatut voteStatut) {
        boolean createVote = false;

        ResponseEntity<PropositionDto> prop = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId, PropositionDto.class);
        PropositionDto propositionOfCurrentVote = prop.getBody();
        if (propositionOfCurrentVote != null) {
            if (propositionOfCurrentVote.statut == ENCOURS) {
                logger.info("mise à jour proposition, vote en cours");
                boolean voterInTheTeam = false;
                // Récup la compo d'une proposition
                ResponseEntity<CompositionPropositionDTO> compositionPropositionResponse = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId + "/composition", CompositionPropositionDTO.class);
                CompositionPropositionDTO compositionProposition = compositionPropositionResponse.getBody();
                if (compositionProposition != null) {
                    for (Long equipe : compositionProposition.getEquipes()) {
                        if (equipe == voterEquipe) {
                            logger.info("votant dans la bonne équipe");
                            voterInTheTeam = true;
                            break;
                        }
                    }
                }

                if (voterInTheTeam) {
                    boolean voterAlreadyVoted = false;
                    // We need to check if voter already voted, only if al least one person already voted
                    if(!compositionProposition.getVotants().isBlank()){
                        for (Long votant : stringToLongArray(compositionProposition.getVotants())) {
                            if (votant == voterId) {
                                logger.info("pas autorisé à voter : déjà voté");
                                voterAlreadyVoted = true;
                                break;
                            }
                        }
                    }

                    if (!voterAlreadyVoted) {
                        // testé
                        logger.info("autorisé à voter : vote");
                        propositionOfCurrentVote.votants = addLongToString(propositionOfCurrentVote.votants, voterId);
                        // Compte des votes pour la proposition
                        logger.info("nbr vote avant calculate : " + propositionOfCurrentVote.nbrVote);
                        propositionOfCurrentVote = calculateVote(propositionOfCurrentVote, formatVoteStatut(voteStatut));
                        logger.info("nbr vote après calculate : " + propositionOfCurrentVote.nbrVote);
                        // Mise à jour du status des votes si nécessaire
                        propositionOfCurrentVote = concludeVote(propositionOfCurrentVote, compositionProposition);
                        // Mettre à jour la proposition
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        HttpEntity<PropositionDto> request = new HttpEntity<>(propositionOfCurrentVote, headers);
                        // TODO : faire un endpoint qui permet d'ajouter les votants plutôt qu'update toute la proposition
                        restTemplate.postForEntity(apiGateway + propositionApi + "/update/" + propositionOfCurrentVote.id, request, String.class);
                        createVote = true;
                    } else {
                        // testé
                        logger.info("ce votant a déjà voté");
                    }
                } else {
                    // testé
                    logger.info("votant dans la mauvaise équipe");
                }
            } else {
                // testé
                logger.info("proposition n'est pas en cours de vote");
            }
        }
        return createVote;
    }

    public PropositionDto calculateVote(PropositionDto proposition, VoteStatut voteStatut) {
        if (voteStatut == POUR) {
            proposition.nbrVote += 1;
        }
        if (voteStatut == ABSTENTION) {
            proposition.nbrAbstention += 1;
        }
        return proposition;
    }

    public PropositionDto concludeVote(PropositionDto proposition, CompositionPropositionDTO compositionProposition) {
        int nbVotants;
        // Majorité vaut la moitié du nombre max de vote
        int majority = proposition.maxVote/2;
        // La vraie majorité est égale à la majorité moins le nb d'abstention (car abstention n'est pas comptabilisée comme un vote)
        int realMajority = majority - proposition.nbrAbstention;
        logger.info("compositionProposition.getVotants() -- 1 " + compositionProposition.getVotants());

        // If no comme in the string of the composition, that means there is only one voter
        if(!compositionProposition.getVotants().contains(",")) {
            nbVotants = 1;
            logger.info("compositionProposition.getVotants() -- 2" + compositionProposition.getVotants());
        } else {
            logger.info("compositionProposition.getVotants() -- 3" + compositionProposition.getVotants());
            nbVotants = stringToLongArray(compositionProposition.getVotants()).length;
        }
        logger.info("nb votants TOTAL : " + nbVotants);

        // Il faut vérifier que le vote est terminé
        if (proposition.maxVote == proposition.nbrVote) {
            logger.info("tout les votants ont exprimés leur suffrage");
            if (proposition.maxVote == proposition.nbrAbstention) {
                logger.info("proposition refusée, 100% d'abstention");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            }
            if (realMajority < proposition.nbrVote) {
                logger.info("proposition acceptée");
                proposition.statut = TERMINE;
                proposition.estAccepte = true;
            }
            if (realMajority > proposition.nbrVote) {
                logger.info("proposition refusée");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            }
            if (realMajority == proposition.nbrVote){
                logger.info("égalité");
            }
        }
        if (proposition.statut == TERMINE) {
            // testé
            logger.info("la proposition est clôturée");
        }

        return proposition;
    }

    private Long[] stringToLongArray(String str) {
        String[] strArray = str.split(",");
        return LongStream.range(0, strArray.length)
                .mapToObj(i -> Long.parseLong(strArray[(int) i].trim()))
                .toArray(Long[]::new);
    }

    public String addLongToString(String votants, Long newVotant) {
        if(votants.isBlank()){
            return newVotant.toString();
        }
        else {
            String newLongStr = newVotant.toString();
            String[] strArray = votants.split(",");
            String[] newStrArray = Arrays.copyOf(strArray, strArray.length + 1);
            newStrArray[strArray.length] = newLongStr;
            return String.join(",", newStrArray);
        }
    }

    public VoteStatut formatVoteStatut(VoteStatut statut) {
        VoteStatut result;
        if(statut.toString().contains("POUR")) {
            result = POUR;
        } else if(statut.toString().contains("CONTRE")){
            result = CONTRE;
        } else {
            result = ABSTENTION;
        }
        return result;
    }
}
