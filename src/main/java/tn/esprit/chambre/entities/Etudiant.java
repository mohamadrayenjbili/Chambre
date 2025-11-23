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

    @ManyToMany(mappedBy = "etudiantList")
    private List<Reservation> reservationList = new ArrayList<>();

    public String getNomEt() {
        return nomEt;
    }

    public Long getIdEtudiant() {
        return idEtudiant;
    }

    public String getPrenomEt() {
        return prenomEt;
    }

    public Long getCin() {
        return cin;
    }

    public String getEcole() {
        return ecole;
    }

    public Date getDateNaissance() {
        return dateNaissance;
    }

    public List<Reservation> getReservationList() {
        return reservationList;
    }

    public void setReservationList(List<Reservation> reservationList) {
        this.reservationList = reservationList;
    }

    public void setDateNaissance(Date dateNaissance) {
        this.dateNaissance = dateNaissance;
    }

    public void setEcole(String ecole) {
        this.ecole = ecole;
    }

    public void setCin(Long cin) {
        this.cin = cin;
    }

    public void setPrenomEt(String prenomEt) {
        this.prenomEt = prenomEt;
    }

    public void setNomEt(String nomEt) {
        this.nomEt = nomEt;
    }

    public void setIdEtudiant(Long idEtudiant) {
        this.idEtudiant = idEtudiant;
    }
}