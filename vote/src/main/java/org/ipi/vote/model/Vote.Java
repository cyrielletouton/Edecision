package org.ipi.vote.model;

public class Vote {
    public String id;
    public VoteStatut voteStatut;
    public Utilisateur utilisateur;
    public Proposition proposition;

    public String getId() {
        return id;
    }
    public void setId(String id) {
        this.id = id;
    }

    public VoteStatut getVoteStatut() {
        return voteStatut;
    }
    public void setVoteStatut(VoteStatut voteStatut) {
        this.voteStatut = voteStatut;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }
    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Proposition getProposition() { return proposition; }
    public void setProposition(Proposition proposition) {this.proposition = proposition; }

}
