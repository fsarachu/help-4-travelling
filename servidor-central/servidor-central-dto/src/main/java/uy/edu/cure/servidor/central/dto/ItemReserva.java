package uy.edu.cure.servidor.central.dto;

import java.util.Date;

public class ItemReserva {
    private Integer id;
    private Date fechaInicio;
    private Date fechaFin;
    private Producto producto;
    private int cantidad;
    private double precio;
    private Reserva reserva;

    public ItemReserva(Integer id, Date fechaInicio, Date fechaFin, Producto producto, int cantidad, double precio, Reserva reserva) {
        this.id = id;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.producto = producto;
        this.cantidad = cantidad;
        this.precio = precio;
        this.reserva = reserva;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getFechaInicio() {
        return fechaInicio;
    }

    public void setFechaInicio(Date fechaInicio) {
        this.fechaInicio = fechaInicio;
    }

    public Date getFechaFin() {
        return fechaFin;
    }

    public void setFechaFin(Date fechaFin) {
        this.fechaFin = fechaFin;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
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

    public Reserva getReserva() {
        return reserva;
    }

    public void setReserva(Reserva reserva) {
        this.reserva = reserva;
    }
}
