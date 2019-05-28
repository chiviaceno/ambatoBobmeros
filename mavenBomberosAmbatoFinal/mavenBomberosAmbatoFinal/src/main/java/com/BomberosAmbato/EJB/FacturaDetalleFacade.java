
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.FacturaDetalle;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class FacturaDetalleFacade extends AbstractFacade<FacturaDetalle> implements FacturaDetalleFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaDetalleFacade() {
        super(FacturaDetalle.class);
    }
    
}
