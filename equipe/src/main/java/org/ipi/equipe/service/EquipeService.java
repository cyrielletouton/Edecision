package org.ipi.equipe.service;

import org.ipi.equipe.model.dto.MembresDTO;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

@Component
public class EquipeService {

    @Value("${api.gateway}")
    private String apiGateway;
    @Value("${api.membres}")
    private String membresApi;

    RestTemplate restTemplate = new RestTemplate();

    public ResponseEntity<MembresDTO[]> getEquipe(){
        return UpdateEquipe();
    }

    private ResponseEntity<MembresDTO[]> UpdateEquipe(){

        return restTemplate.getForEntity(apiGateway + membresApi + "get" , MembresDTO[].class);
    }
}
