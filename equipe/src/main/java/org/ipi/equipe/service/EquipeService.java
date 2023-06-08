package org.ipi.equipe.service;

import org.ipi.equipe.model.CompositionEquipeModel;
import org.ipi.equipe.model.ProjetModel;
import org.ipi.equipe.entity.Equipe;
import org.ipi.equipe.model.MembresModel;
import org.ipi.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.LongStream;

@Component
public class EquipeService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.membres}")
    private String membresApi;
    @Value("${api.projet}")
    private String projetApi;
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private EquipeRepository equipeRepository;
    Logger logger = LoggerFactory.getLogger(EquipeService.class);

    public CompositionEquipeModel compositionEquipeService(Long id) {
        List<Long> membresIds = new ArrayList<>();
        List<Long> projetsId = new ArrayList<>();
        CompositionEquipeModel composition = new CompositionEquipeModel();

        Equipe equipe = equipeRepository.findById(id).get();
        composition.setTypeEquipe(equipe.getTypeEquipe());
        composition.setId(equipe.getId());

        MembresModel[] membres = restTemplate.getForEntity(apiGateway + membresApi + "get", MembresModel[].class).getBody();
        for (MembresModel membre : membres) {
            Long idMembre = membre.getId();
            Long equipeId = membre.getEquipe();
            if (equipeId == id){
                membresIds.add(idMembre);
            }
        }
        composition.setMembres(membresIds);
        ProjetModel[] projets = restTemplate.getForEntity(apiGateway + projetApi + "get", ProjetModel[].class).getBody();
        for (ProjetModel projet : projets) {
            Long projetId = projet.getId();
            if (projet.getEquipes().isBlank()){
                projetsId.add(projetId);
            }
            else {
                for (Long equipeId : stringToLongArray(projet.getEquipes())) {
                    if( equipeId == id){
                        projetsId.add(projetId);
                    }
                }
            }
        }
        composition.setProjets(projetsId);
        return composition;
    }

    public CompositionEquipeModel updateProjetWithEquipe(Long equipeId, Long projetId){
        ProjetModel projet = restTemplate.getForEntity(apiGateway + projetApi + "get/" + projetId, ProjetModel.class).getBody();
        if(projet != null){
            projet.setEquipes(addLongToString(projet.getEquipes(), equipeId));
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjetModel> request = new HttpEntity<>(projet, headers);
        logger.info(apiGateway + projetApi + "update/" + projetId);
        restTemplate.postForEntity( apiGateway + projetApi + "update/" + projetId, request, String.class);
        return compositionEquipeService(equipeId);
    }

    private Long[] stringToLongArray(String str) {
        String[] strArray = str.split(",");
        return LongStream.range(0, strArray.length)
                .mapToObj(i -> Long.parseLong(strArray[(int) i].trim()))
                .toArray(Long[]::new);
    }

    public String addLongToString(String equipes, Long newEquipe) {
        if(equipes.isBlank()){
            return newEquipe.toString();
        }
        else {
            String newLongStr = newEquipe.toString();
            String[] strArray = equipes.split(",");
            String[] newStrArray = Arrays.copyOf(strArray, strArray.length + 1);
            newStrArray[strArray.length] = newLongStr;
            return String.join(",", newStrArray);
        }
    }
}
