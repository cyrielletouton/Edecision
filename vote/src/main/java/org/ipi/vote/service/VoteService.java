package org.ipi.vote.service;

import org.ipi.vote.controller.VoteController;
import org.ipi.vote.model.CompositionPropositionModel;
import org.ipi.vote.model.PropositionModel;
import org.ipi.vote.entity.Vote;
import org.ipi.vote.entity.misc.VoteStatut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

import static org.ipi.vote.model.PropositionStatutModel.ENCOURS;
import static org.ipi.vote.model.PropositionStatutModel.TERMINE;
import static org.ipi.vote.entity.misc.VoteStatut.*;

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    @Value("${api.vote}")
    private String voteApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public boolean updatePropositionAfterVote(long propId, long voterId, long voterEquipe, VoteStatut voteStatut) {
        boolean createVote = false;

        ResponseEntity<PropositionModel> prop = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId, PropositionModel.class);
        PropositionModel propositionOfCurrentVote = prop.getBody();
        if (propositionOfCurrentVote != null) {
            if (propositionOfCurrentVote.statut == ENCOURS) {
                logger.info("mise à jour proposition, vote en cours");
                boolean voterInTheTeam = false;
                // Récup la compo d'une proposition
                ResponseEntity<CompositionPropositionModel> compositionPropositionResponse = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId + "/composition", CompositionPropositionModel.class);
                CompositionPropositionModel compositionProposition = compositionPropositionResponse.getBody();
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
                        logger.info("autorisé à voter : vote");
                        propositionOfCurrentVote.votants = addLongToString(propositionOfCurrentVote.votants, voterId);

                        logger.info("ajouté au votants " + propositionOfCurrentVote.votants);

                        // Mettre à jour la proposition APRES CALCUL ET CONCLUSION DU VOTE (votants => composition proposition)
                        HttpHeaders headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        HttpEntity<PropositionModel> request = new HttpEntity<>(propositionOfCurrentVote, headers);
                        restTemplate.postForEntity(apiGateway + propositionApi + "/update/" + propositionOfCurrentVote.id, request, String.class);

                        // Mise à jour de la composition de la proposition car celle-ci a changé
                        ResponseEntity<CompositionPropositionModel> compositionPropositionResponseUpdated = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId + "/composition", CompositionPropositionModel.class);
                        CompositionPropositionModel compositionPropositionUpdated = compositionPropositionResponseUpdated.getBody();

                        // Compte des votes pour la proposition
                        propositionOfCurrentVote = calculateVote(propositionOfCurrentVote, formatVoteStatut(voteStatut));
                        // Mise à jour du status des votes si nécessaire

                        if (compositionPropositionUpdated != null){
                            propositionOfCurrentVote = concludeVote(propositionOfCurrentVote, compositionPropositionUpdated);
                        }

                        // Mettre à jour la proposition APRES CALCUL ET CONCLUSION DU VOTE (statut proposition)
                        // TODO : faire un endpoint qui permet d'ajouter les votants plutôt qu'update toute la proposition
                        headers = new HttpHeaders();
                        headers.setContentType(MediaType.APPLICATION_JSON);
                        request = new HttpEntity<>(propositionOfCurrentVote, headers);
                        restTemplate.postForEntity(apiGateway + propositionApi + "/update/" + propositionOfCurrentVote.id, request, String.class);

                        createVote = true;
                    } else {
                        logger.info("ce votant a déjà voté");
                    }
                } else {
                    logger.info("votant dans la mauvaise équipe");
                }
            } else {
                logger.info("proposition n'est pas en cours de vote");
            }
        }
        return createVote;
    }

    public PropositionModel calculateVote(PropositionModel proposition, VoteStatut voteStatut) {
        if (voteStatut == POUR) {
            proposition.nbrVote += 1;
        }
        if (voteStatut == ABSTENTION) {
            proposition.nbrAbstention += 1;
        }
        return proposition;
    }

    public PropositionModel concludeVote(PropositionModel proposition, CompositionPropositionModel compositionProposition) {
        int nbVotants;
        // Majorité vaut la moitié du nombre max de vote - abstention
        int majority = (proposition.maxVote - proposition.nbrAbstention)/2;
        // If no comme in the string of the composition, that means there is only one voter
        if(!compositionProposition.getVotants().contains(",")) {
            nbVotants = 1;
        } else {
            nbVotants = stringToLongArray(compositionProposition.getVotants()).length;
        }
        logger.info("MAJ = " + majority);
        logger.info("nb votants TOTAL : " + nbVotants);
        logger.info("nbVote = " + proposition.nbrVote);

        // Il faut vérifier que le vote est terminé
        if (proposition.maxVote == nbVotants) {
            logger.info("tout les votants ont exprimés leur suffrage");
            if (proposition.maxVote == proposition.nbrAbstention) {
                logger.info("proposition refusée, 100% d'abstention");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            }
            if (majority < proposition.nbrVote && proposition.maxVote != proposition.nbrAbstention) {
                logger.info("proposition acceptée");
                proposition.statut = TERMINE;
                proposition.estAccepte = true;
            }
            if (majority > proposition.nbrVote) {
                logger.info("proposition refusée");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            }
            if (majority == proposition.nbrVote && majority != 0){
                logger.info("égalité");
                //Get vote by proposition ID
                ResponseEntity<List<Vote>> votesResponse = restTemplate.exchange(
                        apiGateway + voteApi + "/get/byPropositionId/" + proposition.id,
                        HttpMethod.GET,
                        null,
                        new ParameterizedTypeReference<List<Vote>>() {}
                );
                List<Vote> votes = votesResponse.getBody();
                if (votes != null){
                    for (Vote vote : votes) {
                        if (vote.getMembre() == proposition.proprietaire) {
                            proposition.statut = TERMINE;
                            proposition.estAccepte = true;
                            break;
                        }
                    }
                }
                logger.info("la proposition est accepté (propriétaire majoritaire)");
            }
        }
        if (proposition.statut == TERMINE) {
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
