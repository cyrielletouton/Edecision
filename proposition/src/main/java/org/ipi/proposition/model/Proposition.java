package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Proposition extends PropositionGenerale{

    private String problematique;
    private String commentaire;
    private String status;
    private boolean estAccepte;
    private int impact;
    private int maxVote;
    private int nbrVote;
    private List<String> proprietaires;
    private List<String> equipe;
}
