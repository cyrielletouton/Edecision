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
// TODO : Renommer en CompositionProposition (pas DTO) car ce n'est pas en DTO juste un modèle
public class CompositionPropositionDTO {
    private Long id;
    private String titre;
    private String description;
    private PropositionStatutDTO statut;
    private boolean estAccepte;
    private int maxVote;
    private int nbrVote;
    private int nbrAbstention;
    private long proprietaire;
    private Long projetId;
    private List<Long> equipes;
    private String votants;
}
