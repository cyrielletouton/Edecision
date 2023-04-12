package org.ipi.proposition.controller;

import org.ipi.proposition.model.Proposition;
import org.ipi.proposition.repository.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class PropositionController {
    @Autowired
    private PropositionRepository propositionRepository;

    //Create proposition
    @PostMapping("/create")
    public ResponseEntity<Proposition> create(@RequestBody Proposition proposition){
        propositionRepository.save(proposition);
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
//    @GetMapping("/get/byEquipe/{id}")
//    public ResponseEntity<List<Proposition>> getPropositionByEquipeId(@PathVariable String id) {
//        List<Proposition> propositions = propositionRepository.findAll();
//
//        //Find proposition by equipe id
//        List<Proposition> propositionProprietaireList = new ArrayList<>();
//        for (Proposition proposition : propositions){
//            String proprietaireID = proposition.getProprietaire();
//                if (proprietaireID.equals(id)){
//                    propositionProprietaireList.add(proposition);
//            }
//        }
//        return ResponseEntity.ok(propositionProprietaireList);
//    }
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


    /*
    @PostMapping("/create/equipe/creer-proposition")
    public String creerProposition(@ModelAttribute Proposition proposition){
        propositionRepository.save(proposition);
        return "redirect:/propositions";
    }


    @GetMapping("/getHTML")
    public String voirPropositions(Model out){
        List<Proposition> propositions =  propositionRepository.findAll();
        out.addAttribute("propositions", propositions);
        return "voir-propositions";
    }


    @GetMapping("/delete/supprimer-proposition/{id}")
    public String supprimerProposition(@PathVariable Long id){
        propositionRepository.deleteById(id);
        return "redirect:/propositions";
    }

    @GetMapping("/get/equipe/{id}")
    public String voirPropositionsParEquipeHTML(Model out, @PathVariable String id) {
        List<Proposition> propositions = propositionRepository.findAll();
        ///// TROUVE TOUTES LES PROPOSITIONS PAR PROPRIETAIRE /////
        HashSet<Proposition> propositionProprietaireList = new HashSet<>();
        for (Proposition proposition : propositions){
            for (String proprietaireID : proposition.getProprietaires()){
                if (proprietaireID.equals(id)){
                    propositionProprietaireList.add(proposition);
                }
            }
        }
        ///// TROUVE TOUTES LES PROPOSITIONS PAR SCOPE /////
        HashSet<Proposition> propositionScopeList = new HashSet<>();
        for (Proposition proposition : propositions){
            for (String scopeID : proposition.getScope()){
                if (scopeID.equals(id)){
                    propositionScopeList.add(proposition);
                }
            }
        }
        out.addAttribute("idUtilisateur", id);
        out.addAttribute("propositionProprietaireList",propositionProprietaireList);
        out.addAttribute("propositionScopeList",propositionScopeList);
        return "voir-proposition";
    }

        @GetMapping("/delete/{id}")
    public ResponseEntity<Long> supprimerProposition(@PathVariable Long id){
        propositionRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

    @GetMapping("/update/equipe/{idUtilisateur}/modifier-proposition/{idProposition}")
    public String modifierPropositionFormulaire(Model out, @PathVariable String idUtilisateur, @PathVariable Long idProposition){
        Proposition propositionParID = propositionRepository.findById(idProposition).get();
        List<Proposition> propositionList = propositionRepository.findAll();
        ///// TROUVER TOUS LES UTILISATEURS ET STATUS DISPONIBLES /////
        HashSet<String> proprietairesList = new HashSet<>();
        HashSet<Status> statusList = new HashSet<>();
        for (Proposition proposition : propositionList){
            proprietairesList.addAll(proposition.getProprietaires());
            statusList.addAll(Collections.singleton(proposition.getStatus()));
        }
        out.addAttribute("proprietaires", proprietairesList);
        out.addAttribute("tousStatus", statusList);
        out.addAttribute("propositionList", propositionList);
        out.addAttribute("proposition", propositionParID);
        return "modifier-proposition";
    }

        @GetMapping("/create/equipe/{id}/creer-proposition")
    public String creerPropositionFormulaire(Model out, @PathVariable String id){
        List<Proposition> propositionList = propositionRepository.findAll();
        ///// TROUVER TOUS LES UTILISATEURS ET STATUS DISPONIBLES /////
        HashSet<String> utilisateursList = new HashSet<>();
        HashSet<Status> statusList = new HashSet<>();
        for (Proposition proposition : propositionList){
            utilisateursList.addAll(proposition.getProprietaires());
            statusList.addAll(Collections.singleton(proposition.getStatus()));
        }
        out.addAttribute("proprietaireID", id);
        out.addAttribute("utilisateursList", utilisateursList);
        out.addAttribute("tousStatus", statusList);
        out.addAttribute("proposition", new Proposition());
        return "creer-proposition";
    }

        @GetMapping("/delete/{id}")
    public ResponseEntity<Long> supprimerProposition(@PathVariable Long id){
        propositionRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

        @GetMapping("/get/equipe/{id}")
    public ResponseEntity<List<Proposition>> voirPropositionsParEquipe(Model out, @PathVariable String id) {
        List<Proposition> propositions = propositionRepository.findAll();
        ///// TROUVE TOUTES LES PROPOSITIONS PAR PROPRIETAIRE /////
        HashSet<Proposition> propositionProprietaireList = new HashSet<>();
        for (Proposition proposition : propositions){
            for (String proprietaireID : proposition.getProprietaires()){
                if (proprietaireID.equals(id)){
                    propositionProprietaireList.add(proposition);
                }
            }
        }
        ///// TROUVE TOUTES LES PROPOSITIONS PAR SCOPE /////
        HashSet<Proposition> propositionScopeList = new HashSet<>();
        for (Proposition proposition : propositions){
            for (String scopeID : proposition.getScope()){
                if (scopeID.equals(id)){
                    propositionScopeList.add(proposition);
                }
            }
        }
        out.addAttribute("idUtilisateur", id);
        out.addAttribute("propositionProprietaireList",propositionProprietaireList);
        out.addAttribute("propositionScopeList",propositionScopeList);
        return ResponseEntity.ok(propositions);
    }

        @PostMapping("/update/equipe/modifier-proposition")
    public String modifierPropositionParID(@ModelAttribute Proposition model, @RequestParam Long id){
        Proposition proposition = propositionRepository.findById(id).get();
        proposition.setProblematique(model.getProblematique());
        proposition.setCommentaire(model.getCommentaire());
        proposition.setStatus(model.getStatus());
        proposition.setEstAccepte(model.isEstAccepte());
        proposition.setMaxVote(model.getMaxVote());
        proposition.setProprietaires(model.getProprietaires());
        propositionRepository.save(proposition);
        return "redirect:/propositions";
    }

     */

}
