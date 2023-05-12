package org.ipi.proposition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;

@Getter
@Setter
@ToString
@Component
public class EquipeDTO {
    public Long id;
    public String name;
    public TypeEquipeDTO typeEquipeDTO;
}
