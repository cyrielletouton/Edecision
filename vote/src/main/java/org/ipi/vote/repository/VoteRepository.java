package org.ipi.vote.repository;

import org.ipi.vote.entity.Vote;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VoteRepository extends JpaRepository<Vote, Long> {
    List<Vote> findAllByMembre(Long id);
    List<Vote> findAllByProposition(Long id);
    String findDistinctByMembre(Long id);
}
