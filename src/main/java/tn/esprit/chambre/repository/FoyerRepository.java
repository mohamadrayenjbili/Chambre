package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Foyer;

public interface FoyerRepository extends JpaRepository<Foyer, Long> {
}
