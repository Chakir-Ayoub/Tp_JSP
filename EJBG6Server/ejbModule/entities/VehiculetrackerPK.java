/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.Date;
import jakarta.persistence.Basic;
import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import jakarta.validation.constraints.NotNull;

/**
 *
 * @author Lachgar
 */
@Embeddable
public class VehiculetrackerPK implements Serializable {
    @Basic(optional = false)
    @NotNull
    @Column(name = "dateDebut")
    @Temporal(TemporalType.DATE)
    private Date dateDebut;
    @Basic(optional = false)
    @NotNull
    @Column(name = "tracker")
    private int tracker;
    @Basic(optional = false)
    @NotNull
    @Column(name = "vehicule")
    private int vehicule;

    public VehiculetrackerPK() {
    }

    public VehiculetrackerPK(Date dateDebut, int tracker, int vehicule) {
        this.dateDebut = dateDebut;
        this.tracker = tracker;
        this.vehicule = vehicule;
    }

    public Date getDateDebut() {
        return dateDebut;
    }

    public void setDateDebut(Date dateDebut) {
        this.dateDebut = dateDebut;
    }

    public int getTracker() {
        return tracker;
    }

    public void setTracker(int tracker) {
        this.tracker = tracker;
    }

    public int getVehicule() {
        return vehicule;
    }

    public void setVehicule(int vehicule) {
        this.vehicule = vehicule;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (dateDebut != null ? dateDebut.hashCode() : 0);
        hash += (int) tracker;
        hash += (int) vehicule;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof VehiculetrackerPK)) {
            return false;
        }
        VehiculetrackerPK other = (VehiculetrackerPK) object;
        if ((this.dateDebut == null && other.dateDebut != null) || (this.dateDebut != null && !this.dateDebut.equals(other.dateDebut))) {
            return false;
        }
        if (this.tracker != other.tracker) {
            return false;
        }
        if (this.vehicule != other.vehicule) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.VehiculetrackerPK[ dateDebut=" + dateDebut + ", tracker=" + tracker + ", vehicule=" + vehicule + " ]";
    }
    
}
