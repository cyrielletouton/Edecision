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
    @Column(name = "problematique", nullable = false)
    private String problematique;
    @Column(name = "commentaire")
    private String commentaire;
    @Enumerated(EnumType.STRING)
    @Column(name = "status", nullable = false)
    private Status status;
    @Column(name = "ESTACCEPTE", nullable = false)
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
    private Date dateDepot;

    public void escalade(){

    }
}
