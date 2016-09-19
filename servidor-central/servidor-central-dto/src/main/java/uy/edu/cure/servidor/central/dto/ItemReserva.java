package uy.edu.cure.servidor.central.dto;

import java.util.Date;

public class ItemReserva {
    private Integer id;
    private Carrito carrito;
    private Producto producto;
    private double subTotal;
    private Date fechaInicio;
    private Date fechaFin;
    private int cantidad;

    public ItemReserva() {
    }

    public ItemReserva(Integer id, Carrito carrito, Producto producto, double subTotal, Date fechaInicio, Date fechaFin, int cantidad) {
        this.id = id;
        this.carrito = carrito;
        this.producto = producto;
        this.subTotal = subTotal;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.cantidad = cantidad;
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

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }

    public double getSubTotal() {
        return subTotal;
    }

    public void setSubTotal(double subTotal) {
        this.subTotal = subTotal;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizarSubTotal() {
        this.subTotal = this.producto.getPrecio() * this.cantidad;
    }

    @Override
    public String toString() {
        return ""+ id + " " + producto  ;
    }
}
