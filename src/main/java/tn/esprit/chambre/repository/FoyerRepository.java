package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import tn.esprit.chambre.entities.Foyer;
import java.util.List;
@Repository

public interface FoyerRepository extends JpaRepository<Foyer, Long> {

    // String-based
    List<Foyer> findByNomFoyerContains(String nom);
    List<Foyer> findByNomFoyerStartingWith(String prefix);
    List<Foyer> findByNomFoyerEndingWith(String suffix);
    List<Foyer> findByNomFoyer(String nom);

    // Numeric comparisons
    List<Foyer> findByCapaciteFoyerGreaterThan(Long capacite);
    List<Foyer> findByCapaciteFoyerLessThan(Long capacite);
    List<Foyer> findByCapaciteFoyerBetween(Long min, Long max);

    // Null checks
    List<Foyer> findByNomFoyerNotNull();
    List<Foyer> findByNomFoyerNull();

    // Sorting
    List<Foyer> findByOrderByNomFoyerAsc();

    // Counting
    Long countByCapaciteFoyerGreaterThan(Long capacite);

}
