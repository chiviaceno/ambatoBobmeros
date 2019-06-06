package com.BomberosAmbato.Controller;

import com.BomberosAmbato.EJB.RequisitosFacadeLocal;

import com.BomberosAmbato.EJB.ServicioRequisitosFacadeLocal;
import com.BomberosAmbato.Model.Requisitos;
import com.BomberosAmbato.Model.Servicio;
import com.BomberosAmbato.Model.ServicioRequisitos;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import org.omnifaces.cdi.ViewScoped;

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
    private ServicioRequisitos serviciosRequisitos;

    private List<Requisitos> listaRequisitos;
    @Inject
    private Requisitos requisitos;
    
    
    private List<ServicioRequisitos> listaSR = new ArrayList();

    @PostConstruct
    public void init() {
//        servicio = new Servicio();

//        serviciosRequisitos = new ServicioRequisitos();
        listaRequisitos = requisitosEJB.findAll();
    }

    public void agregarRequisito() {
        
        ServicioRequisitos sreq = new ServicioRequisitos();
        sreq.setReqId(requisitos);
        this.listaSR.add(sreq);
        
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

    public List<ServicioRequisitos> getListaServicioRequistos() {
        return listaSR;
    }

    public void setListaServicioRequistos(List<ServicioRequisitos> listaServicioRequistos) {
        this.listaSR = listaServicioRequistos;
    }

}
