package org.ipi.membres.service;

import org.ipi.membres.model.Membre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;

@Component
public class MembreService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.equipes}")
    private String membresApi;

    RestTemplate restTemplate = new RestTemplate();
    
    public void createMembreService(Membre membres){

    }
}
