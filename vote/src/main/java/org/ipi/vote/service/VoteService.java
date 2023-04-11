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

@Component
public class VoteService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.proposition}")
    private String propositionApi;
    Logger logger = LoggerFactory.getLogger(VoteController.class);

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<PropositionDto> updatePropositionAfterVote(String propId){
        return restTemplate.getForEntity(apiGateway + propositionApi + "/get/" + propId, PropositionDto.class);
    }


}
