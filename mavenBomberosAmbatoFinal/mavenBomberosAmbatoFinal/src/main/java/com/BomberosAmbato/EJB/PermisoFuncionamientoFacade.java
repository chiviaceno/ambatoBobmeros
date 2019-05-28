
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.PermisoFuncionamiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;


@Stateless
public class PermisoFuncionamientoFacade extends AbstractFacade<PermisoFuncionamiento> implements PermisoFuncionamientoFacadeLocal {

    @PersistenceContext(unitName = "bomberosAmbatoPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PermisoFuncionamientoFacade() {
        super(PermisoFuncionamiento.class);
    }
    
}
