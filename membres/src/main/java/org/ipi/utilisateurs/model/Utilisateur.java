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
@Table(name = "MEMBERS")
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "mdp", nullable = false)
    private String mdp;
    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "PROPOSITIONS", joinColumns = @JoinColumn(name = "MEMBRE_ID"))
    @Column(name = "PROPOSITION_ID")
    private List<String> propositions;
    @ElementCollection(targetClass=String.class)
    @CollectionTable(name = "EQUIPES", joinColumns = @JoinColumn(name = "MEMBRE_ID"))
    @Column(name = "EQUIPE_ID")
    private List<String> equipes;

    public void details(){

    }
}
