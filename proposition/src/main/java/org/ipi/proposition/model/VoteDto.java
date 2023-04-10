package org.ipi.proposition.model;

import javax.persistence.*;

public class VoteDto {
    private Long id;
    private String voteStatut;
    private Long utilisateur;
    private Long proposition;
}
