package org.ipi.vote.model;

public class PropositionDto {
    public Long id;
    public String titre;
    public String description;
    public PropositionStatutDTO statut;
    public boolean estAccepte;
    public int maxVote;
    public int nbrVote;
    public int nbrAbstention;
    public long proprietaire;
    public String votants;
//    private Date dateDepot;
}
