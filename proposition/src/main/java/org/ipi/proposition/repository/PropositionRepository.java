package org.ipi.proposition.repository;

import org.ipi.proposition.model.Proposition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

@Repository
public interface PropositionRepository extends JpaRepository<Proposition, Long> {
}