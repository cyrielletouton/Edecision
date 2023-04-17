package org.ipi.membre.controller;

import org.ipi.membre.repository.MembresRepository;
import org.ipi.membre.model.Membre;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Arrays;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class MembresController {

    Logger logger = LoggerFactory.getLogger(MembresController.class);

    @Autowired
    private MembresRepository membresRepository;

    //Create utilisateur
    @PostMapping("/create")
    public ResponseEntity<Membre> createMembre(@RequestBody Membre membre) {
        membresRepository.save(membre);
        return ResponseEntity.ok(membre);
    }
    //Get utilisateurs
    @GetMapping("/get")
    public ResponseEntity<List<Membre>> getMembres(){
        List<Membre> membresList = membresRepository.findAll();
        logger.info(membresList.toString());
        return ResponseEntity.ok(membresList);
    }
    //Get utilisateur by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Membre> getMembresById(@PathVariable Long id){
        Membre membres = membresRepository.findById(id).get();
        return ResponseEntity.ok(membres);
    }
    //Update utilisateur
    @PostMapping("/update/{id}")
    public ResponseEntity<Membre> updateMembre(@RequestBody Membre updatedMembres, @PathVariable Long id){
        Membre membres = membresRepository.findById(id).get();
        updatedMembres.setId(membres.getId());
        membresRepository.save(updatedMembres);
        return ResponseEntity.ok(updatedMembres);
    }

    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> deleteMembre(@PathVariable Long id){
        membresRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @PostMapping("/createMany")
    public ResponseEntity<Membre[]> createMembres(@RequestBody Membre[] membres){
        membresRepository.saveAll(Arrays.asList(membres));
        return ResponseEntity.ok(membres);
    }

    /*
        @GetMapping("/update/{id}/modifier-utilisateur")
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
    @GetMapping("/create/creer-utilisateur")
    public String creerUtilisateurFormulaire(Model out){
        List<Membres> utilisateursListe = membresRepository.findAll();
        ///// TROUVER TOUTES LES EQUIPES ET PROPOSITIONS DISPONIBLES /////
        HashSet<String> equipesListe = new HashSet<>();
        HashSet<String> propositionsListe = new HashSet<>();
        for (Membres membres : utilisateursListe){
            equipesListe.addAll(membres.getEquipes());
            propositionsListe.addAll(membres.getPropositions());
        }
        out.addAttribute("equipesListe", equipesListe);
        out.addAttribute("propositionsListe", propositionsListe);
        out.addAttribute("utilisateur", new Membres());
        return "creer-utilisateur";
    }

     */
}
