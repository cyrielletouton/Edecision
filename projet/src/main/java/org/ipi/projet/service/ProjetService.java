package org.ipi.projet.service;

import org.ipi.projet.model.CompositionProjet;
import org.ipi.projet.model.EquipeDTO;
import org.ipi.projet.model.Projet;
import org.ipi.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

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

    public void commpositionProjet(Long projetId){
        List<Long> equipesId = new ArrayList<>();
        List<Long> propositionsId = new ArrayList<>();
        CompositionProjet compositionProjet = new CompositionProjet();

        Projet projet = projetRepository.findById(projetId).get();
        compositionProjet.setId(projet.getId());
        compositionProjet.setNom(projet.getNom());

        //Retreiving equipes.
        EquipeDTO[] equipes = restTemplate.getForEntity(apiGateway + equipeApi + "get", EquipeDTO[].class).getBody();
        for (EquipeDTO equipe : equipes) {

        }

        //get equipe et proposition

    }
}
