/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package cl.ufro.lp2.proyecto.demo.modelo;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 *
 * @author Antonia
 */
@Entity
@Table(name = "ficha")
@NamedQueries({
    @NamedQuery(name = "Ficha.findAll", query = "SELECT f FROM Ficha f")})
public class Ficha implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idFicha")
    private Integer idFicha;
    @Column(name = "fecha")
    @Temporal(TemporalType.DATE)
    private Date fecha;
    @Column(name = "fecha_proxControl")
    @Temporal(TemporalType.DATE)
    private Date fechaproxControl;
    @JoinColumn(name = "idCliente", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idCliente;
    @JoinColumn(name = "idUsuario", referencedColumnName = "id_usuario")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Usuario idUsuario;

    public Ficha() {
    }

    public Ficha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Integer getIdFicha() {
        return idFicha;
    }

    public void setIdFicha(Integer idFicha) {
        this.idFicha = idFicha;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public Date getFechaproxControl() {
        return fechaproxControl;
    }

    public void setFechaproxControl(Date fechaproxControl) {
        this.fechaproxControl = fechaproxControl;
    }

    public Usuario getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(Usuario idCliente) {
        this.idCliente = idCliente;
    }

    public Usuario getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Usuario idUsuario) {
        this.idUsuario = idUsuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idFicha != null ? idFicha.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Ficha)) {
            return false;
        }
        Ficha other = (Ficha) object;
        if ((this.idFicha == null && other.idFicha != null) || (this.idFicha != null && !this.idFicha.equals(other.idFicha))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "cl.ufro.lp2.proyecto.demo.modelo.Ficha[ idFicha=" + idFicha + " ]";
    }
    
}
