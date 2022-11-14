package org.ipi.vote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Vote {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "voteStatut", nullable = false)
    private VoteStatut voteStatut;
    @Column(name = "utilisateurs", nullable = false)
    private List<String> Utilisateurs;
    @Column(name = "propositions", nullable = false)
    private List<String> Propositions;

    private void consulterResultats(){

    }

    private void voter(){

    }
}
