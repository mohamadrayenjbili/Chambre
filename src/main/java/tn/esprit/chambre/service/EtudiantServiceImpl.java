package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Etudiant;
import tn.esprit.chambre.repository.EtudiantRepository;

import java.util.List;

@Service
public class EtudiantServiceImpl implements IEtudiantService {
private final EtudiantRepository etudiantRepository;

    public EtudiantServiceImpl(EtudiantRepository etudiantRepository) {
        this.etudiantRepository = etudiantRepository;
    }

    @Override
    public Etudiant saveEtudiant(Etudiant etudiant) {
        return etudiantRepository.save(etudiant);
    }

    @Override
    public void deleteEtudiant(Long id) {
    etudiantRepository.deleteById(id);
    }

    @Override
    public Etudiant getEtudiantById(Long id) {
        return null;
    }

    @Override
    public Etudiant updateEtudiant(Etudiant etudiant) {
        return null;
    }

    @Override
    public List<Etudiant> getAllEtudiants() {
        return etudiantRepository.findAll();
    }
}
