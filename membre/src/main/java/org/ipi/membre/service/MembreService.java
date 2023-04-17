package org.ipi.membre.service;

import org.ipi.membre.model.Membre;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MembreService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.equipes}")
    private String membresApi;

    RestTemplate restTemplate = new RestTemplate();
    
    public void createMembreService(Membre membre){
        //Create membre

        //Add membre to equipe
    }
}
