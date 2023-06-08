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
public class ProjetModel {
    public Long id;
    public String nom;
    public String equipes;
    public List<Long> propositions;
}
