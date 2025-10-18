package tn.esprit.chambre.controller;

import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Etudiant;
import tn.esprit.chambre.service.EtudiantServiceImpl;

@RestController
@RequestMapping("/Etudiants")
//@AllArgsConstructor
public class EtudiantController {
    private final EtudiantServiceImpl etudiantServiceImpl;

    public EtudiantController(EtudiantServiceImpl etudiantServiceImpl) {
        this.etudiantServiceImpl = etudiantServiceImpl;
    }

    @PostMapping ("/ajouterEtudiant")
    public tn.esprit.chambre.entities.Etudiant ajouterEtudiant(@RequestBody Etudiant etudiant) {
        return etudiantServiceImpl.saveEtudiant(etudiant);
    }

    @DeleteMapping ("/supprimerEtudiant/{id}")
    public void supprimerEtudiant(@org.springframework.web.bind.annotation.PathVariable Long id) {
        etudiantServiceImpl.deleteEtudiant(id);
    }
    @GetMapping ("/getEtudiant/{id}")
    public tn.esprit.chambre.entities.Etudiant getEtudiant(@org.springframework.web.bind.annotation.PathVariable Long id) {
        return etudiantServiceImpl.getEtudiantById(id);
    }
    @GetMapping
    public java.util.List<Etudiant> getAllEtudiants() {
        return etudiantServiceImpl.getAllEtudiants();
    }
}
