package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Foyer;
import tn.esprit.chambre.repository.FoyerRepository;

import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {

    private final FoyerRepository foyerRepository;

    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    // ----------------- CRUD -----------------
    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return foyerRepository.findById(id).orElse(null);
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }


    // ----------------- String-based queries -----------------
    public List<Foyer> getFoyersByNomContains(String nom) {
        return foyerRepository.findByNomFoyerContains(nom);
    }

    public List<Foyer> getFoyersByNomStartingWith(String prefix) {
        return foyerRepository.findByNomFoyerStartingWith(prefix);
    }

    public List<Foyer> getFoyersByNomEndingWith(String suffix) {
        return foyerRepository.findByNomFoyerEndingWith(suffix);
    }

    public List<Foyer> getFoyersByNom(String nom) {
        return foyerRepository.findByNomFoyer(nom);
    }

    // ----------------- Numeric comparisons -----------------
    public List<Foyer> getFoyersByCapaciteGreaterThan(Long capacite) {
        return foyerRepository.findByCapaciteFoyerGreaterThan(capacite);
    }

    public List<Foyer> getFoyersByCapaciteLessThan(Long capacite) {
        return foyerRepository.findByCapaciteFoyerLessThan(capacite);
    }

    public List<Foyer> getFoyersByCapaciteBetween(Long min, Long max) {
        return foyerRepository.findByCapaciteFoyerBetween(min, max);
    }

    // ----------------- Null checks -----------------
    public List<Foyer> getFoyersWithNomNotNull() {
        return foyerRepository.findByNomFoyerNotNull();
    }

    public List<Foyer> getFoyersWithNomNull() {
        return foyerRepository.findByNomFoyerNull();
    }

    // ----------------- Sorting -----------------
    public List<Foyer> getFoyersOrderByNomAsc() {
        return foyerRepository.findByOrderByNomFoyerAsc();
    }

    // ----------------- Counting -----------------
    public Long countFoyersByCapaciteGreaterThan(Long capacite) {
        return foyerRepository.countByCapaciteFoyerGreaterThan(capacite);
    }


}
