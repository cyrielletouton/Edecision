package org.ipi.projet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class CompositionProjet {
    private Long id;

    private String nom;
    private List<Long> equipes;
    private List<Long> propositions;
}
