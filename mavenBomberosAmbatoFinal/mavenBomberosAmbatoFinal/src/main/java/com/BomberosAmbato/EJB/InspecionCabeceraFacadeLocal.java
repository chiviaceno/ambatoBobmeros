/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.InspecionCabecera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis Orellana
 */
@Local
public interface InspecionCabeceraFacadeLocal {

    void create(InspecionCabecera inspecionCabecera);

    void edit(InspecionCabecera inspecionCabecera);

    void remove(InspecionCabecera inspecionCabecera);

    InspecionCabecera find(Object id);

    List<InspecionCabecera> findAll();

    List<InspecionCabecera> findRange(int[] range);

    int count();
    
}
