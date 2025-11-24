package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.List;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Bloc {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idBloc;

    @Column(nullable = false)
    private String nomBloc;

    private Long capaciteBloc;

    @ManyToOne
    private Foyer foyer;

    @OneToMany(mappedBy = "bloc")
    private List<Chambre> chambre;

    // GETTERS
    public Long getIdBloc() {
        return idBloc;
    }

    public String getNomBloc() {
        return nomBloc;
    }

    public Long getCapaciteBloc() {
        return capaciteBloc;
    }

    public Foyer getFoyer() {
        return foyer;
    }

    public List<Chambre> getChambre() {
        return chambre;
    }

    // SETTERS
    public void setIdBloc(Long idBloc) {
        this.idBloc = idBloc;
    }

    public void setNomBloc(String nomBloc) {
        this.nomBloc = nomBloc;
    }

    public void setCapaciteBloc(Long capaciteBloc) {
        this.capaciteBloc = capaciteBloc;
    }

    public void setFoyer(Foyer foyer) {
        this.foyer = foyer;
    }

    public void setChambre(List<Chambre> chambre) {
        this.chambre = chambre;
    }
}