package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.ElementCollection;
import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.List;

//Specify that a class is an entity
@Entity
//Annotations from lombok, generates getters, setters and a constructor without argument
@Getter
@Setter
@NoArgsConstructor
@Table(name = "PROPOSITIONS")
public class Proposition extends PropositionGenerale{

    @Column
    private String problematique;
    @Column
    private String commentaire;
    @Column
    private String status;
    @Column
    private boolean estAccepte;
    @Column
    private int impact;
    @Column
    private int maxVote;
    @Column
    private int nbrVote;
    //Liste d'utilisateurs
    @Column
    @ElementCollection
    private List<String> proprietaires;
    //Liste d'équipes
    @Column
    @ElementCollection
    private List<String> scope;

    public void escalade(){

    }
}
