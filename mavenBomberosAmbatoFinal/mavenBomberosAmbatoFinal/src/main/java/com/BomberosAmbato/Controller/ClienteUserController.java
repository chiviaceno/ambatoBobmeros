package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.UsuariosFacadeLocal;
import com.BomberosAmbato.Model.Persona;
import com.BomberosAmbato.Model.Usuarios;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;

import javax.inject.Named;

@Named
@ViewScoped
public class ClienteUserController implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosEJB;

    private Usuarios usuarios;
    private Persona persona;

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
        persona = new Persona();
    }
// este metodo creamos tanto al cliente como el usuario con el que ingresara a la aplicacion.

    public void registrarClieteUser() {
        Usuarios us;
        try {
            //validamos si no existe me deja crear caso contrario me muestra un mensaje
            us=  usuariosEJB.usuarioExiste(usuarios);
            if (us == null) {

                persona.setEstado("Activo");
                usuarios.setPerId(persona);
                usuarios.setTipoUsuario("Cliente");
                usuariosEJB.create(usuarios);
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Creado Correctamente"));
            } else {
                FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "El Usuario ya Exite, Intento con otro por Favor!"));
            }

        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
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
