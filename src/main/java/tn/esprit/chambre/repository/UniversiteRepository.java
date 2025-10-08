package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.chambre.entities.Universite;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {
}
