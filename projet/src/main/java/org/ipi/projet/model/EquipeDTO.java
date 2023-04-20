package org.ipi.projet.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Component
@Getter
@Setter
@ToString
public class EquipeDTO {
    private Long id;

    private String name;

    private TypeEquipe typeEquipe;
}
