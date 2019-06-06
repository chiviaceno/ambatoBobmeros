
package com.BomberosAmbato.EJB;

import com.BomberosAmbato.Model.Usuarios;
import java.util.List;
import javax.ejb.Local;

@Local
public interface UsuariosFacadeLocal {

    void create(Usuarios usuarios);

    void edit(Usuarios usuarios);

    void remove(Usuarios usuarios);

    Usuarios find(Object id);

    List<Usuarios> findAll();

    List<Usuarios> findRange(int[] range);

    int count();
    
    Usuarios iniciarSesion(Usuarios us);
    Usuarios usuarioExiste(Usuarios us);
    Usuarios listarClientes(Usuarios us);
    Usuarios listarUsuarios(Usuarios us);
    
}
