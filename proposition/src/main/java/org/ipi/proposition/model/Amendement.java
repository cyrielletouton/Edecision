package org.ipi.proposition.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@Table(name = "AMENDEMENTS")
public class Amendement extends PropositionGenerale{

    @Column
    private String contenu;

    public void amender(){

    }
}
