package org.ipi.vote.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "VOTES")
@ToString
public class Vote {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private VoteStatut voteStatut;
    @Column(name = "membre", nullable = false)
    private Long utilisateur;
    @Column(name = "proposition", nullable = false)
    private Long proposition;

    private void consulterResultats(){

    }

    private void voter(){

    }
}
