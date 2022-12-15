package org.ipi.equipe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

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

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEquipe typeEquipe;

    @Column(name = "utilisateur")
    private String utilisateur;

    @Column(name = "projet")
    private String projet;

    @Column(name = "derniereProposition")
    private Date derniereProposition;

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
