package org.ipi.proposition.service;

import org.ipi.proposition.controller.PropositionController;
import org.ipi.proposition.model.ProjetDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class PropositionService {
    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.projet}")
    private String projetApi;
    Logger logger = LoggerFactory.getLogger(PropositionController.class);

    RestTemplate restTemplate = new RestTemplate();

    public void updateProjetOfProposition(long propositionId) {
        ResponseEntity<ProjetDTO> projet = restTemplate.getForEntity(apiGateway + projetApi + "/get/" + propositionId, ProjetDTO.class);
        ProjetDTO projetOfProposition = projet.getBody();
        if(projetOfProposition != null){
            projetOfProposition.getPropositions().add(propositionId);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjetDTO> request = new HttpEntity<>(projetOfProposition, headers);
        restTemplate.postForEntity( apiGateway + projetApi + "/update/" + projetOfProposition.getId(), request, String.class);
        logger.info("projet de la proposition mis à jour");
    }
}
