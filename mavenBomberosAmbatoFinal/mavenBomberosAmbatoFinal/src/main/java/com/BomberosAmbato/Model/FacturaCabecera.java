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
 * @author Dennis Orellana
 */
@Entity
@Table(name = "factura_cabecera")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaCabecera.findAll", query = "SELECT f FROM FacturaCabecera f"),
    @NamedQuery(name = "FacturaCabecera.findByFacId", query = "SELECT f FROM FacturaCabecera f WHERE f.facId = :facId"),
    @NamedQuery(name = "FacturaCabecera.findByFecha", query = "SELECT f FROM FacturaCabecera f WHERE f.fecha = :fecha"),
    @NamedQuery(name = "FacturaCabecera.findByTipoDocumento", query = "SELECT f FROM FacturaCabecera f WHERE f.tipoDocumento = :tipoDocumento"),
    @NamedQuery(name = "FacturaCabecera.findByTipoCuenta", query = "SELECT f FROM FacturaCabecera f WHERE f.tipoCuenta = :tipoCuenta"),
    @NamedQuery(name = "FacturaCabecera.findByTotal", query = "SELECT f FROM FacturaCabecera f WHERE f.total = :total")})
public class FacturaCabecera implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fac_id")
    private Integer facId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 25)
    @Column(name = "tipo_documento")
    private String tipoDocumento;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo_cuenta")
    private String tipoCuenta;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @OneToMany(mappedBy = "facId")
    private List<FacturaDetalle> facturaDetalleList;
    @JoinColumn(name = "per_id", referencedColumnName = "per_id")
    @ManyToOne
    private Persona perId;
    @JoinColumn(name = "sol_id", referencedColumnName = "sol_id")
    @ManyToOne
    private Solicitud solId;
    @OneToMany(mappedBy = "facId")
    private List<PermisoFuncionamiento> permisoFuncionamientoList;

    public FacturaCabecera() {
    }

    public FacturaCabecera(Integer facId) {
        this.facId = facId;
    }

    public FacturaCabecera(Integer facId, Date fecha, String tipoDocumento, String tipoCuenta, double total) {
        this.facId = facId;
        this.fecha = fecha;
        this.tipoDocumento = tipoDocumento;
        this.tipoCuenta = tipoCuenta;
        this.total = total;
    }

    public Integer getFacId() {
        return facId;
    }

    public void setFacId(Integer facId) {
        this.facId = facId;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public String getTipoDocumento() {
        return tipoDocumento;
    }

    public void setTipoDocumento(String tipoDocumento) {
        this.tipoDocumento = tipoDocumento;
    }

    public String getTipoCuenta() {
        return tipoCuenta;
    }

    public void setTipoCuenta(String tipoCuenta) {
        this.tipoCuenta = tipoCuenta;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    @XmlTransient
    public List<FacturaDetalle> getFacturaDetalleList() {
        return facturaDetalleList;
    }

    public void setFacturaDetalleList(List<FacturaDetalle> facturaDetalleList) {
        this.facturaDetalleList = facturaDetalleList;
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

    @XmlTransient
    public List<PermisoFuncionamiento> getPermisoFuncionamientoList() {
        return permisoFuncionamientoList;
    }

    public void setPermisoFuncionamientoList(List<PermisoFuncionamiento> permisoFuncionamientoList) {
        this.permisoFuncionamientoList = permisoFuncionamientoList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (facId != null ? facId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaCabecera)) {
            return false;
        }
        FacturaCabecera other = (FacturaCabecera) object;
        if ((this.facId == null && other.facId != null) || (this.facId != null && !this.facId.equals(other.facId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.FacturaCabecera[ facId=" + facId + " ]";
    }
    
}
