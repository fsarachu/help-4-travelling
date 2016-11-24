package uy.edu.cure.servidor.central.dto;

import java.util.Date;
//import javax.persistence.*;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;
//import javax.persistence.Column;
import javax.persistence.Entity;
//import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
//import javax.persistence.OneToMany;
import javax.persistence.Table;

//import org.hibernate.annotations.NamedQueries;
//import org.hibernate.annotations.NamedQuery;

//import com.sun.istack.NotNull;

@Entity
@Table(name = "facturas")
@NamedQueries(value = { @NamedQuery(name = "getFacturaPorID", query = "select f from Factura f where id = :id") })
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Integer id;
    private Date fecha;

    //@OneToOne(mappedBy = "factura", fetch = FetchType.EAGER)
    //private Reserva reserva;
    private EstadoReserva estado;

    public Factura(){
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    /*public Reserva getReserva() {
        return reserva;
    }*/

    /*public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }*/

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}



