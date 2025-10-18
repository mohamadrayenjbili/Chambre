package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Foyer;
import tn.esprit.chambre.repository.FoyerRepository;
import java.util.List;

@Service
public class FoyerServiceImpl implements IFoyerService {
    private final FoyerRepository foyerRepository;

    public FoyerServiceImpl(FoyerRepository foyerRepository) {
        this.foyerRepository = foyerRepository;
    }

    @Override
    public Foyer saveFoyer(Foyer foyer) {
        return foyerRepository.save(foyer);
    }

    @Override
    public void deleteFoyer(Long id) {
        foyerRepository.deleteById(id);
    }

    @Override
    public Foyer getFoyerById(Long id) {
        return null;
    }

    @Override
    public Foyer updateFoyer(Foyer foyer) {
        return null;
    }

    @Override
    public List<Foyer> getAllFoyer() {
        return foyerRepository.findAll();
    }
}
