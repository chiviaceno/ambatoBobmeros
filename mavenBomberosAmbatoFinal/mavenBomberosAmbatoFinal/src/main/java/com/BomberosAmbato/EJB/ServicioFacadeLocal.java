
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Servicio;
import java.util.List;
import javax.ejb.Local;

@Local
public interface ServicioFacadeLocal {

    void create(Servicio servicio);

    void edit(Servicio servicio);

    void remove(Servicio servicio);

    Servicio find(Object id);

    List<Servicio> findAll();

    List<Servicio> findRange(int[] range);

    int count();
    
}
