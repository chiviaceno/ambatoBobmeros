
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.FacturaCabecera;
import java.util.List;
import javax.ejb.Local;


@Local
public interface FacturaCabeceraFacadeLocal {

    void create(FacturaCabecera facturaCabecera);

    void edit(FacturaCabecera facturaCabecera);

    void remove(FacturaCabecera facturaCabecera);

    FacturaCabecera find(Object id);

    List<FacturaCabecera> findAll();

    List<FacturaCabecera> findRange(int[] range);

    int count();
    
}
