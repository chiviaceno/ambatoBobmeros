package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.UsuariosFacadeLocal;
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
public class LoginController implements Serializable {

    @EJB
    private UsuariosFacadeLocal usuariosEJB;
    private Usuarios usuarios;

    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
    }

    public String iniciarSesion() {
        Usuarios us;
        String redireccion = null;
        try {
             us = usuariosEJB.iniciarSesion(usuarios);
             if (us!=null) {
                 // Almacenar la session de JSF 
                 FacesContext.getCurrentInstance().getExternalContext().getSessionMap().put("usuarios", us);
                 // Esta parte verificamos el tipo de Usuario con el que se logeo para darle acceso a sus paginas
                 switch (us.getTipoUsuario()) {
                     case "Administrador":
                         redireccion = "/Admin/indexAdministrador?faces-redirect=true";
                         break;
                     case "Inspector":
                         redireccion = "/Inspector/indexInspector?faces-redirect=true";
                         break;
                     case "Contador":
                         redireccion = "/Contador/indexContador?faces-redirect=true";
                         break;
                     case "Cliente":
                         redireccion = "/Cliente/indexCliente?faces-redirect=true";
                         break;
                     default:
                         break;
                 }
             }            
             else{
                 FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_WARN, "Aviso", "Credenciales Incorrectas"));
             }
           
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }
        return redireccion;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios Usuarios) {
        this.usuarios = Usuarios;
    }

}
