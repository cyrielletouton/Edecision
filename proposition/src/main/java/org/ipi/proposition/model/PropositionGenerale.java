package org.ipi.proposition.model;


import javax.persistence.*;

@MappedSuperclass
@Table(name = "PROPOSITIONS_GENERALES")
public abstract class PropositionGenerale {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column
    private int proposition;

    @Column
    private int amendement;


    public void soumettre(){

    }

    public void retirer(){

    }

    public void rejeter(){

    }
    public void definirPortee(){

    }

}
