package org.ipi.proposition.controller;

import org.ipi.proposition.model.Proposition;
import org.ipi.proposition.repository.PropositionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.HashSet;
import java.util.List;

@Controller
public class PropositionController {
    @Autowired
    private PropositionRepository propositionRepository;

    @GetMapping("/propositions")
    public String voirPropositions(Model out){
        List<Proposition> propositions =  propositionRepository.findAll();
        out.addAttribute("propositions", propositions);
        return "voir-propositions";
    }

    @GetMapping("/propositions/equipe/{id}")
    public String voirPropositionsParEquipe(Model out, @PathVariable String id) {
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
        out.addAttribute("propositionProprietaireList",propositionProprietaireList);
        out.addAttribute("propositionScopeList",propositionScopeList);
        return "voir-proposition";
    }
}
