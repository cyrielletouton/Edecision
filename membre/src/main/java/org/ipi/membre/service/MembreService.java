package org.ipi.membre.service;

import org.ipi.membre.model.Membre;
import org.ipi.membre.repository.MembreRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class MembreService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.equipes}")
    private String equipeApi;
    @Autowired
    private MembreRepository membreRepository;
    RestTemplate restTemplate = new RestTemplate();
}
