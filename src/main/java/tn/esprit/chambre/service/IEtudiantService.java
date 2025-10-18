package tn.esprit.chambre.service;

import tn.esprit.chambre.entities.Etudiant;

import java.util.List;

public interface IEtudiantService {
    Etudiant saveEtudiant(Etudiant etudiant);
    void deleteEtudiant(Long id);
    Etudiant getEtudiantById(Long id);
    Etudiant updateEtudiant(Etudiant etudiant);
    List<Etudiant> getAllEtudiants();
}
