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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "equipes", nullable = false)
    private List<String> equipes;
    @Column(name = "propositions", nullable = false)
    private List<String> propositions;

    public void intégrerEquipe(){

    }
    public void supprimerEquipe(){

    }
    public void creerProjet(){

    }
}
