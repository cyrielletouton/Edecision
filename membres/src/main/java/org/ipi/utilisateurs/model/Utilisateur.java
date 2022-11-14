package org.ipi.utilisateurs.model;

public class Utilisateur {
    public String id;
    public String nom;
    public String mdp;

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

}
