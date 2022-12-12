package org.ipi.vote.controller;

import org.ipi.vote.model.Vote;
import org.ipi.vote.repository.VoteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
        out.addAttribute("votes",votes);
        return "voir-vote";
    }

    @GetMapping("/votes/proposition/{id}")
    public String voirVotesParProposition(Model out, @PathVariable String id){
        List<Vote> votes = voteRepository.findAllByProposition(id);
        out.addAttribute("votes",votes);
        return "voir-vote";
    }
}
