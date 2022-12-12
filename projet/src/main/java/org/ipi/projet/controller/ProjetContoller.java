package org.ipi.projet.controller;

import org.ipi.projet.model.Projet;
import org.ipi.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.HashSet;
import java.util.List;

@Controller
public class ProjetContoller {
    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping("/projets")
    public String voirProjets(Model out){
        List<Projet> projets = projetRepository.findAll();
        out.addAttribute("projets", projets);
        return "voir-projets";
    }

    @GetMapping("/projet/{id}")
    public String voirProjetParId(Model out,@PathVariable Long id) {
        Projet projet = projetRepository.findById(id).get();
        out.addAttribute("projet",projet);
        return "voir-projet";
    }

    @GetMapping("/projets/creer-projet")
    public String creerProjetGet(Model out) {
        List<Projet> projets = projetRepository.findAll();
        HashSet<String> equipes = new HashSet<>();
        HashSet<String> propositions = new HashSet<>();
        for (Projet projet : projets) {
            equipes.addAll(projet.getEquipes());
            propositions.addAll(projet.getPropositions());
        }
        out.addAttribute("equipes", equipes);
        out.addAttribute("propositions", propositions);
        out.addAttribute("projet", new Projet());
        return "creer-projet";
    }

    @PostMapping("/projets/creer-projet")
    public String creerProjet(@ModelAttribute Projet projet) {
        projetRepository.save(projet);
        return "redirect:/projets";
    }

    @GetMapping("/projets/modifier-projet/{id}")
    public String modifierProjetGet(Model out, @PathVariable Long id) {
        Projet projet = projetRepository.findById(id).get();
        List<Projet> projets = projetRepository.findAll();
        HashSet<String> equipes = new HashSet<>();
        HashSet<String> propositions = new HashSet<>();
        for (Projet prj : projets) {
            equipes.addAll(prj.getEquipes());
            propositions.addAll(prj.getPropositions());
        }
        out.addAttribute("equipesList", equipes);
        out.addAttribute("propositionsList", propositions);
        out.addAttribute("projet", projet);
        return "modifier-projet";
    }
    @PostMapping("/projets/modifier-projet")
    public String aJourProjet(@ModelAttribute Projet projet, @RequestParam Long id) {
        Projet projetAJour = projetRepository.findById(id).get();
        projetAJour.setNom(projet.getNom());
        projetAJour.setEquipes(projet.getEquipes());
        projetAJour.setPropositions(projet.getPropositions());
        projetRepository.save(projetAJour);
        return "redirect:/projets";
    }

    @GetMapping("/projets/supprimer-projet/{id}")
    public String supprimerProjet(@PathVariable Long id){
        projetRepository.deleteById(id);
        return "redirect:/projets";
    }
}