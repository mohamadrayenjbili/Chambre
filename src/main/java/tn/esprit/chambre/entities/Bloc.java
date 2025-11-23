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
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long idBloc;

    @Column(nullable = false)
    public String nomBloc;

    public Long capaciteBloc;
    @ManyToOne
    private Foyer foyer;
    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambre;

    public void setIdBloc(Long idBloc) {
        this.idBloc = idBloc;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public void setCapaciteBloc(Long capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }
}
