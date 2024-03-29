package org.ipi.proposition.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ipi.proposition.entity.misc.PropositionGenerale;
import org.ipi.proposition.entity.misc.PropositionStatut;

import javax.persistence.*;

//Specify that a class is an entity
@Entity
//Annotations from lombok, generates getters, setters and a constructor without argument
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PROPOSITIONS")
public class Proposition extends PropositionGenerale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "titre", nullable = false)
    private String titre;
    @Column(name = "description")
    private String description;
    @Enumerated(EnumType.STRING)
    @Column(name = "statut", nullable = false)
    private PropositionStatut statut;
    @Column(name = "ESTACCEPTE", nullable = false)
    private boolean estAccepte;
    @Column(name = "MAXVOTE")
    private int maxVote;
    @Column(name = "NBRVOTE")
    private int nbrVote;
    @Column(name= "NBRABSTENTION")
    private int nbrAbstention;
    @Column(name = "PROPRIETAIRE")
    private long proprietaire;
    @Column(name = "PROJETID")
    private Long projetId;
    @Column(name = "VOTANTS")
    private String votants;
}
