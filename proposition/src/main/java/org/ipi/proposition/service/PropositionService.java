package org.ipi.proposition.service;

import org.ipi.proposition.controller.PropositionController;
import org.ipi.proposition.entity.Proposition;
import org.ipi.proposition.model.*;
import org.ipi.proposition.repository.PropositionRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.LongStream;

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
    @Autowired
    PropositionRepository propositionRepository;

    public void createPropositionService(Proposition proposition){

        MembreModel proprietaire = membreOfProposition(proposition.getProprietaire());
        EquipeModel equipeProprietaire = equipeOfProposition(proprietaire.equipe);
        CompositionEquipeModel compositionEquipe = restTemplate.getForEntity(apiGateway + equipeApi + "/get/" + equipeProprietaire.getId() + "/composition", CompositionEquipeModel.class).getBody();
        proposition.setMaxVote(compositionEquipe.getMembres().size());
        propositionRepository.save(proposition);
    }

    public MembreModel membreOfProposition(long membreId){
        ResponseEntity<MembreModel> membre = restTemplate.getForEntity(apiGateway + membreApi + "/get/" + membreId, MembreModel.class);
        return membre.getBody();
    }

    public EquipeModel equipeOfProposition(long equipeId){
        ResponseEntity<EquipeModel> equipe = restTemplate.getForEntity(apiGateway + equipeApi + "/get/" + equipeId, EquipeModel.class);
        return equipe.getBody();
    }

    public CompositionPropositionModel compositionProposition(Long propositionId){
        Proposition proposition = propositionRepository.findById(propositionId).get();
        CompositionPropositionModel compositionProposition = new CompositionPropositionModel();
        compositionProposition.setId(proposition.getId());
        compositionProposition.setProprietaire(proposition.getProprietaire());
        compositionProposition.setDescription(proposition.getDescription());
        compositionProposition.setEstAccepte(proposition.isEstAccepte());
        compositionProposition.setNbrAbstention(proposition.getNbrAbstention());
        compositionProposition.setNbrVote(proposition.getNbrVote());
        compositionProposition.setProjetId(proposition.getProjetId());
        compositionProposition.setStatut(proposition.getStatut());
        compositionProposition.setTitre(proposition.getTitre());
        compositionProposition.setVotants(proposition.getVotants());

        List<Long> equipes = new ArrayList<>();

        MembreModel proprietaire = membreOfProposition(proposition.getProprietaire());
        //Retrieving equipe
        EquipeModel equipeProprietaire = equipeOfProposition(proprietaire.equipe);
        equipes.add(equipeProprietaire.id);
        compositionProposition.setEquipes(equipes);
        //Récupérer le nombre de membres d'une équipe
        CompositionEquipeModel compositionEquipe = restTemplate.getForEntity(apiGateway + equipeApi + "/get/" + equipeProprietaire.getId() + "/composition", CompositionEquipeModel.class).getBody();

        compositionProposition.setMaxVote(compositionEquipe.getMembres().size());
        return compositionProposition;
    }

    private Long[] stringToLongArray(String str) {
        String[] strArray = str.split(",");
        return LongStream.range(0, strArray.length)
                .mapToObj(i -> Long.parseLong(strArray[(int) i].trim()))
                .toArray(Long[]::new);
    }
}
