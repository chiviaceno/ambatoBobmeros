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
@Table(name = "solicitud")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Solicitud.findAll", query = "SELECT s FROM Solicitud s")
    , @NamedQuery(name = "Solicitud.findBySolId", query = "SELECT s FROM Solicitud s WHERE s.solId = :solId")
    , @NamedQuery(name = "Solicitud.findByNumeroDeSolicitud", query = "SELECT s FROM Solicitud s WHERE s.numeroDeSolicitud = :numeroDeSolicitud")
    , @NamedQuery(name = "Solicitud.findByNombreComercial", query = "SELECT s FROM Solicitud s WHERE s.nombreComercial = :nombreComercial")
    , @NamedQuery(name = "Solicitud.findByDireccion", query = "SELECT s FROM Solicitud s WHERE s.direccion = :direccion")
    , @NamedQuery(name = "Solicitud.findByFechaCreacion", query = "SELECT s FROM Solicitud s WHERE s.fechaCreacion = :fechaCreacion")
    , @NamedQuery(name = "Solicitud.findByFechaModificacion", query = "SELECT s FROM Solicitud s WHERE s.fechaModificacion = :fechaModificacion")
    , @NamedQuery(name = "Solicitud.findByEstado", query = "SELECT s FROM Solicitud s WHERE s.estado = :estado")
    , @NamedQuery(name = "Solicitud.findByObservacion", query = "SELECT s FROM Solicitud s WHERE s.observacion = :observacion")
    , @NamedQuery(name = "Solicitud.findByEstadoDePago", query = "SELECT s FROM Solicitud s WHERE s.estadoDePago = :estadoDePago")})
public class Solicitud implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sol_id")
    private Integer solId;
    @Basic(optional = false)
    @Size(min = 1, max = 10)
    @Column(name = "numero_de_solicitud")
    private String numeroDeSolicitud;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "nombre_comercial")
    private String nombreComercial;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "direccion")
    private String direccion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1000)
    @Column(name = "observacion")
    private String observacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado_de_pago")
    private String estadoDePago;
    @OneToMany(mappedBy = "solId")
    private List<InspecionCabecera> inspecionCabeceraList;
    @OneToMany(mappedBy = "solId")
    private List<Archivos> archivosList;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private Persona perId;
    @JoinColumn(name = "ser_id", referencedColumnName = "ser_id")
    @ManyToOne
    private Servicio serId;
    @OneToMany(mappedBy = "solId")
    private List<FacturaCabecera> facturaCabeceraList;

    public Solicitud() {
    }

    public Solicitud(Integer solId) {
        this.solId = solId;
    }

    public Solicitud(Integer solId, String numeroDeSolicitud, String nombreComercial, String direccion, Date fechaCreacion, Date fechaModificacion, String estado, String observacion, String estadoDePago) {
        this.solId = solId;
        this.numeroDeSolicitud = numeroDeSolicitud;
        this.nombreComercial = nombreComercial;
        this.direccion = direccion;
        this.fechaCreacion = fechaCreacion;
        this.fechaModificacion = fechaModificacion;
        this.estado = estado;
        this.observacion = observacion;
        this.estadoDePago = estadoDePago;
    }

    public Integer getSolId() {
        return solId;
    }

    public void setSolId(Integer solId) {
        this.solId = solId;
    }

    public String getNumeroDeSolicitud() {
        return numeroDeSolicitud;
    }

    public void setNumeroDeSolicitud(String numeroDeSolicitud) {
        this.numeroDeSolicitud = numeroDeSolicitud;
    }

    public String getNombreComercial() {
        return nombreComercial;
    }

    public void setNombreComercial(String nombreComercial) {
        this.nombreComercial = nombreComercial;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaModificacion() {
        return fechaModificacion;
    }

    public void setFechaModificacion(Date fechaModificacion) {
        this.fechaModificacion = fechaModificacion;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getObservacion() {
        return observacion;
    }

    public void setObservacion(String observacion) {
        this.observacion = observacion;
    }

    public String getEstadoDePago() {
        return estadoDePago;
    }

    public void setEstadoDePago(String estadoDePago) {
        this.estadoDePago = estadoDePago;
    }

    @XmlTransient
    public List<InspecionCabecera> getInspecionCabeceraList() {
        return inspecionCabeceraList;
    }

    public void setInspecionCabeceraList(List<InspecionCabecera> inspecionCabeceraList) {
        this.inspecionCabeceraList = inspecionCabeceraList;
    }

    @XmlTransient
    public List<Archivos> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(List<Archivos> archivosList) {
        this.archivosList = archivosList;
    }

    public Persona getPerId() {
        return perId;
    }

    public void setPerId(Persona perId) {
        this.perId = perId;
    }

    public Servicio getSerId() {
        return serId;
    }

    public void setSerId(Servicio serId) {
        this.serId = serId;
    }

    @XmlTransient
    public List<FacturaCabecera> getFacturaCabeceraList() {
        return facturaCabeceraList;
    }

    public void setFacturaCabeceraList(List<FacturaCabecera> facturaCabeceraList) {
        this.facturaCabeceraList = facturaCabeceraList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (solId != null ? solId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Solicitud)) {
            return false;
        }
        Solicitud other = (Solicitud) object;
        if ((this.solId == null && other.solId != null) || (this.solId != null && !this.solId.equals(other.solId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.Solicitud[ solId=" + solId + " ]";
    }
    
}
