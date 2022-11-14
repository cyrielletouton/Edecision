package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import java.util.List;

//Specify that a class is an entity
@Entity
//Annotations from lombok, generates getters, setters and a constructor without argument
@Getter
@Setter
@NoArgsConstructor
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
    @Column
    private List<String> proprietaires;
    @Column
    private List<String> equipe;
}
