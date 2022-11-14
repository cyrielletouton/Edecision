package org.ipi.utilisateurs.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id", nullable = false)
    private String id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "mdp", nullable = false)
    private String mdp;
}
