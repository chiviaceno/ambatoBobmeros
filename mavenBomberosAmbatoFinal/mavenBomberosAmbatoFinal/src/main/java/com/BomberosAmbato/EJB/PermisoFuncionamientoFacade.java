/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.PermisoFuncionamiento;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dennis Orellana
 */
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
