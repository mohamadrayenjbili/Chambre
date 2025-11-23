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
public class Foyer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idFoyer;

    @Column(nullable = false)
    public String nomFoyer;

    public Long capaciteFoyer;

    @OneToOne (mappedBy = "foyer")
    private Universite universite;
    @OneToMany(mappedBy = "foyer")
    private List<Bloc> blocs;

    public void setIdFoyer(Long idFoyer) {
        this.idFoyer = idFoyer;
    }

    public void setUniversite(Universite universite) {
        this.universite = universite;
    }

    public void setNomFoyer(String nomFoyer) {
        this.nomFoyer = nomFoyer;
    }

    public void setCapaciteFoyer(Long capaciteFoyer) {
        this.capaciteFoyer = capaciteFoyer;
    }
}
