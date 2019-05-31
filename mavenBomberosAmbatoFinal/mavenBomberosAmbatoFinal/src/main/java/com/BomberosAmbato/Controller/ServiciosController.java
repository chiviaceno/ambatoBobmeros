package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.RequisitosFacadeLocal;
import com.BomberosAmbato.EJB.ServicioFacadeLocal;
import com.BomberosAmbato.EJB.ServicioRequisitosFacadeLocal;
import com.BomberosAmbato.Model.Requisitos;
import com.BomberosAmbato.Model.Servicio;
import com.BomberosAmbato.Model.ServicioRequisitos;
import java.io.Serializable;
import java.util.List;
import javax.annotation.PostConstruct;

import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@ViewScoped
public class ServiciosController implements Serializable {

    @EJB
    private ServicioRequisitosFacadeLocal servicioRequisitosEJB;

    @EJB
    private RequisitosFacadeLocal requisitosEJB;

    
    @Inject
    private Servicio servicio;
    @Inject
    private Requisitos requisitos;
    @Inject
    private ServicioRequisitos serviciosRequisitos;

    private List<Requisitos> listaRequisitos;

    @PostConstruct
    public void init() {
//        servicio = new Servicio();
//        requisitos = new Requisitos();
//        serviciosRequisitos = new ServicioRequisitos();
        
        listaRequisitos = requisitosEJB.findAll();
    }

    public void registrar() {
        try {
            serviciosRequisitos.setReqId(requisitos);
            serviciosRequisitos.setSerId(servicio);
            servicioRequisitosEJB.create(serviciosRequisitos);
            
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Aviso", "Usuario Creado Correctamente"));
        } catch (Exception e) {
            FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_FATAL, "Aviso", "Error!"));
        }

    }

    public Servicio getServicio() {
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

    public Requisitos getRequisitos() {
        return requisitos;
    }

    public void setRequisitos(Requisitos requisitos) {
        this.requisitos = requisitos;
    }

    public ServicioRequisitos getServiciosRequisitos() {
        return serviciosRequisitos;
    }

    public void setServiciosRequisitos(ServicioRequisitos serviciosRequisitos) {
        this.serviciosRequisitos = serviciosRequisitos;
    }

    public List<Requisitos> getListaRequisitos() {
        return listaRequisitos;
    }

    public void setListaRequisitos(List<Requisitos> listaRequisitos) {
        this.listaRequisitos = listaRequisitos;
    }

}
