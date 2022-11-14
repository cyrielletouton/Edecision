package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
public class Amendement extends PropositionGenerale{

    private String contenu;

    public void amender(){

    }
}
