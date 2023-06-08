package org.ipi.vote.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.ipi.vote.entity.misc.VoteStatut;

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
    @Column(name = "statut", nullable = false)
    private VoteStatut voteStatut;
    @Column(name = "membre", nullable = false)
    private Long membre;
    @Column(name = "proposition", nullable = false)
    private Long proposition;
    @Column(name = "equipe", nullable = false)
    private Long equipe;

}
