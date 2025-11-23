package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.Foyer;
import tn.esprit.chambre.entities.TypeChambre;

import java.util.List;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {
    Chambre findChambreByNumeroChambre(Long num);
    Chambre desaffecterChambreABloc(Long num);
    Chambre affecterChambreABloc(Long num, Long idBloc);
     Chambre affecterTypeAChambre(Long idChambre, TypeChambre typeChambre) ;





    }
