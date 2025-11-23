package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Etudiant;
import tn.esprit.chambre.entities.Reservation;
import tn.esprit.chambre.repository.ChambreRepository;
import tn.esprit.chambre.repository.ReservationRepository;
import tn.esprit.chambre.repository.EtudiantRepository;


import java.util.List;

@Service
public class ReservationserviceImpl implements IReservationService {
    private final  ChambreRepository chambreRepository;
    private final ReservationRepository reservationRepository;
    private final EtudiantRepository etudiantRepository;

    public ReservationserviceImpl(ChambreRepository chambreRepository, ReservationRepository reservationRepository, EtudiantRepository etudiantRepository) {
        this.chambreRepository = chambreRepository;
        this.reservationRepository = reservationRepository;
        this.etudiantRepository = etudiantRepository;
    }

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

    public Reservation affecterReservationAChambre(String idReservation, Long idChambre){
        Reservation reservation = reservationRepository.findById(idReservation).orElse(null);
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);

        List<Reservation> reservations = chambre.getReservation();  // ← Changé
        reservations.add(reservation);
        chambre.setReservation(reservations);  // ← Changé
        chambreRepository.save(chambre);

        return reservation;
    }
    public Reservation affecterReservationAEtudiant(String idReservation, Long idEtudiant) {
        // Récupération avec gestion d'erreur
        Reservation reservation = reservationRepository.findById(idReservation)
                .orElseThrow(() -> new RuntimeException("Reservation avec ID " + idReservation + " introuvable"));

        Etudiant etudiant = etudiantRepository.findById(idEtudiant)
                .orElseThrow(() -> new RuntimeException("Etudiant avec ID " + idEtudiant + " introuvable"));

        // Ajout bidirectionnel de la relation Many-to-Many
        reservation.getEtudiantList().add(etudiant);
        etudiant.getReservationList().add(reservation);

        // Sauvegarde (une seule suffit car cascade, mais les deux pour être sûr)
        etudiantRepository.save(etudiant);
        return reservationRepository.save(reservation);
    }
}
