package org.ipi.vote.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
public class CompositionPropositionModel {
    private Long id;
    private String titre;
    private String description;
    private PropositionStatutModel statut;
    private boolean estAccepte;
    private int maxVote;
    private int nbrVote;
    private int nbrAbstention;
    private long proprietaire;
    private Long projetId;
    private List<Long> equipes;
    private String votants;
}
