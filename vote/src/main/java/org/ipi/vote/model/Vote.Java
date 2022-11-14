package org.ipi.vote.model;

public class Vote {
    public String id;
    public VoteStatut voteStatut;

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

}
