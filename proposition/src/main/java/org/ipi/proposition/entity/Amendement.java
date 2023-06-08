package org.ipi.proposition.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ipi.proposition.entity.misc.PropositionGenerale;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "AMENDEMENTS")
public class Amendement extends PropositionGenerale {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "contenu", nullable = false)
    private String contenu;

    public void amender(){

    }
}
