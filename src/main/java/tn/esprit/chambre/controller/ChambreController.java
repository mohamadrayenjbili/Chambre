package tn.esprit.chambre.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.service.ChambreServiceImpl;

import java.util.List;

@RestController
@RequestMapping("/Chambres")
//@AllArgsConstructor
public class ChambreController {

    private final ChambreServiceImpl chambreServiceImpl;

    public ChambreController(ChambreServiceImpl chambreServiceImpl) {
        this.chambreServiceImpl = chambreServiceImpl;
    }

    @PostMapping ("/ajouterChambre")
    public Chambre ajouterChambre(@RequestBody Chambre chambre) {
        return chambreServiceImpl.saveChambre(chambre);
    }

    @DeleteMapping ("/supprimerChambre/{id}")
    public void supprimerChambre(@PathVariable Long id) {
        chambreServiceImpl.deleteChambre(id);
    }

    @GetMapping ("/getChambre/{id}")
    public Chambre getChambre(@PathVariable Long id) {
        return chambreServiceImpl.getChambreById(id);
    }
    @GetMapping
    public List<Chambre> getAllChambres() {
        return chambreServiceImpl.getAllChambres();
    }
}
