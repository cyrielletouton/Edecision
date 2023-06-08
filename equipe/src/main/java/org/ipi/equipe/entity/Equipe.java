package org.ipi.equipe.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.ipi.equipe.model.TypeEquipeModel;

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

    @Column(name="name", nullable = false)
    private String name;

    @Enumerated(EnumType.STRING)
    @Column(name = "type", nullable = false)
    private TypeEquipeModel typeEquipe;
}
