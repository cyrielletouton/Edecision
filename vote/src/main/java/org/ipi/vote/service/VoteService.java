package org.ipi.vote.service;

import org.ipi.vote.controller.VoteController;
import org.ipi.vote.model.PropositionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

import static org.ipi.vote.model.statutDto.ENCOURS;
import static org.ipi.vote.model.statutDto.TERMINE;

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public void updatePropositionAfterVote(long propId, long voterId, long voteEquipe) {
        ResponseEntity<PropositionDto> prop = restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + Long.toString(propId), PropositionDto.class);
        logger.info("mise à jour proposition");
        PropositionDto propositionOfCurrentVote = prop.getBody();
        if (propositionOfCurrentVote != null) {
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
                if (voterInTheTeam){
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
                        propositionOfCurrentVote.nbrVote += 1;
                        if (propositionOfCurrentVote.nbrVote == propositionOfCurrentVote.maxVote){
                            propositionOfCurrentVote.statut = TERMINE;
                        }

                        // Mettre à jour la proposition
                    } else {
                        logger.info("déjà voté");
                    }
                } else {
                    logger.info("votant dans la mauvaise équipe");
                }
            }
        }
    }


}
