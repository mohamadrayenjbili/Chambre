package tn.esprit.chambre.repository;
import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Etudiant;

public interface EtudiantRepository extends JpaRepository<Etudiant, Long> {
}
