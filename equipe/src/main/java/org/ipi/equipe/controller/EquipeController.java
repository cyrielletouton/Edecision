package org.ipi.equipe.controller;

import org.ipi.equipe.model.Equipe;
import org.ipi.equipe.repository.EquipeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;

//Base path is /api/equipe/
@Controller
public class EquipeController {
    @Autowired
    private EquipeRepository equipeRepository;

    @GetMapping("/getHTML")
    public String voirEquipes(Model out){
        List<Equipe> equipeList = equipeRepository.findAll();
        out.addAttribute("equipes", equipeList);
        return "voir-equipes";
    }

    @GetMapping("/get")
    public ResponseEntity<List<Equipe>> getEquipes(Model out){
        List<Equipe> equipeList = equipeRepository.findAll();
        return ResponseEntity.ok(equipeList);
    }

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
}
