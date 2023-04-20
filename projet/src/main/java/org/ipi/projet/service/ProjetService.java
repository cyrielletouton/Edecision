package org.ipi.projet.service;

import org.ipi.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class ProjetService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.equipe}")
    private String equipeApi;
    @Value("${api.proposition}")
    private String propositionApi;
    @Autowired
    private ProjetRepository projetRepository;
    RestTemplate restTemplate = new RestTemplate();
}
