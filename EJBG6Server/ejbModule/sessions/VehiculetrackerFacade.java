/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sessions;

import entities.Vehiculetracker;
import jakarta.ejb.Stateless;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;

/**
 *
 * @author Lachgar
 */
@Stateless
public class VehiculetrackerFacade extends AbstractFacade<Vehiculetracker> {
    @PersistenceContext(unitName = "EJBG6PU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public VehiculetrackerFacade() {
        super(Vehiculetracker.class);
    }
    
}
