package org.ipi.equipe.controller;

import org.ipi.equipe.model.Equipe;
import org.ipi.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

//Base path is /api/equipe/
@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;

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
    //Update équipe
    @PostMapping("/update/{id}")
    public ResponseEntity<Equipe> updateMembre(@RequestBody Equipe updatedEquipe, @PathVariable Long id){
        Equipe membres = equipeRepository.findById(id).get();
        updatedEquipe.setId(membres.getId());
        equipeRepository.save(updatedEquipe);
        return ResponseEntity.ok(updatedEquipe);
    }
    //Delete equipe
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> deleteEquipe(@PathVariable Long id){
        equipeRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

/*
    @GetMapping("/update/{id}/modifier-equipe")
    public String modifierEquipeFormulaire(Model out, @PathVariable Long id){
        Equipe equipe = equipeRepository.findById(id).get();
        ///// TROUVE TOUS LES UTILISATEURS DISPONIBLES /////
        ///// TROUVE TOUS LES PROJETS DISPONIBLES /////
        List<Equipe> equipeList = equipeRepository.findAll();
        HashSet<String> utilisateursList = new HashSet<>();
        HashSet<String> findAllProjet = new HashSet<>();
        for (Equipe equipeElmt : equipeList) {
            utilisateursList.addAll(equipeElmt.getUtilisateurs());
            //TODO: A voir si ça fonctionne vraiment si projet attribué à aucun utilisateur
            findAllProjet.addAll(equipeElmt.getProjets());
        }

        out.addAttribute("findAllProjet", findAllProjet);
        out.addAttribute("equipe", equipe);
        out.addAttribute("tousUtilisateurs", utilisateursList);
        return "modifier-equipe";
    }

    @GetMapping("/getHTML")
    public String voirEquipes(Model out){
        List<Equipe> equipeList = equipeRepository.findAll();
        out.addAttribute("equipes", equipeList);
        return "voir-equipes";
    }

 */
}
