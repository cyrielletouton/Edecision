package org.ipi.vote.model;

import java.util.List;

public class PropositionDto {
    public Long id;
    public String titre;
    public String description;
    public statutDto statu;
    public boolean estAccepte;
    public int maxVote;
    public int nbrVote;
    public int proprietaire;
    public List<Integer> equipes;
//    private Date dateDepot;
}
