package tn.esprit.chambre.service;

import tn.esprit.chambre.entities.Bloc;

import java.util.List;

public interface IBlocService {
    Bloc saveBloc(Bloc bloc);

    void deleteBloc(Long id);

    Bloc getBlocById(Long id);

    Bloc updateBloc(Bloc bloc);

    List<Bloc> getAllBlocs();
}
