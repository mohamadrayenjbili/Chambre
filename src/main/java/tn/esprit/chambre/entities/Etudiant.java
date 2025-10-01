package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Etudiant {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idEtudiant;

    @Column(nullable = false)
    public String nomEt;

    @Column(nullable = false)
    public String prenomEt;

    @Column(nullable = false, unique = true)
    public Long cin;

    public String ecole;

    @Temporal(TemporalType.DATE)
    public Date dateNaissance;
    @ManyToMany(mappedBy = "etudiant")
    private List <Reservation> reservation;
}
