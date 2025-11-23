package tn.esprit.chambre.entities;

import jakarta.persistence.*;
import lombok.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class Reservation {

    @Id
    public String idReservation;

    @Temporal(TemporalType.DATE)
    public Date anneeUniversitaire;

    public boolean estValide;

    @ManyToMany
    private List<Etudiant> etudiantList = new ArrayList<>();

    public void setAnneeUniversitaire(Date anneeUniversitaire) {
        this.anneeUniversitaire = anneeUniversitaire;
    }

    public void setIdReservation(String idReservation) {
        this.idReservation = idReservation;
    }

    public void setEstValide(boolean estValide) {
        this.estValide = estValide;
    }

    public void setEtudiantList(List<Etudiant> etudiantList) {
        this.etudiantList = etudiantList;
    }

    public List<Etudiant> getEtudiantList() {
        return etudiantList;
    }

    public boolean isEstValide() {
        return estValide;
    }

    public Date getAnneeUniversitaire() {
        return anneeUniversitaire;
    }

    public String getIdReservation() {
        return idReservation;
    }
}