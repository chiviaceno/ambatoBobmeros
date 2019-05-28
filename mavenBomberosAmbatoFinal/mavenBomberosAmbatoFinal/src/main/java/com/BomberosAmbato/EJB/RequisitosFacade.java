
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Requisitos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class RequisitosFacade extends AbstractFacade<Requisitos> implements RequisitosFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public RequisitosFacade() {
        super(Requisitos.class);
    }
    
}
