
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.InspecionCabecera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InspecionCabeceraFacade extends AbstractFacade<InspecionCabecera> implements InspecionCabeceraFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InspecionCabeceraFacade() {
        super(InspecionCabecera.class);
    }
    
}
