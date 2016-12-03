package uy.edu.cure.servidor.central.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.Date;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class ItemReserva {
    private Integer id;
    private Carrito carrito;
    private Producto producto;
    private double subTotal;
    private Date fechaInicio;
    private Date fechaFin;
    private double cantidad;
    @JsonCreator
    public ItemReserva() {
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

    public void setSubTotal(double subTotal) { this.subTotal = subTotal;
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

    public double getCantidad() {
        return cantidad;
    }

    public void setCantidad(double cantidad) {
        this.cantidad = cantidad;
    }

    public void actualizarSubTotal() {
        this.subTotal = this.producto.getPrecio() * this.cantidad;
    }

    public String datosReserva() {
        return ""+ id + " " + producto  ;
    }
/*
    @Override
    public String toString(){
        return datosReserva() + producto.getId();
    }
    */
}
