package org.ipi.membres.repository;

import org.ipi.membres.model.Membres;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresRepository extends JpaRepository<Membres, Long> {
}
