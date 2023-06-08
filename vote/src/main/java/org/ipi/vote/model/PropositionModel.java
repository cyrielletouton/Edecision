package org.ipi.vote.model;

public class PropositionModel {
    public Long id;
    public String titre;
    public String description;
    public PropositionStatutModel statut;
    public boolean estAccepte;
    public int maxVote;
    public int nbrVote;
    public int nbrAbstention;
    public long proprietaire;
    public String votants;
//    private Date dateDepot;
}
