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
        return blocRepository.findById(id).orElse(null);
    }

    @Override
    public Bloc updateBloc(Bloc bloc) {
        return blocRepository.save(bloc);
    }

    @Override
    public List<Bloc> getAllBlocs() {
        return blocRepository.findAll();
    }

    public Bloc BlocAFoyer(Long idFoyer, Long idBloc){
        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);

        //Bloc bloc=blocRepository.findBlocByNumeroBloc(num);
        if (bloc != null && foyer != null) {
            bloc.setFoyer(foyer);
            return blocRepository.save(bloc);
        }
        return null;
    }


    public Chambre affecterChambreABloc(Long num , Long idBloc) {
        Chambre chambre = chambreRepository.findChambreByNumeroChambre(num);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (chambre != null && bloc != null) {
            chambre.setBloc(bloc);
            return chambreRepository.save(chambre);
        }
        return null;
    }

    public Chambre desaffecterChambreDuBloc(Long num) {
        Chambre chambre = chambreRepository.findChambreByNumeroChambre(num);
        if (chambre != null) {
            chambre.setBloc(null);
            return chambreRepository.save(chambre);
        }
        return null;
    }
}


//    public Universite getUniversiteByFoyerId(Long idFoyer, long idUniversite) {
//        Foyer foyer = foyerRepository.findById(idFoyer).orElse(null);
//        Universite universite = universiteRepository.findById(idUniversite).orElse(null);
//        universite.setFoyer(foyer);
//        return universiteRepository.save(universite);
//    }