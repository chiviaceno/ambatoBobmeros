
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.PermisoFuncionamiento;
import java.util.List;
import javax.ejb.Local;


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
