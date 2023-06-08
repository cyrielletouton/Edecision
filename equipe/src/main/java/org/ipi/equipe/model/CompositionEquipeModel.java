package org.ipi.equipe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@Getter
@Setter
@ToString
public class CompositionEquipeModel {
    private Long id;
    private TypeEquipeModel typeEquipe;
    private List<Long> projets;
    private List<Long> membres;
}
