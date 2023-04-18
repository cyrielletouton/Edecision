package org.ipi.proposition.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class MembreDTO {
    public Long id;
    public String nom;
    public String mdp;
    public Long equipe;
}
