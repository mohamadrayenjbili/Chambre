package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Bloc;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
}
