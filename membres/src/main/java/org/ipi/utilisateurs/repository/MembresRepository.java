package org.ipi.utilisateurs.repository;

import org.ipi.utilisateurs.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MembresRepository extends JpaRepository<Utilisateur, Long> {
}
