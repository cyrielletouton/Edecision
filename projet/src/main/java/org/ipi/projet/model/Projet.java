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
@Table(name = "PROJET")
public class Projet {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nom", nullable = false)
    private String nom;
    @ElementCollection(targetClass=Long.class)
    @CollectionTable(name = "EQUIPE", joinColumns = @JoinColumn(name = "PROJET_ID"))
    @Column(name = "EQUIPE_ID")
    private List<Long> equipes;
    @ElementCollection(targetClass=Long.class)
    @CollectionTable(name = "PROPOSITION", joinColumns = @JoinColumn(name = "PROJET_ID"))
    @Column(name = "PROPOSITION_ID")
    private List<Long> propositions;
}
