package tn.esprit.chambre.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Universite;
import tn.esprit.chambre.repository.UniversiteRepository;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Autowired
    private UniversiteRepository universiteRepository;

    @Override
    public Universite saveUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public void deleteUniversite(Long id) {
        universiteRepository.deleteById(id);
    }

    @Override
    public Universite getUniversiteById(Long id) {
        return universiteRepository.findById(id).orElse(null);
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return universiteRepository.save(universite);
    }

    @Override
    public List<Universite> getAllUniversites() {
        return universiteRepository.findAll();
    }

    // ---------------- String-based ----------------
    public List<Universite> getUniversitieByNom(String nomUniversite) {
        return universiteRepository.findBynomUniversiteContains(nomUniversite);
    }

    public List<Universite> getUniversitieByNomStartingWith(String prefix) {
        return universiteRepository.findByNomUniversiteStartingWith(prefix);
    }

    public List<Universite> getUniversitieByNomEndingWith(String suffix) {
        return universiteRepository.findByNomUniversiteEndingWith(suffix);
    }

    public List<Universite> getUniversitieByNomExact(String nomUniversite) {
        return universiteRepository.findByNomUniversite(nomUniversite);
    }

    public List<Universite> getUniversitieByAdresse(String adresse) {
        return universiteRepository.findByAdresseContains(adresse);
    }

    public List<Universite> getUniversitieByAdresseStartingWith(String prefix) {
        return universiteRepository.findByAdresseStartingWith(prefix);
    }

    public List<Universite> getUniversitieByAdresseEndingWith(String suffix) {
        return universiteRepository.findByAdresseEndingWith(suffix);
    }

    public List<Universite> getUniversitieByAdresseExact(String adresse) {
        return universiteRepository.findByAdresse(adresse);
    }

    // ---------------- Null checks ----------------
    public List<Universite> getUniversitieWithNomNotNull() {
        return universiteRepository.findByNomUniversiteNotNull();
    }

    public List<Universite> getUniversitieWithNomNull() {
        return universiteRepository.findByNomUniversiteNull();
    }

    public List<Universite> getUniversitieWithAdresseNotNull() {
        return universiteRepository.findByAdresseNotNull();
    }

    public List<Universite> getUniversitieWithAdresseNull() {
        return universiteRepository.findByAdresseNull();
    }

    // ---------------- Sorting ----------------
    public List<Universite> getUniversitesSortedByNomAsc() {
        return universiteRepository.findByOrderByNomUniversiteAsc();
    }

    public List<Universite> getUniversitesSortedByNomDesc() {
        return universiteRepository.findByOrderByNomUniversiteDesc();
    }

    public List<Universite> getUniversitesSortedByAdresseAsc() {
        return universiteRepository.findByOrderByAdresseAsc();
    }

    public List<Universite> getUniversitesSortedByAdresseDesc() {
        return universiteRepository.findByOrderByAdresseDesc();
    }

    // ---------------- Counting ----------------
    public Long countByNom(String nomUniversite) {
        return universiteRepository.countByNomUniversite(nomUniversite);
    }

    public Long countByAdresse(String adresse) {
        return universiteRepository.countByAdresse(adresse);
    }
}
