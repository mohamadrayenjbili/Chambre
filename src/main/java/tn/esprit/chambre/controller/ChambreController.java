package tn.esprit.chambre.controller;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.service.ChambreServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.Parameter;
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
    @PostMapping ("/{num}/affecter/{idBloc}")
    public Chambre affecterChambreABloc(@PathVariable Long num, @PathVariable Long idBloc){
        return chambreServiceImpl.affecterChambreABloc(num,idBloc);
    }
    @PostMapping ("/{num}/desaffecter")
    public Chambre desaffecterChambreABloc(@PathVariable Long num){
        return chambreServiceImpl.desaffecterChambreABloc(num);
    }
}
