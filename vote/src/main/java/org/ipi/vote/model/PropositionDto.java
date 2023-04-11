package org.ipi.vote.model;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

public class PropositionDto {
    private Long id;
    private String problematique;
    private String commentaire;
    private String status;
    private boolean estAccepte;
    private int impact;
    private int maxVote;
    private int nbrVote;
    private List<String> proprietaires;
    private List<String> scope;
//    private Date dateDepot;
}
