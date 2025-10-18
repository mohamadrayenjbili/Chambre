package tn.esprit.chambre.service;

import tn.esprit.chambre.entities.Reservation;

import java.util.List;

public interface IReservationService {
    Reservation saveReservation(Reservation reservation);

    void deleteReservation(Long id);

    Reservation getReservationById(Long id);

    Reservation updateReservation(Reservation reservation);

    List<Reservation> getAllReservations();
}
