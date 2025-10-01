package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Universite {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idUniversite;

    @Column(nullable = false)
    public String nomUniversite;

    @Column(nullable = false)
    public String adresse;

    @OneToOne
    private Foyer foyer;
}
