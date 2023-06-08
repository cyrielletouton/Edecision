package org.ipi.proposition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@Setter
@ToString
@Component
public class EquipeModel {
    public Long id;
    public String name;
    public TypeEquipeModel typeEquipeDTO;
}
