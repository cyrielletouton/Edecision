package org.ipi.membres.model;

public class Utilisateur {
    public String id;
    public String nom;
    public String mdp;

    public List<Proposition> propositions;

    public List<Equipe> equipes;

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

    public String getMdp(){ return mdp; };
    public void setMdp(String mdp) {this.mdp = mdp;}

    public List<Proposition> getPropositions(){ return propositions; };
    public void setPropositions(List<Proposition> propositions) {this.propositions = proposition;}

    public List<Equipe> getEquipes(){ return equipes; };
    public void setEquipes(List<Equipe> equipes) {this.equipes = equipes;}
}
