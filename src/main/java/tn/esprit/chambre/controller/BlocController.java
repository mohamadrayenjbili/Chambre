package tn.esprit.chambre.controller;


import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.*;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.service.BlocServiceImpl;

@RestController
@RequestMapping("/Blocs")
//@AllArgsConstructor
public class BlocController {
    private final BlocServiceImpl blocServiceImpl;

    public BlocController(BlocServiceImpl blocServiceImpl) {
        this.blocServiceImpl = blocServiceImpl;
    }

    @PostMapping  ("/ajouterBloc")
    public Bloc ajouterBloc(@RequestBody Bloc bloc) {
        return blocServiceImpl.saveBloc(bloc);
    }

    @DeleteMapping ("/supprimerBloc/{id}")
    public void supprimerBloc(@PathVariable Long id) {
        blocServiceImpl.deleteBloc(id);
    }
    @GetMapping ("/getBloc/{id}")
    public Bloc getBloc(@PathVariable Long id) {
        return blocServiceImpl.getBlocById(id);
    }
    @GetMapping
    public java.util.List<Bloc> getAllBlocs() {
        return blocServiceImpl.getAllBlocs();
    }
}
