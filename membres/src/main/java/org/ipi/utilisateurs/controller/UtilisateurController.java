package org.ipi.utilisateurs.controller;

import org.ipi.utilisateurs.model.Utilisateur;
import org.ipi.utilisateurs.repository.MembresRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Controller
public class UtilisateurController {

    @Autowired
    private MembresRepository membresRepository;

    @GetMapping("/utilisateurs")
    public String voirUtilisateurs(Model out){
        List<Utilisateur> utilisateursList = membresRepository.findAll();
        out.addAttribute("utilisateurs", utilisateursList);
        return "voir-utilisateurs";
    }

    @GetMapping("/utilisateurs/utilisateur/{id}")
    public String voirUtilisateurParID(Model out, @PathVariable Long id){
        Utilisateur utilisateur = membresRepository.findById(id).get();
        out.addAttribute("utilisateur",utilisateur);
        return "voir-utilisateur";
    }

    @GetMapping("/utilisateurs/utilisateur/{id}/modifier-utilisateur")
    public String modifierUtilisateurFormulaire(Model out,@PathVariable Long id){
        List<Utilisateur> utilisateurList = membresRepository.findAll();
        Utilisateur utilisateur = membresRepository.findById(id).get();
        ///// TROUVE TOUTES LES EQUIPES DISPONIBLES /////
        ///// TROUVE TOUTES LES PROPOSITIONS DISPONIBLES /////
        HashSet<String> equipesListe = new HashSet<>();
        HashSet<String> propositionsListe = new HashSet<>();
        for (Utilisateur utilisateurItem : utilisateurList){
            equipesListe.addAll(utilisateurItem.getEquipes());
            propositionsListe.addAll(utilisateurItem.getPropositions());
        }
        out.addAttribute("utilisateur", utilisateur);
        out.addAttribute("equipesListe", equipesListe);
        out.addAttribute("propositionsListe", propositionsListe);

        return "modifier-utilisateur";
    }

    @PostMapping("/utilisateurs/utilisateur/{id}/modifier-utilisateur")
    public String modifierUtilisateur(@ModelAttribute Utilisateur utilisateurData, @PathVariable Long id){
        Utilisateur utilisateur = membresRepository.findById(id).get();
        utilisateur.setNom(utilisateurData.getNom());
        utilisateur.setMdp(utilisateurData.getMdp());
        utilisateur.setPropositions(utilisateurData.getPropositions());
        utilisateur.setEquipes(utilisateurData.getEquipes());
        membresRepository.save(utilisateur);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/utilisateurs/utilisateur/{id}/supprimer-utilisateur")
    public String supprimerUtilisateur(@PathVariable Long id){
        membresRepository.deleteById(id);
        return "redirect:/utilisateurs";
    }

    @GetMapping("/utilisateurs/creer-utilisateur")
    public String creerUtilisateurFormulaire(Model out){
        List<Utilisateur> utilisateursListe = membresRepository.findAll();
        ///// TROUVER TOUTES LES EQUIPES ET PROPOSITIONS DISPONIBLES /////
        HashSet<String> equipesListe = new HashSet<>();
        HashSet<String> propositionsListe = new HashSet<>();
        for (Utilisateur utilisateur : utilisateursListe){
            equipesListe.addAll(utilisateur.getEquipes());
            propositionsListe.addAll(utilisateur.getPropositions());
        }
        out.addAttribute("equipesListe", equipesListe);
        out.addAttribute("propositionsListe", propositionsListe);
        out.addAttribute("utilisateur", new Utilisateur());
        return "creer-utilisateur";
    }

    @PostMapping("/utilisateurs/creer-utilisateur")
    public String creerUtilisateur(@ModelAttribute Utilisateur utilisateur) {
        membresRepository.save(utilisateur);
        return "redirect:/utilisateurs";
    }
}
