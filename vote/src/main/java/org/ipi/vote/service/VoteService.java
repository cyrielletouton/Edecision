package org.ipi.vote.service;

import org.ipi.vote.controller.VoteController;
import org.ipi.vote.model.PropositionDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.*;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Objects;

import static org.ipi.vote.model.StatusDto.ENCOURS;

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public void updatePropositionAfterVote(String propId, long voterId){
        ResponseEntity <PropositionDto> prop =  restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId, PropositionDto.class);
        // Verifier si la proposition existe
        PropositionDto propositionOfCurrentVote = prop.getBody();
        if (propositionOfCurrentVote != null){
            // Verifier si la proposition est votable
            if (propositionOfCurrentVote.status == ENCOURS) {
                // Verifier si le votant appartient à l'équipe

            }
        }


//        HttpEntity<PropositionDto> request = new HttpEntity<>(Objects.requireNonNull(propositionOfCurrentVote.getBody()));




        // increment le nombre max de vote si il est null ou 0

        // Verifier si le votant a déjà voté

        // Si les conditions précédentes sont réunies :

        // Mettre à jour la proposition

        // Si tout le monde a voté alors cloturer la proposition

        //ResponseEntity<PropositionDto> response = restTemplate.exchange(apiGateway + propositionApi + "/update/" + propId, HttpMethod.PUT, request, PropositionDto.class);

        // Check if the response is OK
//        if (response.getStatusCode() == HttpStatus.OK) {
//            // The update was successful
//            logger.info("yes");
//        } else {
//            // The update was not successful
//            logger.info("no");
//        }
    }


}
