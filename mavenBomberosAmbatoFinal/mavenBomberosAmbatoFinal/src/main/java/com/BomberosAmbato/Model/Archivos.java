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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Dennis
 */
@Entity
@Table(name = "archivos")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Archivos.findAll", query = "SELECT a FROM Archivos a")
    , @NamedQuery(name = "Archivos.findByArcId", query = "SELECT a FROM Archivos a WHERE a.arcId = :arcId")
    , @NamedQuery(name = "Archivos.findByArchivo", query = "SELECT a FROM Archivos a WHERE a.archivo = :archivo")})
public class Archivos implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "arc_id")
    private Integer arcId;
    @Column(name = "archivo")
    private Short archivo;
    @JoinColumn(name = "sre_id", referencedColumnName = "sre_id")
    @ManyToOne
    private ServicioRequisitos sreId;
    @JoinColumn(name = "sol_id", referencedColumnName = "sol_id")
    @ManyToOne
    private Solicitud solId;

    public Archivos() {
    }

    public Archivos(Integer arcId) {
        this.arcId = arcId;
    }

    public Integer getArcId() {
        return arcId;
    }

    public void setArcId(Integer arcId) {
        this.arcId = arcId;
    }

    public Short getArchivo() {
        return archivo;
    }

    public void setArchivo(Short archivo) {
        this.archivo = archivo;
    }

    public ServicioRequisitos getSreId() {
        return sreId;
    }

    public void setSreId(ServicioRequisitos sreId) {
        this.sreId = sreId;
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
        hash += (arcId != null ? arcId.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Archivos)) {
            return false;
        }
        Archivos other = (Archivos) object;
        if ((this.arcId == null && other.arcId != null) || (this.arcId != null && !this.arcId.equals(other.arcId))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.BomberosAmbato.Model.Archivos[ arcId=" + arcId + " ]";
    }
    
}
