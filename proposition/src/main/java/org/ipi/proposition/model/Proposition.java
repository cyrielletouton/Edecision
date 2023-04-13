package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.sql.Date;
import java.time.LocalDate;
import java.util.List;

//Specify that a class is an entity
@Entity
//Annotations from lombok, generates getters, setters and a constructor without argument
@Getter
@Setter
@NoArgsConstructor
@Component
@Table(name = "PROPOSITIONS")
public class Proposition extends PropositionGenerale{
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
    private statut statut;
    @Column(name = "ESTACCEPTE", nullable = false)
    private boolean estAccepte;
    @Column(name = "MAXVOTE")
    private int maxVote;
    @Column(name = "NBRVOTE")
    private int nbrVote;
    @Column(name = "PROPRIETAIRE")
    private int proprietaire;
    //Liste d'équipes
    @ElementCollection(targetClass=Integer.class)
    @CollectionTable(name = "EQUIPES", joinColumns = @JoinColumn(name = "PROPRIETAIRE"))
    @Column(name = "EQUIPE_ID")
    private List<Integer> equipes;
    @ElementCollection(targetClass=Long.class)
    @CollectionTable(name = "VOTANTS", joinColumns = @JoinColumn(name = "EQUIPE_ID"))
    @Column(name = "VOTANTS_ID")
    private List<Long> votants;
//    @Column(name = "DATEDEPOT")
//    private Date dateDepot;

    public void escalade(){

    }
}
