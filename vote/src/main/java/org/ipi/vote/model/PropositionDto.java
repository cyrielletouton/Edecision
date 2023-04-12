package org.ipi.vote.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class PropositionDto {
    public Long id;
    public String titre;
    public String description;
    public StatusDto status;
    public boolean estAccepte;
    public int maxVote;
    public int nbrVote;
    public int proprietaire;
    public List<Integer> equipes;
//    private Date dateDepot;
}
