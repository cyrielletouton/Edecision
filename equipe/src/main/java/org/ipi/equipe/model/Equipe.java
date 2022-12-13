package org.ipi.equipe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "TEAMS")
public class Equipe {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "typeEquipe", nullable = false)
    private TypeEquipe typeEquipe;

    public void integrerUtilisateur(){

    }

    public void supprimerUtilisateur(){

    }
    public void creerEquipe(){

    }
    public void modifierEquipe(){

    }
    public void supprimerEquipe(){

    }
}
