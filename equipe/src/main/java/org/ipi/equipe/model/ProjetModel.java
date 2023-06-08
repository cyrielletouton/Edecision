package org.ipi.equipe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class ProjetModel {
    private Long id;
    private String nom;
    private String equipes;

}
