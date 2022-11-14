package org.ipi.projet.model;

public class Projet {
    public String id;

    public String nom;

    public List<PropositionDTO> propositions;

    public List<EquipeDTO> equipes;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }
    public void setNom(String nom) {
        this.nom = nom;
    }

    public List<PropositionDTO> getPropositions(){ return propositions; };
    public void setPropositions(List<PropositionDTO> propositions) {this.propositions = proposition;}

    public List<EquipeDTO> getEquipes(){ return equipes; };
    public void setEquipes(List<EquipeDTO> equipes) {this.equipes = equipes;}
}
