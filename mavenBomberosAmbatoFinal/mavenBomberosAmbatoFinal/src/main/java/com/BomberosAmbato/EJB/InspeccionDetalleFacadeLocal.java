/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.InspeccionDetalle;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis Orellana
 */
@Local
public interface InspeccionDetalleFacadeLocal {

    void create(InspeccionDetalle inspeccionDetalle);

    void edit(InspeccionDetalle inspeccionDetalle);

    void remove(InspeccionDetalle inspeccionDetalle);

    InspeccionDetalle find(Object id);

    List<InspeccionDetalle> findAll();

    List<InspeccionDetalle> findRange(int[] range);

    int count();
    
}
