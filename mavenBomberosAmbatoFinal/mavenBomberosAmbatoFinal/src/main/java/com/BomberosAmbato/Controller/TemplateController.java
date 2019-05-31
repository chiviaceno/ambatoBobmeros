
package com.BomberosAmbato.Controller;

import com.BomberosAmbato.Model.Usuarios;
import java.io.IOException;

import java.io.Serializable;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class TemplateController implements Serializable{
    
    // se controla si esque esta o no loguedo para que pueda acceder a dicha url
    public void verificarSesion(){
        try {
            FacesContext context = FacesContext.getCurrentInstance();
          Usuarios us= (Usuarios) context.getExternalContext().getSessionMap().get("usuarios");
          
          if(us== null){
          context.getExternalContext().redirect("./../permisos.xhtml");
          }
        } catch (IOException e) {
        }
    }
    public void cerrarSesion(){
        FacesContext.getCurrentInstance().getExternalContext().invalidateSession();
    }
}
