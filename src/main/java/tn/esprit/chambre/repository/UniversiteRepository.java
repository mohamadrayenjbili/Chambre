package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.chambre.entities.Universite;

import java.util.List;

@Repository
public interface UniversiteRepository extends JpaRepository<Universite, Long> {

    // String-based
    List<Universite> findBynomUniversiteContains(String nomUniversite);
    List<Universite> findByNomUniversiteStartingWith(String prefix);
    List<Universite> findByNomUniversiteEndingWith(String suffix);
    List<Universite> findByNomUniversite(String nomUniversite);

    List<Universite> findByAdresseContains(String adresse);
    List<Universite> findByAdresseStartingWith(String prefix);
    List<Universite> findByAdresseEndingWith(String suffix);
    List<Universite> findByAdresse(String adresse);

    // Null checks
    List<Universite> findByNomUniversiteNotNull();
    List<Universite> findByNomUniversiteNull();
    List<Universite> findByAdresseNotNull();
    List<Universite> findByAdresseNull();

    // Sorting
    List<Universite> findByOrderByNomUniversiteAsc();
    List<Universite> findByOrderByNomUniversiteDesc();

    List<Universite> findByOrderByAdresseAsc();
    List<Universite> findByOrderByAdresseDesc();

    // Counting
    Long countByNomUniversite(String nomUniversite);
    Long countByAdresse(String adresse);
}
