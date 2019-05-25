/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.Model;

import java.io.Serializable;
import java.util.Date;
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
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennis Orellana
 */
@Entity
@Table(name = "permiso_funcionamiento")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "PermisoFuncionamiento.findAll", query = "SELECT p FROM PermisoFuncionamiento p"),
    @NamedQuery(name = "PermisoFuncionamiento.findByPefId", query = "SELECT p FROM PermisoFuncionamiento p WHERE p.pefId = :pefId"),
    @NamedQuery(name = "PermisoFuncionamiento.findByFechaCreacion", query = "SELECT p FROM PermisoFuncionamiento p WHERE p.fechaCreacion = :fechaCreacion"),
    @NamedQuery(name = "PermisoFuncionamiento.findByFechaVencimiento", query = "SELECT p FROM PermisoFuncionamiento p WHERE p.fechaVencimiento = :fechaVencimiento")})
public class PermisoFuncionamiento implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "pef_id")
    private Integer pefId;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;
    @Basic(optional = false)
    @NotNull
    @Column(name = "fecha_vencimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaVencimiento;
    @JoinColumn(name = "fac_id", referencedColumnName = "fac_id")
    @ManyToOne
    private FacturaCabecera facId;

    public PermisoFuncionamiento() {
    }

    public PermisoFuncionamiento(Integer pefId) {
        this.pefId = pefId;
    }

    public PermisoFuncionamiento(Integer pefId, Date fechaCreacion, Date fechaVencimiento) {
        this.pefId = pefId;
        this.fechaCreacion = fechaCreacion;
        this.fechaVencimiento = fechaVencimiento;
    }

    public Integer getPefId() {
        return pefId;
    }

    public void setPefId(Integer pefId) {
        this.pefId = pefId;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public Date getFechaVencimiento() {
        return fechaVencimiento;
    }

    public void setFechaVencimiento(Date fechaVencimiento) {
        this.fechaVencimiento = fechaVencimiento;
    }

    public FacturaCabecera getFacId() {
        return facId;
    }

    public void setFacId(FacturaCabecera facId) {
        this.facId = facId;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (pefId != null ? pefId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof PermisoFuncionamiento)) {
            return false;
        }
        PermisoFuncionamiento other = (PermisoFuncionamiento) object;
        if ((this.pefId == null && other.pefId != null) || (this.pefId != null && !this.pefId.equals(other.pefId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.PermisoFuncionamiento[ pefId=" + pefId + " ]";
    }
    
}
