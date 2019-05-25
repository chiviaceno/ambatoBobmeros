/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.FacturaDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis Orellana
 */
@Local
public interface FacturaDetalleFacadeLocal {

    void create(FacturaDetalle facturaDetalle);

    void edit(FacturaDetalle facturaDetalle);

    void remove(FacturaDetalle facturaDetalle);

    FacturaDetalle find(Object id);

    List<FacturaDetalle> findAll();

    List<FacturaDetalle> findRange(int[] range);

    int count();
    
}
