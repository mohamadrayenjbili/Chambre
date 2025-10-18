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

}
