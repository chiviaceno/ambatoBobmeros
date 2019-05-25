/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.Model;

import java.io.Serializable;
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
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennis Orellana
 */
@Entity
@Table(name = "factura_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "FacturaDetalle.findAll", query = "SELECT f FROM FacturaDetalle f"),
    @NamedQuery(name = "FacturaDetalle.findByFadId", query = "SELECT f FROM FacturaDetalle f WHERE f.fadId = :fadId"),
    @NamedQuery(name = "FacturaDetalle.findByDescripcion", query = "SELECT f FROM FacturaDetalle f WHERE f.descripcion = :descripcion"),
    @NamedQuery(name = "FacturaDetalle.findByCantidad", query = "SELECT f FROM FacturaDetalle f WHERE f.cantidad = :cantidad"),
    @NamedQuery(name = "FacturaDetalle.findByPrecio", query = "SELECT f FROM FacturaDetalle f WHERE f.precio = :precio"),
    @NamedQuery(name = "FacturaDetalle.findByTotal", query = "SELECT f FROM FacturaDetalle f WHERE f.total = :total")})
public class FacturaDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "fad_id")
    private Integer fadId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Column(name = "precio")
    private double precio;
    @Basic(optional = false)
    @NotNull
    @Column(name = "total")
    private double total;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id")
    @ManyToOne
    private FacturaCabecera facId;
    @JoinColumn(name = "ser_id", referencedColumnName = "ser_id")
    @ManyToOne
    private Servicio serId;

    public FacturaDetalle() {
    }

    public FacturaDetalle(Integer fadId) {
        this.fadId = fadId;
    }

    public FacturaDetalle(Integer fadId, String descripcion, int cantidad, double precio, double total) {
        this.fadId = fadId;
        this.descripcion = descripcion;
        this.cantidad = cantidad;
        this.precio = precio;
        this.total = total;
    }

    public Integer getFadId() {
        return fadId;
    }

    public void setFadId(Integer fadId) {
        this.fadId = fadId;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public FacturaCabecera getFacId() {
        return facId;
    }

    public void setFacId(FacturaCabecera facId) {
        this.facId = facId;
    }

    public Servicio getSerId() {
        return serId;
    }

    public void setSerId(Servicio serId) {
        this.serId = serId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (fadId != null ? fadId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FacturaDetalle)) {
            return false;
        }
        FacturaDetalle other = (FacturaDetalle) object;
        if ((this.fadId == null && other.fadId != null) || (this.fadId != null && !this.fadId.equals(other.fadId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.FacturaDetalle[ fadId=" + fadId + " ]";
    }
    
}
