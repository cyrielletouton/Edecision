package org.ipi.projet.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private int id;

    @Column
    private String nom;
    @Column
    private List<String> equipes;
    @Column
    private List<String> propositions;

    public void intégrerEquipe(){

    }
    public void supprimerEquipe(){

    }
    public void creerProjet(){

    }
}
