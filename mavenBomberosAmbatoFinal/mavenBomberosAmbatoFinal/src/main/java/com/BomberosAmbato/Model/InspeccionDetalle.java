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
@Table(name = "inspeccion_detalle")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "InspeccionDetalle.findAll", query = "SELECT i FROM InspeccionDetalle i"),
    @NamedQuery(name = "InspeccionDetalle.findByIndId", query = "SELECT i FROM InspeccionDetalle i WHERE i.indId = :indId"),
    @NamedQuery(name = "InspeccionDetalle.findByEstado", query = "SELECT i FROM InspeccionDetalle i WHERE i.estado = :estado"),
    @NamedQuery(name = "InspeccionDetalle.findByTipo", query = "SELECT i FROM InspeccionDetalle i WHERE i.tipo = :tipo"),
    @NamedQuery(name = "InspeccionDetalle.findByCantidad", query = "SELECT i FROM InspeccionDetalle i WHERE i.cantidad = :cantidad"),
    @NamedQuery(name = "InspeccionDetalle.findByCapacidad", query = "SELECT i FROM InspeccionDetalle i WHERE i.capacidad = :capacidad"),
    @NamedQuery(name = "InspeccionDetalle.findByUbicacion", query = "SELECT i FROM InspeccionDetalle i WHERE i.ubicacion = :ubicacion"),
    @NamedQuery(name = "InspeccionDetalle.findByTiene", query = "SELECT i FROM InspeccionDetalle i WHERE i.tiene = :tiene")})
public class InspeccionDetalle implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "ind_id")
    private Integer indId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "estado")
    private String estado;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "tipo")
    private String tipo;
    @Basic(optional = false)
    @NotNull
    @Column(name = "cantidad")
    private int cantidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 50)
    @Column(name = "capacidad")
    private String capacidad;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "ubicacion")
    private String ubicacion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 10)
    @Column(name = "tiene")
    private String tiene;
    @JoinColumn(name = "icn_id", referencedColumnName = "icn_id")
    @ManyToOne
    private InspecionCabecera icnId;
    @JoinColumn(name = "req_id", referencedColumnName = "req_id")
    @ManyToOne
    private Requisitos reqId;

    public InspeccionDetalle() {
    }

    public InspeccionDetalle(Integer indId) {
        this.indId = indId;
    }

    public InspeccionDetalle(Integer indId, String estado, String tipo, int cantidad, String capacidad, String ubicacion, String tiene) {
        this.indId = indId;
        this.estado = estado;
        this.tipo = tipo;
        this.cantidad = cantidad;
        this.capacidad = capacidad;
        this.ubicacion = ubicacion;
        this.tiene = tiene;
    }

    public Integer getIndId() {
        return indId;
    }

    public void setIndId(Integer indId) {
        this.indId = indId;
    }

    public String getEstado() {
        return estado;
    }

    public void setEstado(String estado) {
        this.estado = estado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public String getTiene() {
        return tiene;
    }

    public void setTiene(String tiene) {
        this.tiene = tiene;
    }

    public InspecionCabecera getIcnId() {
        return icnId;
    }

    public void setIcnId(InspecionCabecera icnId) {
        this.icnId = icnId;
    }

    public Requisitos getReqId() {
        return reqId;
    }

    public void setReqId(Requisitos reqId) {
        this.reqId = reqId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (indId != null ? indId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof InspeccionDetalle)) {
            return false;
        }
        InspeccionDetalle other = (InspeccionDetalle) object;
        if ((this.indId == null && other.indId != null) || (this.indId != null && !this.indId.equals(other.indId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.InspeccionDetalle[ indId=" + indId + " ]";
    }
    
}
