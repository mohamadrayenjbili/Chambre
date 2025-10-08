package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Chambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
}
