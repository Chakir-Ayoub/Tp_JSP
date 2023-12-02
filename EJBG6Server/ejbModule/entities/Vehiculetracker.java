/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Lachgar
 */
@Entity
@Table(name = "vehiculetracker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vehiculetracker.findAll", query = "SELECT v FROM Vehiculetracker v"),
    @NamedQuery(name = "Vehiculetracker.findByDateDebut", query = "SELECT v FROM Vehiculetracker v WHERE v.vehiculetrackerPK.dateDebut = :dateDebut"),
    @NamedQuery(name = "Vehiculetracker.findByTracker", query = "SELECT v FROM Vehiculetracker v WHERE v.vehiculetrackerPK.tracker = :tracker"),
    @NamedQuery(name = "Vehiculetracker.findByVehicule", query = "SELECT v FROM Vehiculetracker v WHERE v.vehiculetrackerPK.vehicule = :vehicule"),
    @NamedQuery(name = "Vehiculetracker.findByDateFin", query = "SELECT v FROM Vehiculetracker v WHERE v.dateFin = :dateFin")})
public class Vehiculetracker implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected VehiculetrackerPK vehiculetrackerPK;
    @Column(name = "dateFin")
    @Temporal(TemporalType.DATE)
    private Date dateFin;
    @JoinColumn(name = "tracker", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Tracker tracker1;
    @JoinColumn(name = "vehicule", referencedColumnName = "id", insertable = false, updatable = false)
    @ManyToOne(optional = false, fetch = FetchType.EAGER)
    private Vehicule vehicule1;

    public Vehiculetracker() {
    }

    public Vehiculetracker(VehiculetrackerPK vehiculetrackerPK) {
        this.vehiculetrackerPK = vehiculetrackerPK;
    }

    public Vehiculetracker(Date dateDebut, int tracker, int vehicule) {
        this.vehiculetrackerPK = new VehiculetrackerPK(dateDebut, tracker, vehicule);
    }

    public VehiculetrackerPK getVehiculetrackerPK() {
        return vehiculetrackerPK;
    }

    public void setVehiculetrackerPK(VehiculetrackerPK vehiculetrackerPK) {
        this.vehiculetrackerPK = vehiculetrackerPK;
    }

    public Date getDateFin() {
        return dateFin;
    }

    public void setDateFin(Date dateFin) {
        this.dateFin = dateFin;
    }

    public Tracker getTracker1() {
        return tracker1;
    }

    public void setTracker1(Tracker tracker1) {
        this.tracker1 = tracker1;
    }

    public Vehicule getVehicule1() {
        return vehicule1;
    }

    public void setVehicule1(Vehicule vehicule1) {
        this.vehicule1 = vehicule1;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (vehiculetrackerPK != null ? vehiculetrackerPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vehiculetracker)) {
            return false;
        }
        Vehiculetracker other = (Vehiculetracker) object;
        if ((this.vehiculetrackerPK == null && other.vehiculetrackerPK != null) || (this.vehiculetrackerPK != null && !this.vehiculetrackerPK.equals(other.vehiculetrackerPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Vehiculetracker[ vehiculetrackerPK=" + vehiculetrackerPK + " ]";
    }
    
}
