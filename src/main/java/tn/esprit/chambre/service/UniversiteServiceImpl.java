package tn.esprit.chambre.service;

import org.springframework.stereotype.Service;
import tn.esprit.chambre.entities.Universite;

import java.util.List;

@Service
public class UniversiteServiceImpl implements IUniversiteService {
    @Override
    public Universite saveUniversite(Universite universite) {
        return null;
    }

    @Override
    public void deleteUniversite(Long id) {

    }

    @Override
    public Universite getUniversiteById(Long id) {
        return null;
    }

    @Override
    public Universite updateUniversite(Universite universite) {
        return null;
    }

    @Override
    public List<Universite> getAllUniversites() {
        return List.of();
    }
}
