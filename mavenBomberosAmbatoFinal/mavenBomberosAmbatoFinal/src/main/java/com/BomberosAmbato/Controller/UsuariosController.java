package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.UsuariosFacadeLocal;
import com.BomberosAmbato.Model.Persona;
import com.BomberosAmbato.Model.Usuarios;
import java.io.Serializable;

import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuariosController implements Serializable{

    
    

    @EJB
    private UsuariosFacadeLocal usuariosEJBB;
    
    @Inject
    private Usuarios usuarios;
    
    @Inject
    private Persona persona;
    
    

    public void registrar(){
        try {
            persona.setEstado("Activo");
            usuarios.setTipoUsuario("Cliente");
            usuarios.setPerId(persona);
            usuariosEJBB.create(usuarios);
        } catch (Exception e) {
            //mensaje con Groul
        }
    }
    
    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }

    public Persona getPersona() {
        return persona;
    }

    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    
    
}
