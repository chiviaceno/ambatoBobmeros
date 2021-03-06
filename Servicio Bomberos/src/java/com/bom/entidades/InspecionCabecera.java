package com.bom.entidades;
// Generated 17-may-2019 17:43:44 by Hibernate Tools 4.3.1


import java.util.Date;
import java.util.HashSet;
import java.util.Set;

/**
 * InspecionCabecera generated by hbm2java
 */
public class InspecionCabecera  implements java.io.Serializable {


     private int icnId;
     private Persona persona;
     private Solicitud solicitud;
     private String direccion;
     private String latitud;
     private String longitud;
     private Date fecha;
     private String riesgosDeIncendio;
     private String recomendaciones;
     private String observaciones;
     private String estado;
     private String plazo;
     private String numeroNotificacion;
     private Set<InspeccionDetalle> inspeccionDetalles = new HashSet<InspeccionDetalle>(0);

    public InspecionCabecera() {
    }

	
    public InspecionCabecera(int icnId, String direccion, String latitud, String longitud, Date fecha, String riesgosDeIncendio, String recomendaciones, String observaciones, String estado, String plazo, String numeroNotificacion) {
        this.icnId = icnId;
        this.direccion = direccion;
        this.latitud = latitud;
        this.longitud = longitud;
        this.fecha = fecha;
        this.riesgosDeIncendio = riesgosDeIncendio;
        this.recomendaciones = recomendaciones;
        this.observaciones = observaciones;
        this.estado = estado;
        this.plazo = plazo;
        this.numeroNotificacion = numeroNotificacion;
    }
    public InspecionCabecera(int icnId, Persona persona, Solicitud solicitud, String direccion, String latitud, String longitud, Date fecha, String riesgosDeIncendio, String recomendaciones, String observaciones, String estado, String plazo, String numeroNotificacion, Set<InspeccionDetalle> inspeccionDetalles) {
       this.icnId = icnId;
       this.persona = persona;
       this.solicitud = solicitud;
       this.direccion = direccion;
       this.latitud = latitud;
       this.longitud = longitud;
       this.fecha = fecha;
       this.riesgosDeIncendio = riesgosDeIncendio;
       this.recomendaciones = recomendaciones;
       this.observaciones = observaciones;
       this.estado = estado;
       this.plazo = plazo;
       this.numeroNotificacion = numeroNotificacion;
       this.inspeccionDetalles = inspeccionDetalles;
    }
   
    public int getIcnId() {
        return this.icnId;
    }
    
    public void setIcnId(int icnId) {
        this.icnId = icnId;
    }
    public Persona getPersona() {
        return this.persona;
    }
    
    public void setPersona(Persona persona) {
        this.persona = persona;
    }
    public Solicitud getSolicitud() {
        return this.solicitud;
    }
    
    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    public String getDireccion() {
        return this.direccion;
    }
    
    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
    public String getLatitud() {
        return this.latitud;
    }
    
    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }
    public String getLongitud() {
        return this.longitud;
    }
    
    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }
    public Date getFecha() {
        return this.fecha;
    }
    
    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }
    public String getRiesgosDeIncendio() {
        return this.riesgosDeIncendio;
    }
    
    public void setRiesgosDeIncendio(String riesgosDeIncendio) {
        this.riesgosDeIncendio = riesgosDeIncendio;
    }
    public String getRecomendaciones() {
        return this.recomendaciones;
    }
    
    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }
    public String getObservaciones() {
        return this.observaciones;
    }
    
    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }
    public String getEstado() {
        return this.estado;
    }
    
    public void setEstado(String estado) {
        this.estado = estado;
    }
    public String getPlazo() {
        return this.plazo;
    }
    
    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }
    public String getNumeroNotificacion() {
        return this.numeroNotificacion;
    }
    
    public void setNumeroNotificacion(String numeroNotificacion) {
        this.numeroNotificacion = numeroNotificacion;
    }
    public Set<InspeccionDetalle> getInspeccionDetalles() {
        return this.inspeccionDetalles;
    }
    
    public void setInspeccionDetalles(Set<InspeccionDetalle> inspeccionDetalles) {
        this.inspeccionDetalles = inspeccionDetalles;
    }




}


