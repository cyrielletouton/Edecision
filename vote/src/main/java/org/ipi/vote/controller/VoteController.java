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
        boolean createVote = voteService.updatePropositionAfterVote(vote.getProposition(), vote.getMembre(), vote.getEquipe(), vote.getVoteStatut());

        if(createVote) {
            voteRepository.save(vote);
            logger.info("Vote saved:" + vote.toString());
            return ResponseEntity.ok(vote);
        } else {
            return ResponseEntity.notFound().build();
        }
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
}
