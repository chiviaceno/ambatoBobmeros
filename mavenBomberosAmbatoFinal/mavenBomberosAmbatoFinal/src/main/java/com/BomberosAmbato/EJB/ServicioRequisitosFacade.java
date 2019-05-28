
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.ServicioRequisitos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Stateless
public class ServicioRequisitosFacade extends AbstractFacade<ServicioRequisitos> implements ServicioRequisitosFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public ServicioRequisitosFacade() {
        super(ServicioRequisitos.class);
    }
    
}
