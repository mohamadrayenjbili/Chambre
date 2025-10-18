package tn.esprit.chambre.service;

import tn.esprit.chambre.entities.Chambre;

import java.util.List;

public interface IChambreService {
    Chambre saveChambre(Chambre chambre);

    void deleteChambre(Long id);

    Chambre getChambreById(Long id);

    Chambre updateChambre(Chambre chambre);

    List<Chambre> getAllChambres();
}
