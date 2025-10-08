package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Reservation;

public interface ReservationRepository extends JpaRepository<Reservation, String> {
}
