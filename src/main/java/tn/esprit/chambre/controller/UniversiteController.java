package tn.esprit.chambre.controller;

import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Universite;
import tn.esprit.chambre.service.UniversiteServiceImpl;

import java.util.List;

@RestController
@RequestMapping("Universites")
public class UniversiteController {

    private final UniversiteServiceImpl universiteServiceImpl;

    public UniversiteController(UniversiteServiceImpl universiteServiceImpl) {
        this.universiteServiceImpl = universiteServiceImpl;
    }

    // ---------------- CRUD ----------------
    @PostMapping("/ajouterUniversite")
    public Universite ajouterUniversite(@RequestBody Universite universite) {
        return universiteServiceImpl.saveUniversite(universite);
    }

    @DeleteMapping("/supprimerUniversite/{id}")
    public void supprimerUniversite(@PathVariable Long id) {
        universiteServiceImpl.deleteUniversite(id);
    }

    @GetMapping("/getUniversite/{id}")
    public Universite getUniversite(@PathVariable Long id) {
        return universiteServiceImpl.getUniversiteById(id);
    }

    @GetMapping
    public List<Universite> getAllUniversites() {
        return universiteServiceImpl.getAllUniversites();
    }

    // ---------------- String-based searches ----------------
    @GetMapping("/search/nom/{nom}")
    public List<Universite> getUniversitieByNom(@PathVariable String nom) {
        return universiteServiceImpl.getUniversitieByNom(nom);
    }

    @GetMapping("/search/nom/start/{prefix}")
    public List<Universite> getUniversitieByNomStartingWith(@PathVariable String prefix) {
        return universiteServiceImpl.getUniversitieByNomStartingWith(prefix);
    }

    @GetMapping("/search/nom/end/{suffix}")
    public List<Universite> getUniversitieByNomEndingWith(@PathVariable String suffix) {
        return universiteServiceImpl.getUniversitieByNomEndingWith(suffix);
    }

    @GetMapping("/search/nom/exact/{nom}")
    public List<Universite> getUniversitieByNomExact(@PathVariable String nom) {
        return universiteServiceImpl.getUniversitieByNomExact(nom);
    }

    @GetMapping("/search/adresse/{adresse}")
    public List<Universite> getUniversitieByAdresse(@PathVariable String adresse) {
        return universiteServiceImpl.getUniversitieByAdresse(adresse);
    }

    @GetMapping("/search/adresse/start/{prefix}")
    public List<Universite> getUniversitieByAdresseStartingWith(@PathVariable String prefix) {
        return universiteServiceImpl.getUniversitieByAdresseStartingWith(prefix);
    }

    @GetMapping("/search/adresse/end/{suffix}")
    public List<Universite> getUniversitieByAdresseEndingWith(@PathVariable String suffix) {
        return universiteServiceImpl.getUniversitieByAdresseEndingWith(suffix);
    }

    @GetMapping("/search/adresse/exact/{adresse}")
    public List<Universite> getUniversitieByAdresseExact(@PathVariable String adresse) {
        return universiteServiceImpl.getUniversitieByAdresseExact(adresse);
    }

    // ---------------- Null checks ----------------
    @GetMapping("/search/nom/notnull")
    public List<Universite> getUniversitieWithNomNotNull() {
        return universiteServiceImpl.getUniversitieWithNomNotNull();
    }

    @GetMapping("/search/nom/null")
    public List<Universite> getUniversitieWithNomNull() {
        return universiteServiceImpl.getUniversitieWithNomNull();
    }

    @GetMapping("/search/adresse/notnull")
    public List<Universite> getUniversitieWithAdresseNotNull() {
        return universiteServiceImpl.getUniversitieWithAdresseNotNull();
    }

    @GetMapping("/search/adresse/null")
    public List<Universite> getUniversitieWithAdresseNull() {
        return universiteServiceImpl.getUniversitieWithAdresseNull();
    }

    // ---------------- Sorting ----------------
    @GetMapping("/sort/nom/asc")
    public List<Universite> getUniversitesSortedByNomAsc() {
        return universiteServiceImpl.getUniversitesSortedByNomAsc();
    }

    @GetMapping("/sort/nom/desc")
    public List<Universite> getUniversitesSortedByNomDesc() {
        return universiteServiceImpl.getUniversitesSortedByNomDesc();
    }

    @GetMapping("/sort/adresse/asc")
    public List<Universite> getUniversitesSortedByAdresseAsc() {
        return universiteServiceImpl.getUniversitesSortedByAdresseAsc();
    }

    @GetMapping("/sort/adresse/desc")
    public List<Universite> getUniversitesSortedByAdresseDesc() {
        return universiteServiceImpl.getUniversitesSortedByAdresseDesc();
    }

    // ---------------- Counting ----------------
    @GetMapping("/count/nom/{nom}")
    public Long countByNom(@PathVariable String nom) {
        return universiteServiceImpl.countByNom(nom);
    }

    @GetMapping("/count/adresse/{adresse}")
    public Long countByAdresse(@PathVariable String adresse) {
        return universiteServiceImpl.countByAdresse(adresse);
    }
}
