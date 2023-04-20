package org.ipi.equipe.service;

import org.ipi.equipe.model.CompositionEquipe;
import org.ipi.equipe.model.dto.ProjetDTO;
import org.ipi.equipe.model.entity.Equipe;
import org.ipi.equipe.model.dto.MembresDTO;
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
import java.util.Objects;
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

    public CompositionEquipe compositionEquipeService(Long id) {
        List<Long> membresIds = new ArrayList<>();
        List<Long> projetsId = new ArrayList<>();
        CompositionEquipe composition = new CompositionEquipe();

        Equipe equipe = equipeRepository.findById(id).get();
        composition.setTypeEquipe(equipe.getTypeEquipe());
        composition.setId(equipe.getId());

        MembresDTO[] membres = restTemplate.getForEntity(apiGateway + membresApi + "get", MembresDTO[].class).getBody();
        for (MembresDTO membre : membres) {
            Long idMembre = membre.getId();
            Long equipeId = membre.getEquipe();
            if (equipeId == id){
                membresIds.add(idMembre);
            }
        }
        composition.setMembres(membresIds);
        ProjetDTO[] projets = restTemplate.getForEntity(apiGateway + projetApi + "get", ProjetDTO[].class).getBody();
        for (ProjetDTO projet : projets) {
            Long projetId = projet.getId();
            for (Long equipeId : stringToLongArray(projet.getEquipes())) {
                if( equipeId == id){
                    projetsId.add(projetId);
                }
            }
        }
        composition.setProjets(projetsId);
        return composition;
    }

    public CompositionEquipe updateProjetWithEquipe(Long equipeId, Long projetId){
        ProjetDTO projet = restTemplate.getForEntity(apiGateway + projetApi + "get/" + projetId, ProjetDTO.class).getBody();
        if(projet != null){
            projet.setEquipes(addLongToString(projet.getEquipes(), equipeId));
        }
        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);
        HttpEntity<ProjetDTO> request = new HttpEntity<>(projet, headers);
        logger.info(apiGateway + projetApi + "/update/" + projetId);
        restTemplate.postForEntity( apiGateway + projetApi + "/update/" + projetId, request, String.class);
        return compositionEquipeService(equipeId);
    }

    private Long[] stringToLongArray(String str) {
        String[] strArray = str.split(",");
        return LongStream.range(0, strArray.length)
                .mapToObj(i -> Long.parseLong(strArray[(int) i].trim()))
                .toArray(Long[]::new);
    }

    public static String addLongToString(String equipes, Long newEquipe) {
        String newLongStr = newEquipe.toString();
        String[] strArray = equipes.split(",");
        String[] newStrArray = Arrays.copyOf(strArray, strArray.length + 1);
        newStrArray[strArray.length] = newLongStr;
        return String.join(",", newStrArray);
    }
}
