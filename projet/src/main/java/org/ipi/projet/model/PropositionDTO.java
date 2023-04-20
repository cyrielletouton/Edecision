package org.ipi.projet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class PropositionDTO {
    private Long id;
    private String titre;
    private String description;
    private propositionStatut statut;
    private boolean estAccepte;
    private int maxVote;
    private int nbrVote;
    private int nbrAbstention;
    private int proprietaire;
    private List<Integer> equipes;
    private List<Long> votants;
    private Long projetId;
}
