package org.ipi.vote.repository;

import org.ipi.vote.model.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findAllByUtilisateur(String id);
    List<Vote> findAllByProposition(String id);
}
