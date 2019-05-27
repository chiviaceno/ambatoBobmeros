/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Requisitos.findAll", query = "SELECT r FROM Requisitos r")
    , @NamedQuery(name = "Requisitos.findByReqId", query = "SELECT r FROM Requisitos r WHERE r.reqId = :reqId")
    , @NamedQuery(name = "Requisitos.findByNombre", query = "SELECT r FROM Requisitos r WHERE r.nombre = :nombre")
    , @NamedQuery(name = "Requisitos.findByDescripcion", query = "SELECT r FROM Requisitos r WHERE r.descripcion = :descripcion")
    , @NamedQuery(name = "Requisitos.findByLlenadopor", query = "SELECT r FROM Requisitos r WHERE r.llenadopor = :llenadopor")})
public class Requisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "req_id")
    private Integer reqId;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 100)
    @Column(name = "nombre")
    private String nombre;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 300)
    @Column(name = "descripcion")
    private String descripcion;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 15)
    @Column(name = "llenadopor")
    private String llenadopor;
    @OneToMany(mappedBy = "reqId")
    private List<InspeccionDetalle> inspeccionDetalleList;
    @OneToMany(mappedBy = "reqId")
    private List<ServicioRequisitos> servicioRequisitosList;

    public Requisitos() {
    }

    public Requisitos(Integer reqId) {
        this.reqId = reqId;
    }

    public Requisitos(Integer reqId, String nombre, String descripcion, String llenadopor) {
        this.reqId = reqId;
        this.nombre = nombre;
        this.descripcion = descripcion;
        this.llenadopor = llenadopor;
    }

    public Integer getReqId() {
        return reqId;
    }

    public void setReqId(Integer reqId) {
        this.reqId = reqId;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getLlenadopor() {
        return llenadopor;
    }

    public void setLlenadopor(String llenadopor) {
        this.llenadopor = llenadopor;
    }

    @XmlTransient
    public List<InspeccionDetalle> getInspeccionDetalleList() {
        return inspeccionDetalleList;
    }

    public void setInspeccionDetalleList(List<InspeccionDetalle> inspeccionDetalleList) {
        this.inspeccionDetalleList = inspeccionDetalleList;
    }

    @XmlTransient
    public List<ServicioRequisitos> getServicioRequisitosList() {
        return servicioRequisitosList;
    }

    public void setServicioRequisitosList(List<ServicioRequisitos> servicioRequisitosList) {
        this.servicioRequisitosList = servicioRequisitosList;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (reqId != null ? reqId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Requisitos)) {
            return false;
        }
        Requisitos other = (Requisitos) object;
        if ((this.reqId == null && other.reqId != null) || (this.reqId != null && !this.reqId.equals(other.reqId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.Requisitos[ reqId=" + reqId + " ]";
    }
    
}
