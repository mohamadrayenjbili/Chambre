package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Chambre {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idChambre;

   // @Column(nullable = false, unique = true)
    public Long numeroChambre;

    @Enumerated(EnumType.STRING) // Sauvegarder l'énum comme texte (SIMPLE, DOUBLE, TRIPLE)
   // @Column(nullable = false)
    public TypeChambre typeC;
    @ManyToOne
    private Bloc bloc;
    @OneToMany
    private List<Reservation> reservation;

    public void setIdChambre(Long idChambre) {
        this.idChambre = idChambre;
    }

    public void setBloc(Bloc bloc) {
        this.bloc = bloc;
    }

    public void setReservation(List<Reservation> reservation) {
        this.reservation = reservation;
    }

    public void setTypeC(TypeChambre typeC) {
        this.typeC = typeC;
    }

    public void setNumeroChambre(Long numeroChambre) {
        this.numeroChambre = numeroChambre;
    }

    public List<Reservation> getReservation() {
        return reservation;
    }

    public Bloc getBloc() {
        return bloc;
    }

    public Long getNumeroChambre() {
        return numeroChambre;
    }

    public TypeChambre getTypeC() {
        return typeC;
    }

    public Long getIdChambre() {
        return idChambre;

    }

}
