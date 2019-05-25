package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.RequisitosFacadeLocal;
import com.BomberosAmbato.Model.Requisitos;
import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class RequisitosController implements Serializable{
    
    @EJB
    private RequisitosFacadeLocal requisitoEJB;
    private Requisitos requisitos;
    
    @PostConstruct
    public void init(){
        requisitos = new Requisitos();
    }
            
    public void registrar(){
        try{
            requisitoEJB.create(requisitos);
        }catch(Exception e){
            // mensaje 
        }
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }
    
}
