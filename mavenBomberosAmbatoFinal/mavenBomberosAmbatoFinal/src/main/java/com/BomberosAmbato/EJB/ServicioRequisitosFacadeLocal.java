/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.ServicioRequisitos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis
 */
@Local
public interface ServicioRequisitosFacadeLocal {

    void create(ServicioRequisitos servicioRequisitos);

    void edit(ServicioRequisitos servicioRequisitos);

    void remove(ServicioRequisitos servicioRequisitos);

    ServicioRequisitos find(Object id);

    List<ServicioRequisitos> findAll();

    List<ServicioRequisitos> findRange(int[] range);

    int count();
    
}
