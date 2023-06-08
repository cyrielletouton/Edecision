package org.ipi.projet.controller;

import org.ipi.projet.entity.Projet;
import org.ipi.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class ProjetContoller {
    @Autowired
    private ProjetRepository projetRepository;

    //Create projet
    @PostMapping("/create")
    public ResponseEntity<Projet> createProjet(@RequestBody Projet projet) {
        projetRepository.save(projet);
        return ResponseEntity.ok(projet);
    }

    //Get projets
    @GetMapping("/get")
    public ResponseEntity<List<Projet>> getProjets(){
        List<Projet> projets = projetRepository.findAll();
        return ResponseEntity.ok(projets);
    }
    //Get Projets by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Projet> getProjetById(@PathVariable Long id) {
        Projet projet = projetRepository.findById(id).get();
        return ResponseEntity.ok(projet);
    }
    //Update projet
    @PostMapping("/update/{id}")
    public ResponseEntity<Projet>  updateProjetById(@RequestBody Projet updatedProjet, @PathVariable Long id) {
        Projet projet = projetRepository.findById(id).get();
        updatedProjet.setId(projet.getId());
        projetRepository.save(updatedProjet);
        return ResponseEntity.ok(updatedProjet);
    }

    //Delete projet
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        projetRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }
}
