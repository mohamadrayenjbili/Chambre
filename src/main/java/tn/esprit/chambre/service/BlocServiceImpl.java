package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.repository.BlocRepository;
import java.util.List;

@Service
public class BlocServiceImpl implements IBlocService {
    private final BlocRepository blocRepository;

    public BlocServiceImpl(BlocRepository blocRepository) {
        this.blocRepository = blocRepository;
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
}
