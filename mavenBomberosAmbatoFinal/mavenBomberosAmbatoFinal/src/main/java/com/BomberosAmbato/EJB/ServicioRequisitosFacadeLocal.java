
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.ServicioRequisitos;
import java.util.List;
import javax.ejb.Local;


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
