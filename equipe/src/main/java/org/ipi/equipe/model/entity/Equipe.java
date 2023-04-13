package org.ipi.equipe.model.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ipi.equipe.model.TypeEquipe;

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
