package org.ipi.vote.model;

import java.util.List;

public class PropositionDto {
    public Long id;
    public String titre;
    public String description;
    public propositionStatutDto statut;
    public boolean estAccepte;
    public int maxVote;
    public int nbrVote;
    public int nbrAbstention;
    public int proprietaire;
    public List<Long> equipes;
    public List<Long> votants;
//    private Date dateDepot;
}
