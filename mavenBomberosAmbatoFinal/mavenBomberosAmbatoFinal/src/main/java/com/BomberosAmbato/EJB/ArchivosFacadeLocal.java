/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Archivos;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis
 */
@Local
public interface ArchivosFacadeLocal {

    void create(Archivos archivos);

    void edit(Archivos archivos);

    void remove(Archivos archivos);

    Archivos find(Object id);

    List<Archivos> findAll();

    List<Archivos> findRange(int[] range);

    int count();
    
}
