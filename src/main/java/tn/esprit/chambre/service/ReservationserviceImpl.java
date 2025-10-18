package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Reservation;

import java.util.List;

@Service
public class ReservationserviceImpl implements IReservationService {
    @Override
    public Reservation saveReservation(Reservation reservation) {
        return null;
    }

    @Override
    public void deleteReservation(Long id) {

    }

    @Override
    public Reservation getReservationById(Long id) {
        return null;
    }

    @Override
    public Reservation updateReservation(Reservation reservation) {
        return null;
    }

    @Override
    public List<Reservation> getAllReservations() {
        return List.of();
    }
}
