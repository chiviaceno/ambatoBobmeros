
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Archivos;
import java.util.List;
import javax.ejb.Local;

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
