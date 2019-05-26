package com.BomberosAmbato.Controller;

import com.BomberosAmbato.Model.Persona;
import com.BomberosAmbato.Model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuariosController implements Serializable{

    private Usuarios usuarios;
    private Persona persona;

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
        persona = new Persona();
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
