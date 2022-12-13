package org.ipi.proposition.model;


import javax.persistence.*;

@MappedSuperclass
@Table(name = "PROPOSITIONS_GENERALES")
public abstract class PropositionGenerale {
    @Column(name = "proposition")
    private String proposition;
    @Column(name = "amendement")
    private String amendement;


    public void soumettre(){

    }

    public void retirer(){

    }

    public void rejeter(){

    }
    public void definirPortee(){

    }

}
