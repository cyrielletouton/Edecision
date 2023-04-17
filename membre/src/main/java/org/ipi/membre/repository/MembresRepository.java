package org.ipi.membre.repository;

import org.ipi.membre.model.Membre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresRepository extends JpaRepository<Membre, Long> {
}
