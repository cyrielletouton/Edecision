package org.ipi.membres.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.*;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "MEMBERS")
@ToString
public class Membres {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    @Column(name = "nom", nullable = false)
    private String nom;
    @Column(name = "mdp", nullable = false)
    private String mdp;
    @ElementCollection(targetClass=Long.class)
    @CollectionTable(name = "PROPOSITIONS", joinColumns = @JoinColumn(name = "MEMBRE_ID"))
    @Column(name = "PROPOSITION_ID")
    private List<Long> propositions;
    @ElementCollection(targetClass=Long.class)
    @CollectionTable(name = "EQUIPES", joinColumns = @JoinColumn(name = "MEMBRE_ID"))
    @Column(name = "EQUIPE_ID")
    private List<Long> equipes;

    public void details(){

    }
}
