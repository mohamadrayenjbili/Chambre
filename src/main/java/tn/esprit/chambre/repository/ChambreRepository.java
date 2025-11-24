package tn.esprit.chambre.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.data.repository.query.Param;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.TypeChambre;

public interface ChambreRepository extends JpaRepository<Chambre, Long> {

    // Trouver une chambre par son numéro
    Chambre findChambreByNumeroChambre(Long num);


    // Désaffecter une chambre d’un bloc
    @Modifying
    @Transactional
    @Query("UPDATE Chambre c SET c.bloc = NULL WHERE c.numeroChambre = :num")
    int desaffecterChambreABloc(@Param("num") Long num);


    // Affecter une chambre à un bloc
    @Modifying
    @Transactional
    @Query("UPDATE Chambre c SET c.bloc.idBloc = :idBloc WHERE c.numeroChambre = :num")
    int affecterChambreABloc(@Param("num") Long num, @Param("idBloc") Long idBloc);


    // Affecter un type à une chambre
    @Modifying
    @Transactional
    @Query("UPDATE Chambre c SET c.typeC = :type WHERE c.idChambre = :id")
    int affecterTypeAChambre(@Param("id") Long idChambre,
                             @Param("type") TypeChambre typeChambre);

}
