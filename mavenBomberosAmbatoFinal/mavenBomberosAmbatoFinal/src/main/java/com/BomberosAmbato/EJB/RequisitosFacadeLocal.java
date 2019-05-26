/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Requisitos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis
 */
@Local
public interface RequisitosFacadeLocal {

    void create(Requisitos requisitos);

    void edit(Requisitos requisitos);

    void remove(Requisitos requisitos);

    Requisitos find(Object id);

    List<Requisitos> findAll();

    List<Requisitos> findRange(int[] range);

    int count();
    
}
