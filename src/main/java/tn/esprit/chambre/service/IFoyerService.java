package tn.esprit.chambre.service;

import tn.esprit.chambre.entities.Foyer;

import java.util.List;

public interface IFoyerService {
    Foyer saveFoyer(Foyer foyer);

    void deleteFoyer(Long id);

    Foyer getFoyerById(Long id);

    Foyer updateFoyer(Foyer foyer);

    List<Foyer> getAllFoyer();
}
