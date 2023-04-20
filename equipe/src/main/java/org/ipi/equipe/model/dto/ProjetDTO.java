package org.ipi.equipe.model.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Component
@Getter
@Setter
@ToString
public class ProjetDTO {
    private Long id;
    private String nom;
    private String equipes;

}
