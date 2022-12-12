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
@Table(name = "VOTES")
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VoteStatut voteStatut;
    @Column(name = "statusutilisateur ", nullable = false)
    private String statusUtilisateur;
    @Column(name = "utilisateur", nullable = false)
    private String utilisateur;
    @Column(name = "proposition", nullable = false)
    private String proposition;

    private void consulterResultats(){

    }

    private void voter(){

    }
}
