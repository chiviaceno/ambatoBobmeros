/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.PermisoFuncionamiento;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Dennis Orellana
 */
@Local
public interface PermisoFuncionamientoFacadeLocal {

    void create(PermisoFuncionamiento permisoFuncionamiento);

    void edit(PermisoFuncionamiento permisoFuncionamiento);

    void remove(PermisoFuncionamiento permisoFuncionamiento);

    PermisoFuncionamiento find(Object id);

    List<PermisoFuncionamiento> findAll();

    List<PermisoFuncionamiento> findRange(int[] range);

    int count();
    
}
