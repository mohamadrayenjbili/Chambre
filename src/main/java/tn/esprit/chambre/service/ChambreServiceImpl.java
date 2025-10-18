package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.repository.ChambreRepository;

import java.util.List;
@Service
public class ChambreServiceImpl implements IChambreService {
    private final  ChambreRepository chambreRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository) {
        this.chambreRepository = chambreRepository;
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
}
