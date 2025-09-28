package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    public String idReservation; // pas auto-généré selon diagramme

    @Temporal(TemporalType.DATE)
    public Date anneeUniversitaire;

    public boolean estValide;


}
