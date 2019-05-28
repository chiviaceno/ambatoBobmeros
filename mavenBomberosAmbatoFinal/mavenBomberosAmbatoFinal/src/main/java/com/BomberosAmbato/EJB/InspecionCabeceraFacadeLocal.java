
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.InspecionCabecera;
import java.util.List;
import javax.ejb.Local;

@Local
public interface InspecionCabeceraFacadeLocal {

    void create(InspecionCabecera inspecionCabecera);

    void edit(InspecionCabecera inspecionCabecera);

    void remove(InspecionCabecera inspecionCabecera);

    InspecionCabecera find(Object id);

    List<InspecionCabecera> findAll();

    List<InspecionCabecera> findRange(int[] range);

    int count();
    
}
