package org.ipi.vote.controller;

import org.ipi.vote.model.Vote;
import org.ipi.vote.repository.VoteRepository;
import org.ipi.vote.service.VoteService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:8080")
public class VoteController {

    Logger logger = LoggerFactory.getLogger(VoteController.class);
    @Autowired
    private VoteRepository voteRepository;
    @Autowired
    private VoteService voteService;

    //Create vote
    @PostMapping("/create")
    public ResponseEntity<Vote> createVote(@RequestBody Vote vote){
        voteRepository.save(vote);
        logger.info("Vote saved:" + vote.toString());
        logger.info(vote.getProposition().toString());
        voteService.updatePropositionAfterVote(vote.getProposition(), vote.getMembre());

        return ResponseEntity.ok(vote);
    }

    //Get votes
    @GetMapping("/get")
    public ResponseEntity<List<Vote>> getVotes(){
        List<Vote> votes = voteRepository.findAll();
        logger.info("Votes:" + votes.toString());
        return ResponseEntity.ok(votes);
    }
    //Get vote by id
    @GetMapping("/get/{id}")
    public ResponseEntity<Vote> getVoteById(@PathVariable Long id){
        Vote vote = voteRepository.findById(id).get();
        return ResponseEntity.ok(vote);
    }
    //Get votes by user id
    @GetMapping("/get/byUser/{id}")
    public ResponseEntity<List<Vote>> getVotesByUserId(@PathVariable Long id){
        List<Vote> votes = voteRepository.findAllByMembre(id);
        return ResponseEntity.ok(votes);
    }
    //Get votes by proposition id
    @GetMapping("/get/byPropositionId/{id}")
    public ResponseEntity<List<Vote>> getVotesByPropositionId(@PathVariable Long id){
        List<Vote> votes = voteRepository.findAllByProposition(id);
        return ResponseEntity.ok(votes);
    }
    //Update vote by id
    @PostMapping("/update/{id}")
    public ResponseEntity<Vote> updateById(@RequestBody Vote updatedVote, @RequestParam Long id){
        Vote vote = voteRepository.findById(id).get();
        updatedVote.setId(vote.getId());
        voteRepository.save(updatedVote);
        return ResponseEntity.ok(updatedVote);
    }

    //Delete vote
    @GetMapping("/delete/{id}")
    public ResponseEntity<Long> delete(@PathVariable Long id){
        voteRepository.deleteById(id);
        return ResponseEntity.ok(id);
    }

//    @GetMapping("/ok")
//    public ResponseEntity<String> ok(){
//        voteService.updatePropositionAfterVote("1", 1);
//        return ResponseEntity.ok("ok");
//    }


    /*
        @GetMapping("/get")
    public String voirVotes(Model out){
        List<Vote> votes = voteRepository.findAll();
        out.addAttribute("votes",votes);
        return "voir-votes";
    }
        @GetMapping("/get/utilisateur/{id}")
    public String voirVotesParUtilisateur(Model out, @PathVariable String id){
        List<Vote> votes = voteRepository.findAllByUtilisateur(id);
        out.addAttribute("user", id);
        out.addAttribute("votes",votes);
        return "voir-vote";
    }

        @GetMapping("/create/utilisateur/{id}/creer-vote")
    public String creerVoteParUtilisateurPourPropositionGet(Model out, @PathVariable String id){
        List<Vote> votesList = voteRepository.findAll();
        List<Vote> votesUtilisateur = voteRepository.findAllByUtilisateur(id);
        ////////// RECUPERER TOUTES LES PROPOSITIONS DISPONIBLES //////////
        ////////// RECUPERER TOUTES LES statut DE VOTE UTILISATEUR DISPONIBLES //////////
        // TODO: RECUPERER LES PROPOSITIONS DISPONIBLES POUR L'UTILISATEUR ET NON GLOBALES //
        HashSet<String> propositionList = new HashSet<>();
        HashSet<VoteStatut> statuVoteList = new HashSet<>();
        for (Vote vote : votesList) {
            statuVoteList.add(vote.getVoteStatut());
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
        out.addAttribute("statuVoteList",statuVoteList);
        out.addAttribute("vote",new Vote());
        return "creer-vote";
    }

    @PostMapping("/create/utilisateur/creer-vote")
    public String creerVoteParUtilisateurPourProposition(@ModelAttribute Vote vote){
        voteRepository.save(vote);
        return "redirect:/votes";
    }

    @GetMapping("/getVotePourPropositionHTML/{id}")
    public String voirVotesParPropositionHTML(Model out, @PathVariable String id){
        List<Vote> votes = voteRepository.findAllByProposition(id);
        out.addAttribute("votes",votes);
        return "voir-vote";
    }

        @PostMapping("/update/{id}")
    public ResponseEntity<Vote> updateByPropositionId(@RequestBody Vote updatedVote, @RequestParam Long id){
        List<Vote> votes = voteRepository.findAllByProposition(id);
        updatedVote.setId(votes.getId());
        voteRepository.save(updatedVote);
        return ResponseEntity.ok(updatedVote);
    }

     */
}
