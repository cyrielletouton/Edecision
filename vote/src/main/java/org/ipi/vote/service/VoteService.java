package org.ipi.vote.service;

import org.ipi.vote.controller.VoteController;
import org.ipi.vote.model.PropositionDto;
import org.ipi.vote.model.VoteStatut;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static org.ipi.vote.model.propositionStatutDto.ENCOURS;
import static org.ipi.vote.model.propositionStatutDto.TERMINE;

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public void updatePropositionAfterVote(long propId, long voterId, long voteEquipe, VoteStatut voteStatut) {
        ResponseEntity<PropositionDto> prop = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + Long.toString(propId), PropositionDto.class);

        PropositionDto propositionOfCurrentVote = prop.getBody();
        if (propositionOfCurrentVote != null) {
            if (propositionOfCurrentVote.statut == ENCOURS) {
                logger.info("mise à jour proposition");
                if (propositionOfCurrentVote.statut == ENCOURS) {
                    logger.info("proposition en cours");
                    boolean voterInTheTeam = false;
                    for (Long equipe : propositionOfCurrentVote.equipes) {
                        if (equipe == voteEquipe) {
                            logger.info("votant dans la bonne équipe");
                            voterInTheTeam = true;
                            break;
                        }
                    }
                    if (voterInTheTeam) {
                        boolean voterAlreadyVoted = false;
                        for (Long votant : propositionOfCurrentVote.votants) {
                            if (votant == voterId) {
                                voterAlreadyVoted = true;
                                break;
                            }
                        }
                        if (!voterAlreadyVoted) {
                            logger.info("autorisé à voter");
                            propositionOfCurrentVote.votants.add(voterId);
                            // Compte des votes pour la proposition
                            propositionOfCurrentVote = calculateVote(propositionOfCurrentVote, voteStatut);
                            // Mise à jour du status des votes si nécessaire
                            propositionOfCurrentVote = concludeVote(propositionOfCurrentVote);
                            // Mettre à jour la proposition
                            if (propositionOfCurrentVote.statut == TERMINE) {
                                logger.info("la proposition a été votée");
                            }
                        } else {
                            logger.info("déjà voté");
                        }
                    } else {
                        logger.info("votant dans la mauvaise équipe");
                    }
                }
            }

        } else {
            logger.info("proposion pas encore ouverte au vote");
        }

    }

    public PropositionDto calculateVote(PropositionDto proposition, VoteStatut voteStatut) {
        if (voteStatut == VoteStatut.POUR) {
            proposition.nbrVote += 1;
        } else if (voteStatut == VoteStatut.ABSTENTION) {
            proposition.nbrAbstention += 1;
            proposition.maxVote -= 1;
        }

        return proposition;
    }

    public PropositionDto concludeVote(PropositionDto proposition) {
        if (proposition.maxVote == proposition.nbrVote) {
            logger.info("nb maximum de votes");
            if (proposition.maxVote == 0) {
                logger.info("proposition refusée, 100% d'abstention");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            } else if ((proposition.maxVote / 2) - proposition.nbrAbstention < proposition.nbrVote) {
                logger.info("proposition acceptée");
                proposition.statut = TERMINE;
                proposition.estAccepte = true;
            } else if (proposition.maxVote / 2 >= proposition.nbrVote) {
                logger.info("proposition refusée");
                proposition.statut = TERMINE;
                proposition.estAccepte = false;
            }
        }
        return proposition;
    }

}
