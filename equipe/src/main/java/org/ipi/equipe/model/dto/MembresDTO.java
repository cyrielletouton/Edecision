package org.ipi.equipe.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.List;
@Getter
@Setter
@ToString
public class MembresDTO {
    private Long id;
    private String nom;
    private String mdp;
    private List<Long> propositions;
    private List<Long> equipes;
}
