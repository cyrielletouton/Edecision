package org.ipi.proposition.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

import javax.persistence.*;
import java.util.List;

@Getter
@Setter
@ToString
@Component
public class ProjetDTO {
    public Long id;
    public String nom;
    public List<Long> equipes;
    public List<Long> propositions;
}
