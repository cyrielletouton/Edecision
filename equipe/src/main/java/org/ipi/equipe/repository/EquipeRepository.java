package org.ipi.equipe.repository;

import org.ipi.equipe.model.Equipe;
import org.ipi.equipe.model.TypeEquipe;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface EquipeRepository extends JpaRepository<Equipe, Long> {
}
