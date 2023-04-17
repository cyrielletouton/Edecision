package org.ipi.equipe.controller;

import org.ipi.equipe.model.CompositionEquipe;
import org.ipi.equipe.model.entity.Equipe;
import org.ipi.equipe.repository.EquipeRepository;
import org.ipi.equipe.service.EquipeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

//Base path is /api/equipe/
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;
    @Autowired
    private EquipeService equipeService;

    //Create équipe
    @PostMapping("/create")
    public ResponseEntity<Equipe> createEquipe(@RequestBody Equipe equipe) {
        equipeRepository.save(equipe);
        return ResponseEntity.ok(equipe);
    }
    //Get équipes
    @GetMapping("/get")
    public ResponseEntity<List<Equipe>> getEquipe(){
        List<Equipe> equipeList = equipeRepository.findAll();
        return ResponseEntity.ok(equipeList);
    }
    //Get équipes by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Equipe> getEquipeById(@PathVariable Long id){
        Equipe equipe = equipeRepository.findById(id).get();
        return ResponseEntity.ok(equipe);
    }
    @GetMapping("/get/{id}/composition")
    public ResponseEntity<CompositionEquipe> getCompositionEquipe(@PathVariable Long id){
        return ResponseEntity.ok(equipeService.compositionEquipeService(id));

    }
    //Update équipe
    @PostMapping("/update/{id}")
    public ResponseEntity<Equipe> updateEquipeById(@RequestBody Equipe updatedEquipe, @PathVariable Long id){
        Equipe equipe = equipeRepository.findById(id).get();
        updatedEquipe.setId(equipe.getId());
        equipeRepository.save(updatedEquipe);
        return ResponseEntity.ok(updatedEquipe);
    }
    //Delete equipe
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> deleteEquipe(@PathVariable Long id){
        equipeRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/createMany")
    public ResponseEntity<Equipe[]> createMembres(@RequestBody Equipe[] equipes){
        equipeRepository.saveAll(Arrays.asList(equipes));
        return ResponseEntity.ok(equipes);
    }

    @PostMapping("/give/{equipeId}/projet/{projetId}")
    public ResponseEntity<CompositionEquipe> giveProjetToEquipe(@PathVariable Long equipeId, @PathVariable Long projetId){
        return ResponseEntity.ok(equipeService.updateProjetWithEquipe(equipeId, projetId));
    }
}
