package org.ipi.proposition.controller;

import org.ipi.proposition.model.Proposition;
import org.ipi.proposition.repository.PropositionRepository;
import org.ipi.proposition.service.PropositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PropositionController {
    @Autowired
    private PropositionRepository propositionRepository;
    @Autowired
    private PropositionService propositionService;

    //Create proposition
    @PostMapping("/create")
    public ResponseEntity<Proposition> create(@RequestBody Proposition proposition){
        propositionRepository.save(proposition);
        propositionService.updateProjetOfProposition(proposition.getId());
        return ResponseEntity.ok(proposition);
    }
    //Get all proposition
    @GetMapping("/get")
    public ResponseEntity<List<Proposition>> getAll(){
        List<Proposition> propositions =  propositionRepository.findAll();
        return ResponseEntity.ok(propositions);
    }
    //Get proposition by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Proposition> getById(@PathVariable("id") long id){
        Proposition proposition =  propositionRepository.findById(id).get();
        return ResponseEntity.ok(proposition);
    }
    // TODO : to test, not if its works
    @GetMapping("/get/byEquipe/{id}")
    public ResponseEntity<List<Proposition>> getPropositionByEquipeId(@PathVariable int id) {
        List<Proposition> propositions = propositionRepository.findAll();

        //Find proposition by equipe id
        List<Proposition> propositionProprietaireList = new ArrayList<>();
        for (Proposition proposition : propositions){
            int proprietaireID = proposition.getProprietaire();
                if (proprietaireID == id){
                    propositionProprietaireList.add(proposition);
            }
        }
        return ResponseEntity.ok(propositionProprietaireList);
    }
    //Update proposition by id
    @PostMapping("/update/{id}")
    public ResponseEntity<Proposition> updateById(@RequestBody Proposition updatedProposition, @PathVariable Long id){
        Proposition proposition = propositionRepository.findById(id).get();
        updatedProposition.setId(proposition.getId());
        propositionRepository.save(updatedProposition);
        return ResponseEntity.ok(updatedProposition);
    }
    //Delete proposition by id
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        propositionRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
