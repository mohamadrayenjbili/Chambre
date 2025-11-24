package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Universite;

import java.util.List;

public interface BlocRepository extends JpaRepository<Bloc, Long> {
    // ❌ SUPPRIMÉ car numeroBloc n'existe pas dans la classe Bloc
    // Bloc findBlocByNumeroBloc(Long num);

    // ✅ Utilisez nomBloc si vous voulez chercher par nom
    Bloc findBlocByNomBloc(String nomBloc);

//    List<Bloc> findBynomBlocContains(String nomUniversite);
//    List<Bloc> findByAdresseContains(String adresse);
}