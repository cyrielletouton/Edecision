package org.ipi.proposition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.util.List;

@Getter
@Setter
@ToString
@Component
public class CompositionEquipeModel {    private Long id;
    private TypeEquipeModel typeEquipeDTO;
    private List<Long> projets;
    private List<Long> membres;
}
