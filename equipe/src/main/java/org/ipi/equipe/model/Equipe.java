package org.ipi.equipe.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.sql.Date;
import java.util.List;

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

    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "UTILISATEUR", joinColumns = @JoinColumn(name = "EQUIPE_ID"))
    @Column(name = "UTILISATEUR_ID")
    private List<String> utilisateurs;

    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "PROJET", joinColumns = @JoinColumn(name = "EQUIPE_ID"))
    @Column(name = "PROJET_ID")
    private List<String> projets;

    @Column(name = "DERNIEREPROPOSITION")
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
