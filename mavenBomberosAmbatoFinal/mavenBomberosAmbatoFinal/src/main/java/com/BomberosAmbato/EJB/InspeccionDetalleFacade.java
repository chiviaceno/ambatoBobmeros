
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.InspeccionDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class InspeccionDetalleFacade extends AbstractFacade<InspeccionDetalle> implements InspeccionDetalleFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public InspeccionDetalleFacade() {
        super(InspeccionDetalle.class);
    }
    
}
