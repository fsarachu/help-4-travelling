package uy.edu.cure.servidor.central.dto;

import java.util.Date;

public class Reserva {
    private Integer id;
    private Carrito carrito;
    private Cliente cliente;
    private Date fechaCreacion;
    private EstadoReserva estado;


    public Reserva() {
    }

    public Reserva(Integer id, Carrito carrito, Cliente cliente, Date fechaCreacion, EstadoReserva estado, Date fechaInicio, Date fechaFin) {
        this.id = id;
        this.carrito = carrito;
        this.cliente = cliente;
        this.fechaCreacion = fechaCreacion;
        this.estado = estado;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public EstadoReserva getEstado() {
        return estado;
    }

    public void setEstado(EstadoReserva estado) {
        this.estado = estado;
    }
}
