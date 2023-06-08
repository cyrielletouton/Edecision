package org.ipi.proposition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.ipi.proposition.entity.misc.PropositionStatut;
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
    private PropositionStatut statut;
    private boolean estAccepte;
    private int maxVote;
    private int nbrVote;
    private int nbrAbstention;
    private long proprietaire;
    private Long projetId;
    private List<Long> equipes;
    private String votants;
}
