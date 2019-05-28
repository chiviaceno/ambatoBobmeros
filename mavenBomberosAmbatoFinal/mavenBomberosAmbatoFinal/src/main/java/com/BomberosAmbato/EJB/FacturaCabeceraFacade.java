
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.FacturaCabecera;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class FacturaCabeceraFacade extends AbstractFacade<FacturaCabecera> implements FacturaCabeceraFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public FacturaCabeceraFacade() {
        super(FacturaCabecera.class);
    }
    
}
