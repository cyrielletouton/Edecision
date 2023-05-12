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
public class CompositionEquipeDTO {    private Long id;
    private TypeEquipeDTO typeEquipeDTO;
    private List<Long> projets;
    private List<Long> membres;
}
