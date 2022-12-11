package org.ipi.projet.controller;

import org.ipi.projet.model.Projet;
import org.ipi.projet.repository.ProjetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProjetContoller {
    @Autowired
    private ProjetRepository projetRepository;

    @GetMapping("/projets")
    public List<Projet> voirProjets(Model out){
        List<Projet> projets = projetRepository.findAll();
        out.addAttribute("projets", projets);
        return projets;
    }

    @GetMapping("/projet/{id}")
    public Projet voirProjetParId(Model out,@PathVariable Long id) {
        Projet projet = projetRepository.findById(id).get();
        out.addAttribute("projet",projet);
        return projet;
    }

    @PostMapping("/creer-projet")
    public Projet creerProjet(@RequestBody Projet projet) {
        return projetRepository.save(projet);
    }

    @PutMapping("/mettre-a-jour-projet/{id}")
    public Projet aJourProjet(@RequestBody Projet projet, @PathVariable Long id) {
        Projet projetAJour = projetRepository.findById(id).get();
        projetAJour.setNom(projet.getNom());
        projetAJour.setEquipes(projet.getEquipes());
        projetAJour.setPropositions(projet.getPropositions());
        return projetRepository.save(projetAJour);
    }

    @DeleteMapping("projet/{id}")
    public boolean supprimerProjet(@PathVariable Long id){
        projetRepository.deleteById(id);
        return true;
    }
}
