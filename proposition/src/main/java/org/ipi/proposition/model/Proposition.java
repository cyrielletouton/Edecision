package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;
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
    @Column(name = "problematique")
    private String problematique;
    @Column(name = "commentaire")
    private String commentaire;
    @Column(name = "status")
    private String status;
    @Column(name = "ESTACCEPTE")
    private boolean estAccepte;
    @Column(name = "impact")
    private int impact;
    @Column(name = "MAXVOTE")
    private int maxVote;
    @Column(name = "NBRVOTE")
    private int nbrVote;
    //Liste d'utilisateurs
    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "PROPRIETAIRE", joinColumns = @JoinColumn(name = "PROPOSITION_ID"))
    @Column(name = "PROPRIETAIRE_ID")
    private List<String> proprietaires;
    //Liste d'équipes
    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "SCOPE", joinColumns = @JoinColumn(name = "PROPOSITION_ID"))
    @Column(name = "SCOPE_ID")
    private List<String> scope;
    @Column(name = "DATEDEPOT")
    private LocalDate dateDepot;

    public void escalade(){

    }
}
