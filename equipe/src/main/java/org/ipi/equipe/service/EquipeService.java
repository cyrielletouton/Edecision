package org.ipi.equipe.service;

import org.ipi.equipe.model.CompositionEquipe;
import org.ipi.equipe.model.entity.Equipe;
import org.ipi.equipe.model.dto.MembresDTO;
import org.ipi.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@Component
public class EquipeService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.membres}")
    private String membresApi;
    RestTemplate restTemplate = new RestTemplate();
    @Autowired
    private EquipeRepository equipeRepository;

    public CompositionEquipe compositionEquipeService(Long id) {
        List<Long> membresIds = new ArrayList<>();
        CompositionEquipe composition = new CompositionEquipe();

        Equipe equipe = equipeRepository.findById(id).get();
        composition.setTypeEquipe(equipe.getTypeEquipe());
        composition.setId(equipe.getId());
        composition.setDerniereProposition(equipe.getDerniereProposition());
        composition.setProjets(equipe.getProjets());

        MembresDTO[] membres = restTemplate.getForEntity(apiGateway + membresApi + "get", MembresDTO[].class).getBody();
        for (MembresDTO membre : membres) {
            Long idMembre = membre.getId();
            Long equipeId = membre.getEquipe();
            if (equipeId == id){
                membresIds.add(idMembre);
            }
        }
        composition.setMembres(membresIds);
        return composition;
    }
}
