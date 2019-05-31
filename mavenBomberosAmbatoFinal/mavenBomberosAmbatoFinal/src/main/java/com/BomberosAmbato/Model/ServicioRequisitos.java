/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.BomberosAmbato.Model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "servicio_requisitos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ServicioRequisitos.findAll", query = "SELECT s FROM ServicioRequisitos s")
    , @NamedQuery(name = "ServicioRequisitos.findBySreId", query = "SELECT s FROM ServicioRequisitos s WHERE s.sreId = :sreId")})
public class ServicioRequisitos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "sre_id")
    private Integer sreId;
    
    @OneToMany(mappedBy = "sreId")
    private List<Archivos> archivosList;
    
    @JoinColumn(name = "req_id", referencedColumnName = "req_id")
    @ManyToOne
    private Requisitos reqId;
    
    @JoinColumn(name = "ser_id", referencedColumnName = "ser_id", nullable = false)
    @ManyToOne(cascade = CascadeType.ALL, optional = false, fetch = FetchType.EAGER )
    private Servicio serId;

    public ServicioRequisitos() {
    }

    public ServicioRequisitos(Integer sreId) {
        this.sreId = sreId;
    }

    public Integer getSreId() {
        return sreId;
    }

    public void setSreId(Integer sreId) {
        this.sreId = sreId;
    }

    @XmlTransient
    public List<Archivos> getArchivosList() {
        return archivosList;
    }

    public void setArchivosList(List<Archivos> archivosList) {
        this.archivosList = archivosList;
    }

    public Requisitos getReqId() {
        return reqId;
    }

    public void setReqId(Requisitos reqId) {
        this.reqId = reqId;
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
        hash += (sreId != null ? sreId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ServicioRequisitos)) {
            return false;
        }
        ServicioRequisitos other = (ServicioRequisitos) object;
        if ((this.sreId == null && other.sreId != null) || (this.sreId != null && !this.sreId.equals(other.sreId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.ServicioRequisitos[ sreId=" + sreId + " ]";
    }
    
}
