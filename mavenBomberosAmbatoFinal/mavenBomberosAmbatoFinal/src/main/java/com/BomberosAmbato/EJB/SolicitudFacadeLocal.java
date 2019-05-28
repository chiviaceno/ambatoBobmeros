
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Solicitud;
import java.util.List;
import javax.ejb.Local;


@Local
public interface SolicitudFacadeLocal {

    void create(Solicitud solicitud);

    void edit(Solicitud solicitud);

    void remove(Solicitud solicitud);

    Solicitud find(Object id);

    List<Solicitud> findAll();

    List<Solicitud> findRange(int[] range);

    int count();
    
}
