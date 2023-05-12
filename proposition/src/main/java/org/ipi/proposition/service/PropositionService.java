package org.ipi.proposition.service;

import org.ipi.proposition.controller.PropositionController;
import org.ipi.proposition.model.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class PropositionService {
    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.projet}")
    private String projetApi;
    @Value("${api.equipe}")
    private String equipeApi;
    @Value("${api.membre}")
    private String membreApi;
    Logger logger = LoggerFactory.getLogger(PropositionController.class);

    RestTemplate restTemplate = new RestTemplate();

    public Proposition updateProposition(Proposition proposition){
        MembreDTO membreOfProposition = restTemplate.getForEntity(apiGateway + membreApi + "/get/" + proposition.getProprietaire(), MembreDTO.class).getBody();
        if (membreOfProposition != null){
            EquipeDTO equipeOfProposition = equipeOfProposition(membreOfProposition.getEquipe());
            logger.info("membre de la proposition trouvé");
            proposition.setProprietaire(membreOfProposition.id);
            if(equipeOfProposition != null){
                logger.info("equipe de la proposition trouvé");
                // TODO : Vérifier que le membre peut faire une proposition sur ce projet
                //Partie commentée, car une proposition ne possède plus de champ équipe
                //List<Long> equipes = proposition.getEquipes();
                //equipes.add(equipeOfProposition.id);
                //proposition.setEquipes(equipes);
                updateProjetOfProposition(proposition.getId());
            } else {
                throw new RuntimeException("membre non trouvé");
            }
        } else {
            throw new RuntimeException("équipe non trouvé");
        }
        return proposition;
    }

    public MembreDTO membreOfProposition(long membreId){
        ResponseEntity<MembreDTO> membre = restTemplate.getForEntity(apiGateway + membreApi + "/get/" + membreId, MembreDTO.class);
        return membre.getBody();
    }

    public EquipeDTO equipeOfProposition(long equipeId){
        ResponseEntity<EquipeDTO> equipe = restTemplate.getForEntity(apiGateway + equipeApi + "/get/" + equipeId, EquipeDTO.class);
        return equipe.getBody();
    }

    public void updateProjetOfProposition(long propositionId) {
        ResponseEntity<ProjetDTO> projet = restTemplate.getForEntity(apiGateway + projetApi + "/get/" + propositionId, ProjetDTO.class);
        List<Long> propositionsId = new ArrayList<>();
        ProjetDTO projetOfProposition = projet.getBody();
        if(projetOfProposition != null){
            if(projetOfProposition.getPropositions() == null){
                propositionsId.add(propositionId);
                projetOfProposition.setPropositions(propositionsId);
            }
            projetOfProposition.getPropositions().add(propositionId);
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjetDTO> request = new HttpEntity<>(projetOfProposition, headers);
        restTemplate.postForEntity( apiGateway + projetApi + "/update/" + projetOfProposition.getId(), request, String.class);
        logger.info("projet de la proposition mis à jour");
    }

    public void compositionProposition(Long proprietaireId){
        CompositionPropositionDTO compositionProposition = new CompositionPropositionDTO();
        List<Long> equipes = new ArrayList<>();

        MembreDTO proprietaire = membreOfProposition(proprietaireId);
        //Retrieving equipe
        EquipeDTO equipeProprietaire = equipeOfProposition(proprietaire.equipe);
        equipes.add(equipeProprietaire.id);
        compositionProposition.setEquipes(equipes);
    }
}
