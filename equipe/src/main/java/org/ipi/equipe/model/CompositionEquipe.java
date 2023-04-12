package org.ipi.equipe.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
@Getter
@Setter
@ToString
public class CompositionEquipe {
    private Long id;

    private TypeEquipe typeEquipe;

    private List<Long> projets;

    private List<Long> membres;
    private Date derniereProposition;
}
