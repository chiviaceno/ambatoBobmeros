/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.FacturaCabecera;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis
 */
@Local
public interface FacturaCabeceraFacadeLocal {

    void create(FacturaCabecera facturaCabecera);

    void edit(FacturaCabecera facturaCabecera);

    void remove(FacturaCabecera facturaCabecera);

    FacturaCabecera find(Object id);

    List<FacturaCabecera> findAll();

    List<FacturaCabecera> findRange(int[] range);

    int count();
    
}
