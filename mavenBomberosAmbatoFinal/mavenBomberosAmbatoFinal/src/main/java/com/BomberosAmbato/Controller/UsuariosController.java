

package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.UsuariosFacadeLocal;
import com.BomberosAmbato.Model.Persona;
import com.BomberosAmbato.Model.Usuarios;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class UsuariosController implements Serializable{
    
    @EJB
    private UsuariosFacadeLocal usuariosEJB;

    private Usuarios usuarios;
    private Persona persona;

    private List<Usuarios> lUsuario;
    private List<Usuarios> lCliente;
    
    
    @PostConstruct
    public void init() {
        usuarios = new Usuarios();
        persona = new Persona();
        
        lUsuario = (List<Usuarios>) usuariosEJB.listarUsuarios(usuarios);
        lCliente = (List<Usuarios>) usuariosEJB.listarClientes(usuarios);
        
    }
    
    // este metodo creamos tanto al cliente como el usuario con el que ingresara a la aplicacion.

    public void registrarUsuario() {
        Usuarios us;
        try {
            //validamos si no existe me deja crear caso contrario me muestra un mensaje
            us=  usuariosEJB.usuarioExiste(usuarios);
            if (us == null) {

                persona.setEstado("Activo");
                usuarios.setPerId(persona);
                
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

    public List<Usuarios> getlUsuario() {
        return lUsuario;
    }

    public void setlUsuario(List<Usuarios> lUsuario) {
        this.lUsuario = lUsuario;
    }

    public List<Usuarios> getlCliente() {
        return lCliente;
    }

    public void setlCliente(List<Usuarios> lCliente) {
        this.lCliente = lCliente;
    }
    
    
}
