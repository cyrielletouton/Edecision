package org.ipi.equipe.model;

public class Equipe {
    public String id;

    public TypeEquipe typeEquipe;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public TypeEquipe getTypeEquipe() {return typeEquipe; }
    public void setTypeEquipe(TypeEquipe typeEquipe) {this.typeEquipe = typeEquipe; }

}
