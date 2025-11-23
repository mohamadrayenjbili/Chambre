package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.TypeChambre;
import tn.esprit.chambre.repository.BlocRepository;
import tn.esprit.chambre.repository.ChambreRepository;

import java.util.List;
@Service
public class ChambreServiceImpl implements IChambreService {
    private final  ChambreRepository chambreRepository;
    private final BlocRepository blocRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository, BlocRepository blocRepository) {
        this.chambreRepository = chambreRepository;
        this.blocRepository = blocRepository;
    }

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
       return chambreRepository.findById(id).get();
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return null;
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }
    //@Override
    public Chambre affecterChambreABloc(Long num, Long idBloc){
        Chambre chambre=chambreRepository.findChambreByNumeroChambre(num);
        Bloc bloc =blocRepository.findById(idBloc).get();
        chambre.setBloc(bloc);
        chambreRepository.save(chambre);
        return chambre;
    }
   // @Override
    public Chambre desaffecterChambreABloc(Long num){
        Chambre chambre=chambreRepository.findChambreByNumeroChambre(num);
        chambre.setBloc(null);
        return chambreRepository.save(chambre);
    }

    public Chambre affecterTypeAChambre(Long idChambre, TypeChambre typeChambre) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        if (chambre == null) {
            return null;
        }
        chambre.setTypeC(typeChambre);
        return chambreRepository.save(chambre);
    }
}
