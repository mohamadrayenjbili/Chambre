package tn.esprit.chambre.service;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tn.esprit.chambre.entities.Bloc;
import tn.esprit.chambre.entities.Chambre;
import tn.esprit.chambre.entities.TypeChambre;
import tn.esprit.chambre.repository.BlocRepository;
import tn.esprit.chambre.repository.ChambreRepository;

import java.time.LocalDate;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class ChambreServiceImpl implements IChambreService {
    private final ChambreRepository chambreRepository;
    private final BlocRepository blocRepository;

    public ChambreServiceImpl(ChambreRepository chambreRepository, BlocRepository blocRepository) {
        this.chambreRepository = chambreRepository;
        this.blocRepository = blocRepository;
    }

    @Override
    public Chambre saveChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public void deleteChambre(Long id) {
        chambreRepository.deleteById(id);
    }

    @Override
    public Chambre getChambreById(Long id) {
        return chambreRepository.findById(id).orElse(null);
    }

    @Override
    public Chambre updateChambre(Chambre chambre) {
        return chambreRepository.save(chambre);
    }

    @Override
    public List<Chambre> getAllChambres() {
        return chambreRepository.findAll();
    }

    //@Override
    public Chambre affecterChambreABloc(Long num, Long idBloc) {
        Chambre chambre = chambreRepository.findChambreByNumeroChambre(num);
        Bloc bloc = blocRepository.findById(idBloc).orElse(null);
        if (chambre != null && bloc != null) {
            chambre.setBloc(bloc);
            return chambreRepository.save(chambre);
        }
        return null;
    }

    // @Override
    public Chambre desaffecterChambreABloc(Long num) {
        Chambre chambre = chambreRepository.findChambreByNumeroChambre(num);
        if (chambre != null) {
            chambre.setBloc(null);
            return chambreRepository.save(chambre);
        }
        return null;
    }

    public Chambre affecterTypeAChambre(Long idChambre, TypeChambre typeChambre) {
        Chambre chambre = chambreRepository.findById(idChambre).orElse(null);
        if (chambre == null) {
            return null;
        }
        chambre.setTypeC(typeChambre);
        return chambreRepository.save(chambre);
    }

    @Scheduled(cron = "*/5 * * * * *") // toutes les 5 secondes
    public void taskEvery5Seconds() {
        System.out.println("Tâche exécutée toutes les 5 secondes - " );
    }
    @Scheduled(cron = "0 * * * * *") // toutes les minutes
    public void taskEveryMinute() {
        System.out.println("[CRON] execution au debut de chaque minute " );
    }

    @Scheduled(cron = "0 0 8 * * *") // tous les jours à 8h00 du matin
    public void taskEveryDay8AM() {
        System.out.println("[CRON] execution quotidienne a 8h00" );
    }


    @Scheduled(cron = "0 */30 * * * *") // toutes les 30 minutes
    public void taskEvery30Minutes() {
        System.out.println("[CRON] execution toutes les 30 minutes " );
    }


    @Scheduled(cron = "0 0 14 * * MON") // tous les lundis à 14h00
    public void taskEveryMondayAt14() {
        System.out.println("[CRON] execution achaque lundi a 14h00 " );
    }

    @Scheduled(cron = "0 0 9 * * MON-FRI")
    public void taskWeekdaysAt9AM() {
        System.out.println("[CRON] execution du lundi au vendredi a 9h00 " );
    }


    @Transactional(readOnly = true)
    @Scheduled(fixedRate = 60000, initialDelay = 1000) // toutes les minutes
    public void afficherChambresParBloc() {
        List<Bloc> blocs = blocRepository.findAll();

        for (Bloc bloc : blocs) {
            System.out.println("Bloc: " + bloc.getNomBloc());
            if (bloc.getChambre() != null && !bloc.getChambre().isEmpty()) {
                bloc.getChambre().forEach(chambre ->
                        System.out.println("  Chambre n°" + chambre.getNumeroChambre() +
                                ", Type: " + chambre.getTypeC()));
            } else {
                System.out.println("  Aucune chambre dans ce bloc");
            }
        }
    }

    // SERVICE : Se déclenche toutes les 5 minutes
    @Scheduled(fixedRate = 300000, initialDelay = 5000) // 300000 ms = 5 minutes
    public void pourcentageChambreParTypeChambre() {
        // Récupérer toutes les chambres
        List<Chambre> chambres = chambreRepository.findAll();

        // Calculer le nombre total de chambres
        long totalChambres = chambres.size();

        if (totalChambres == 0) {
            System.out.println("==============================================");
            System.out.println("Aucune chambre trouvée dans la base de données");
            System.out.println("==============================================");
            return;
        }

        // Grouper les chambres par type et compter chaque type
        Map<TypeChambre, Long> chambreParType = chambres.stream()
                .filter(chambre -> chambre.getTypeC() != null)
                .collect(Collectors.groupingBy(Chambre::getTypeC, Collectors.counting()));

        // Affichage formaté
        System.out.println("==============================================");
        System.out.println("STATISTIQUES DES CHAMBRES");
        System.out.println("==============================================");
        System.out.println("Nombre total de chambres : " + totalChambres);
        System.out.println("----------------------------------------------");

        // Afficher le pourcentage pour chaque type
        for (TypeChambre type : TypeChambre.values()) {
            long count = chambreParType.getOrDefault(type, 0L);
            double pourcentage = (count * 100.0) / totalChambres;

            System.out.printf("Type %s : %d chambres (%.2f%%)%n",
                    type.name(), count, pourcentage);
        }

        System.out.println("==============================================\n");
    }

    // ✅ NOUVEAU SERVICE : Places disponibles par chambre pour l'année en cours
    @Transactional(readOnly = true)
    @Scheduled(fixedRate = 300000, initialDelay = 5000) // 300000 ms = 5 minutes
    public void nbPlacesDisponibleParChambreAnneeEnCours() {
        // Récupérer toutes les chambres
        List<Chambre> chambres = chambreRepository.findAll();

        // Obtenir l'année en cours
        int anneeEnCours = Calendar.getInstance().get(Calendar.YEAR);

        System.out.println("==============================================");
        System.out.println("PLACES DISPONIBLES PAR CHAMBRE - ANNÉE " + anneeEnCours);
        System.out.println("==============================================");

        if (chambres.isEmpty()) {
            System.out.println("Aucune chambre trouvée dans la base de données");
            System.out.println("==============================================\n");
            return;
        }

        for (Chambre chambre : chambres) {
            // Calculer la capacité totale selon le type de chambre
            int capaciteTotale = getCapaciteParType(chambre.getTypeC());

            // Compter le nombre de réservations pour cette chambre pour l'année en cours
            long nombreReservations = 0;
            if (chambre.getReservation() != null) {
                nombreReservations = chambre.getReservation().stream()
                        .filter(reservation -> reservation.getAnneeUniversitaire() != null)
                        .filter(reservation -> {
                            Calendar cal = Calendar.getInstance();
                            cal.setTime(reservation.getAnneeUniversitaire());
                            return cal.get(Calendar.YEAR) == anneeEnCours;
                        })
                        .filter(reservation -> reservation.isEstValide()) // Optionnel: ne compter que les réservations valides
                        .count();
            }

            // Calculer les places disponibles
            long placesDisponibles = capaciteTotale - nombreReservations;

            System.out.printf("Chambre n°%d (%s) : %d/%d places disponibles%n",
                    chambre.getNumeroChambre(),
                    chambre.getTypeC(),
                    placesDisponibles,
                    capaciteTotale);
        }

        System.out.println("==============================================\n");
    }

    /**
     * Méthode helper pour obtenir la capacité selon le type de chambre
     * @param type Le type de chambre (SIMPLE, DOUBLE, TRIPLE)
     * @return La capacité maximale de la chambre
     */
    private int getCapaciteParType(TypeChambre type) {
        if (type == null) {
            return 0;
        }

        switch (type) {
            case SIMPLE:
                return 1;
            case DOUBLE:
                return 2;
            case TRIPLE:
                return 3;
            default:
                return 0;
        }
    }

//    @Scheduled(
//            initialDelay = 10,
//            fixedDelay = 1,
//            timeUnit = TimeUnit.SECONDS)
//    public void reportTask(){
//        System.out.println("Rapport Executé");
//    }
//    @Scheduled(
//            fixedRate = 2,
//            timeUnit = TimeUnit.SECONDS
//    )
//    public void refreshCache(){
//        System.out.println("Rapport Refresh");
//    }
//    @Scheduled(fixedDelay = 10000)
//    public void fixedDelayMethod(){
//        System.out.println("Rapport Fixed Delay");
//    }
}