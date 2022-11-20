package org.ipi.utilisateurs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "mdp", nullable = false)
    private String mdp;
    @Column(name = "propositions", nullable = false)
    @ElementCollection
    private List<String> propositions;
    @Column(name = "equipes", nullable = false)
    @ElementCollection
    private List<String> equipes;

    public void details(){

    }
}
