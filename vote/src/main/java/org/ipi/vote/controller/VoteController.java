package org.ipi.vote.controller;

import com.sun.xml.bind.v2.TODO;

import org.ipi.vote.model.Vote;
import org.ipi.vote.model.VoteStatut;
import org.ipi.vote.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.HashSet;
import java.util.List;

@Controller
public class VoteController {
    @Autowired
    private VoteRepository voteRepository;

    @GetMapping("/votes")
    public String voirVotes(Model out){
        List<Vote> votes = voteRepository.findAll();
        out.addAttribute("votes",votes);
        return "voir-votes";
    }

    @GetMapping("/votes/utilisateur/{id}")
    public String voirVotesParUtilisateur(Model out, @PathVariable String id){
        List<Vote> votes = voteRepository.findAllByUtilisateur(id);
        out.addAttribute("user", id);
        out.addAttribute("votes",votes);
        return "voir-vote";
    }
    @GetMapping("/votes/utilisateur/{id}/creer-vote")
    public String creerVoteParUtilisateurPourPropositionGet(Model out, @PathVariable String id){
        List<Vote> votesList = voteRepository.findAll();
        List<Vote> votesUtilisateur = voteRepository.findAllByUtilisateur(id);
        ////////// RECUPERER TOUTES LES PROPOSITIONS DISPONIBLES //////////
        ////////// RECUPERER TOUTES LES STATUS DE VOTE UTILISATEUR DISPONIBLES //////////
        // TODO: RECUPERER LES PROPOSITIONS DISPONIBLES POUR L'UTILISATEUR ET NON GLOBALES //
        HashSet<String> propositionList = new HashSet<>();
        HashSet<VoteStatut> statusVoteList = new HashSet<>();
        for (Vote vote : votesList) {
            statusVoteList.add(vote.getVoteStatut());
            propositionList.add(vote.getProposition());
        }
        ////////// UN UTILISATEUR NE PEUT VOTER QU'UNE FOIS PAS PROPOSITION //////////
        ////////// SUPPRIME LES PROPOSITIONS DOUBLONS //////////
        HashSet<String> toRemove = new HashSet<>();
        for(Vote vote : votesUtilisateur){
            if (propositionList.contains(vote.getProposition())){
                toRemove.add(vote.getProposition());
            }
        }
        propositionList.removeAll(toRemove);
        out.addAttribute("user", id);
        out.addAttribute("propositionList",propositionList);
        out.addAttribute("statusVoteList",statusVoteList);
        out.addAttribute("vote",new Vote());
        return "creer-vote";
    }
    @PostMapping("/votes/utilisateur/creer-vote")
    public String creerVoteParUtilisateurPourProposition(@ModelAttribute Vote vote){
        voteRepository.save(vote);
        return "redirect:/votes";
    }

    @GetMapping("/votes/proposition/{id}")
    public String voirVotesParProposition(Model out, @PathVariable String id){
        List<Vote> votes = voteRepository.findAllByProposition(id);
        out.addAttribute("votes",votes);
        return "voir-vote";
    }
}
