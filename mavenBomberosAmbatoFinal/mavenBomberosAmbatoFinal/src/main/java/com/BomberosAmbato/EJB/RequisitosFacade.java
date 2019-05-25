/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Requisitos;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Dennis Orellana
 */
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
