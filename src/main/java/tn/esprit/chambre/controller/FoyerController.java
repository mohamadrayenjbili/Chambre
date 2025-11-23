package tn.esprit.chambre.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Foyer;
import tn.esprit.chambre.entities.Universite;
import tn.esprit.chambre.service.FoyerServiceImpl;

import java.util.List;

@RestController
@RequestMapping("Foyers")
public class FoyerController {

    private final FoyerServiceImpl foyerServiceImpl;

    public FoyerController(FoyerServiceImpl foyerServiceImpl) {
        this.foyerServiceImpl = foyerServiceImpl;
    }

    // ----------------- CRUD -----------------
    @PostMapping("/ajouterFoyer")
    public Foyer ajouterFoyer(@RequestBody Foyer foyer) {
        return foyerServiceImpl.saveFoyer(foyer);
    }

    @DeleteMapping("/supprimerFoyer/{id}")
    public void supprimerFoyer(@PathVariable Long id) {
        foyerServiceImpl.deleteFoyer(id);
    }

    @GetMapping("/getFoyer/{id}")
    public Foyer getFoyer(@PathVariable Long id) {
        return foyerServiceImpl.getFoyerById(id);
    }

    @GetMapping
    public List<Foyer> getAllFoyers() {
        return foyerServiceImpl.getAllFoyer();
    }

    // ----------------- String-based search -----------------
    @GetMapping("/search/nom/contains/{nom}")
    public List<Foyer> getFoyersByNomContains(@PathVariable String nom) {
        return foyerServiceImpl.getFoyersByNomContains(nom);
    }

    @GetMapping("/search/nom/starts/{prefix}")
    public List<Foyer> getFoyersByNomStartingWith(@PathVariable String prefix) {
        return foyerServiceImpl.getFoyersByNomStartingWith(prefix);
    }

    @GetMapping("/search/nom/ends/{suffix}")
    public List<Foyer> getFoyersByNomEndingWith(@PathVariable String suffix) {
        return foyerServiceImpl.getFoyersByNomEndingWith(suffix);
    }

    @GetMapping("/search/nom/{nom}")
    public List<Foyer> getFoyersByNom(@PathVariable String nom) {
        return foyerServiceImpl.getFoyersByNom(nom);
    }

    // ----------------- Numeric filters -----------------
    @GetMapping("/search/capacite/greater/{val}")
    public List<Foyer> getFoyersByCapaciteGreaterThan(@PathVariable Long val) {
        return foyerServiceImpl.getFoyersByCapaciteGreaterThan(val);
    }

    @GetMapping("/search/capacite/less/{val}")
    public List<Foyer> getFoyersByCapaciteLessThan(@PathVariable Long val) {
        return foyerServiceImpl.getFoyersByCapaciteLessThan(val);
    }

    @GetMapping("/search/capacite/between/{min}/{max}")
    public List<Foyer> getFoyersByCapaciteBetween(@PathVariable Long min, @PathVariable Long max) {
        return foyerServiceImpl.getFoyersByCapaciteBetween(min, max);
    }

    // ----------------- Null checks -----------------
    @GetMapping("/search/nom/notnull")
    public List<Foyer> getFoyersWithNomNotNull() {
        return foyerServiceImpl.getFoyersWithNomNotNull();
    }

    @GetMapping("/search/nom/null")
    public List<Foyer> getFoyersWithNomNull() {
        return foyerServiceImpl.getFoyersWithNomNull();
    }

    // ----------------- Sorting -----------------
    @GetMapping("/sort/nom/asc")
    public List<Foyer> getFoyersOrderByNomAsc() {
        return foyerServiceImpl.getFoyersOrderByNomAsc();
    }

    // ----------------- Counting -----------------
    @GetMapping("/count/capacite/greater/{val}")
    public Long countFoyersByCapaciteGreaterThan(@PathVariable Long val) {
        return foyerServiceImpl.countFoyersByCapaciteGreaterThan(val);
    }
    @PostMapping("/{idFoyer}/affecter-universite/{idUniversite}")
    public Universite affecterUniversiteToFoyer(@PathVariable Long idFoyer, @PathVariable long idUniversite) {
        return foyerServiceImpl.getUniversiteByFoyerId(idFoyer, idUniversite);
    }


}
