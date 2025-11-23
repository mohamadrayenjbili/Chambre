package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Foyer;
import tn.esprit.chambre.entities.Universite;
import tn.esprit.chambre.repository.BlocRepository;
import tn.esprit.chambre.repository.FoyerRepository;
import tn.esprit.chambre.repository.ChambreRepository;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {
    private final BlocRepository blocRepository;
    private final FoyerRepository foyerRepository;
    private final ChambreRepository chambreRepository;


    public BlocServiceImpl(BlocRepository blocRepository, FoyerRepository foyerRepository, ChambreRepository chambreRepository) {
        this.blocRepository = blocRepository;
        this.foyerRepository = foyerRepository;
        this.chambreRepository = chambreRepository;
    }

    @Override
    public Bloc saveBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public void deleteBloc(Long id) {
        blocRepository.deleteById(id);
    }

    @Override
    public Bloc getBlocById(Long id) {
        return null;
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return null;
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc BlocAFoyer(Long idFoyer, Long idBloc){
      Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        //Bloc bloc=blocRepository.findBlocByNumeroBloc(num);
        bloc.setFoyer(foyer);
        blocRepository.save(bloc);
        return blocRepository.save(bloc);

    }


    public Chambre

    affecterChambreABloc(Long num , Long idBloc) {
        Chambre chambre = chambreRepository. findChambreByNumeroChambre(num);
        Bloc bloc = blocRepository. findById(idBloc) .get();
        chambre.setBloc(bloc);
        chambreRepository. save (chambre);
        return chambre;
    }

    public Chambre desaffecterChambreDuBloc(Long num) {
        Chambre chambre = chambreRepository.findChambreByNumeroChambre(num);
        chambre.setBloc(null);
        return chambreRepository.save(chambre);
    }
}


//    public Universite getUniversiteByFoyerId(Long idFoyer, long idUniversite) {
//        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
//        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
//        universite.setFoyer(foyer);
//        return universiteRepository.save(universite);
//    }

