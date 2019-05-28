
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Requisitos;
import java.util.List;
import javax.ejb.Local;


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
