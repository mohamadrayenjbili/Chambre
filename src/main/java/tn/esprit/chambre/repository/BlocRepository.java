package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Universite;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    Bloc findBlocByNumeroBloc(Long num);


//    List<Bloc> findBynomBlocContains(String nomUniversite);
//    List<Bloc> findByAdresseContains(String adresse);
}
