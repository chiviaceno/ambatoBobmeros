/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.Model;

import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "inspecion_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InspecionCabecera.findAll", query = "SELECT i FROM InspecionCabecera i")
    , @NamedQuery(name = "InspecionCabecera.findByIcnId", query = "SELECT i FROM InspecionCabecera i WHERE i.icnId = :icnId")
    , @NamedQuery(name = "InspecionCabecera.findByDireccion", query = "SELECT i FROM InspecionCabecera i WHERE i.direccion = :direccion")
    , @NamedQuery(name = "InspecionCabecera.findByLatitud", query = "SELECT i FROM InspecionCabecera i WHERE i.latitud = :latitud")
    , @NamedQuery(name = "InspecionCabecera.findByLongitud", query = "SELECT i FROM InspecionCabecera i WHERE i.longitud = :longitud")
    , @NamedQuery(name = "InspecionCabecera.findByFecha", query = "SELECT i FROM InspecionCabecera i WHERE i.fecha = :fecha")
    , @NamedQuery(name = "InspecionCabecera.findByRiesgosDeIncendio", query = "SELECT i FROM InspecionCabecera i WHERE i.riesgosDeIncendio = :riesgosDeIncendio")
    , @NamedQuery(name = "InspecionCabecera.findByRecomendaciones", query = "SELECT i FROM InspecionCabecera i WHERE i.recomendaciones = :recomendaciones")
    , @NamedQuery(name = "InspecionCabecera.findByObservaciones", query = "SELECT i FROM InspecionCabecera i WHERE i.observaciones = :observaciones")
    , @NamedQuery(name = "InspecionCabecera.findByEstado", query = "SELECT i FROM InspecionCabecera i WHERE i.estado = :estado")
    , @NamedQuery(name = "InspecionCabecera.findByPlazo", query = "SELECT i FROM InspecionCabecera i WHERE i.plazo = :plazo")
    , @NamedQuery(name = "InspecionCabecera.findByNumeroInspeccion", query = "SELECT i FROM InspecionCabecera i WHERE i.numeroInspeccion = :numeroInspeccion")})
public class InspecionCabecera implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "icn_id")
    private Integer icnId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "latitud")
    private String latitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "longitud")
    private String longitud;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "riesgos_de_incendio")
    private String riesgosDeIncendio;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "recomendaciones")
    private String recomendaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "observaciones")
    private String observaciones;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "plazo")
    private String plazo;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "numero_inspeccion")
    private String numeroInspeccion;
    @OneToMany(mappedBy = "icnId")
    private List<InspeccionDetalle> inspeccionDetalleList;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private Persona perId;
    @JoinColumn(name = "sol_id", referencedColumnName = "sol_id")
    @ManyToOne
    private Solicitud solId;

    public InspecionCabecera() {
    }

    public InspecionCabecera(Integer icnId) {
        this.icnId = icnId;
    }

    public InspecionCabecera(Integer icnId, String direccion, String latitud, String longitud, Date fecha, String riesgosDeIncendio, String recomendaciones, String observaciones, String estado, String plazo, String numeroInspeccion) {
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
        this.numeroInspeccion = numeroInspeccion;
    }

    public Integer getIcnId() {
        return icnId;
    }

    public void setIcnId(Integer icnId) {
        this.icnId = icnId;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public String getLatitud() {
        return latitud;
    }

    public void setLatitud(String latitud) {
        this.latitud = latitud;
    }

    public String getLongitud() {
        return longitud;
    }

    public void setLongitud(String longitud) {
        this.longitud = longitud;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getRiesgosDeIncendio() {
        return riesgosDeIncendio;
    }

    public void setRiesgosDeIncendio(String riesgosDeIncendio) {
        this.riesgosDeIncendio = riesgosDeIncendio;
    }

    public String getRecomendaciones() {
        return recomendaciones;
    }

    public void setRecomendaciones(String recomendaciones) {
        this.recomendaciones = recomendaciones;
    }

    public String getObservaciones() {
        return observaciones;
    }

    public void setObservaciones(String observaciones) {
        this.observaciones = observaciones;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getPlazo() {
        return plazo;
    }

    public void setPlazo(String plazo) {
        this.plazo = plazo;
    }

    public String getNumeroInspeccion() {
        return numeroInspeccion;
    }

    public void setNumeroInspeccion(String numeroInspeccion) {
        this.numeroInspeccion = numeroInspeccion;
    }

    @XmlTransient
    public List<InspeccionDetalle> getInspeccionDetalleList() {
        return inspeccionDetalleList;
    }

    public void setInspeccionDetalleList(List<InspeccionDetalle> inspeccionDetalleList) {
        this.inspeccionDetalleList = inspeccionDetalleList;
    }

    public Persona getPerId() {
        return perId;
    }

    public void setPerId(Persona perId) {
        this.perId = perId;
    }

    public Solicitud getSolId() {
        return solId;
    }

    public void setSolId(Solicitud solId) {
        this.solId = solId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (icnId != null ? icnId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InspecionCabecera)) {
            return false;
        }
        InspecionCabecera other = (InspecionCabecera) object;
        if ((this.icnId == null && other.icnId != null) || (this.icnId != null && !this.icnId.equals(other.icnId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.InspecionCabecera[ icnId=" + icnId + " ]";
    }
    
}
