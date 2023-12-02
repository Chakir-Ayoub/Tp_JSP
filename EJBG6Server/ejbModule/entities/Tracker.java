/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import jakarta.persistence.Basic;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.NamedQueries;
import jakarta.persistence.NamedQuery;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Size;
import jakarta.xml.bind.annotation.XmlRootElement;
import jakarta.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Lachgar
 */
@Entity
@Table(name = "tracker")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tracker.findAll", query = "SELECT t FROM Tracker t"),
    @NamedQuery(name = "Tracker.findById", query = "SELECT t FROM Tracker t WHERE t.id = :id"),
    @NamedQuery(name = "Tracker.findBySimNumber", query = "SELECT t FROM Tracker t WHERE t.simNumber = :simNumber")})
public class Tracker implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "simNumber")
    private String simNumber;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "tracker1", fetch = FetchType.EAGER)
    private List<Vehiculetracker> vehiculetrackerList;

    public Tracker() {
    }

    public Tracker(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getSimNumber() {
        return simNumber;
    }

    public void setSimNumber(String simNumber) {
        this.simNumber = simNumber;
    }

    @XmlTransient
    public List<Vehiculetracker> getVehiculetrackerList() {
        return vehiculetrackerList;
    }

    public void setVehiculetrackerList(List<Vehiculetracker> vehiculetrackerList) {
        this.vehiculetrackerList = vehiculetrackerList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Tracker)) {
            return false;
        }
        Tracker other = (Tracker) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "entities.Tracker[ id=" + id + " ]";
    }
    
}
