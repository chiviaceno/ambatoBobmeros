
package com.bom.beans;

import com.bom.dao.usuarioDao;
import com.bom.entidades.Usuarios;
import com.bom.imp.usuarioDaoImp;
import javax.inject.Named;
import javax.enterprise.context.SessionScoped;
import java.io.Serializable;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpSession;
import org.primefaces.PrimeFaces;


@Named(value = "managedBeanLogin")
@SessionScoped
public class ManagedBeanLogin implements Serializable {

    private String nombreUsuario;
    private Usuarios usuarios; 
    private String password;
    
 
    public ManagedBeanLogin() {
        this.usuarios = new Usuarios();
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public Usuarios getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(Usuarios usuarios) {
        this.usuarios = usuarios;
    }
    
    public String getPassword() {
        return password;
    }
 
    public void setPassword(String password) {
        this.password = password;
    }
   
    public void login() {
        FacesMessage message = null;
        boolean loggedIn = false;
        String ruta ="";
         usuarioDao uDao = new usuarioDaoImp();
        this.usuarios = uDao.login(this.usuarios);
                
         if(this.usuarios != null) {
            loggedIn = true;
            message = new FacesMessage(FacesMessage.SEVERITY_INFO, "Bienvenid@", this.usuarios.getPersona().getNombre());
            ruta ="Servicio_Bomberos/faces/Admin/indexAdministrator.xhtml";
        } else {
            loggedIn = false;
            message = new FacesMessage(FacesMessage.SEVERITY_WARN, "Loggin Error", "Invalid credentials");
        }
         
        FacesContext.getCurrentInstance().addMessage(null, message);
        PrimeFaces.current().ajax().addCallbackParam("loggedIn", loggedIn);
    }   
    
    public String cerrarSesion(){
      this.nombreUsuario = null;
      this.password = null;
      
      HttpSession httpSession = (HttpSession) FacesContext.getCurrentInstance().getExternalContext().getSession(false);
      httpSession.invalidate();
      return "/Login/Login";
    }
}
