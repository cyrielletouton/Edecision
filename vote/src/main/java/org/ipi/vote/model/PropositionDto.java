package org.ipi.vote.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class PropositionDto {
    private Long id;
    private String titre;
    private String description;
    private StatusDto status;
    private boolean estAccepte;
    private int maxVote;
    private int nbrVote;
    private int proprietaire;
    private List<Integer> equipes;
//    private Date dateDepot;
}
