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
    @Column(name = "statu", nullable = false)
    private VoteStatut voteStatut;
    @Column(name = "membre", nullable = false)
    private Long membre;
    @Column(name = "proposition", nullable = false)
    private Long proposition;
    @Column(name = "equipe", nullable = false)
    private Long equipe;

    private void consulterResultats(){

    }

    private void voter(){

    }
}
