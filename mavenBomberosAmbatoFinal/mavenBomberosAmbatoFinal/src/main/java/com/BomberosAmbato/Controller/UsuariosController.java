package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.PersonaFacadeLocal;
import com.BomberosAmbato.EJB.UsuariosFacadeLocal;
import com.BomberosAmbato.Model.Persona;
import com.BomberosAmbato.Model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named
@ViewScoped
public class UsuariosController implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosEJB;
   

    private Usuarios usuarios;
    private Persona persona;

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
        persona = new Persona();
    }

    public void registrarPersona() {
        try {
            persona.setEstado("Activo");
            usuarios.setPerId(persona);
            usuarios.setTipoUsuario("Cliente");
            usuariosEJB.create(usuarios);
         

        } catch (Exception e) {
        }
    }

    public void registrarUsuario() {
        try {
            this.usuarios.setPerId(persona);
            usuarios.setTipoUsuario("Cliente");
            usuariosEJB.create(usuarios);

        } catch (Exception e) {
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
