package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Promocion extends Producto {
    private int descuento;
    private ArrayList<Servicio> servicios;

    public Promocion(Integer id, String nombre, String descripcion, double precio, Proveedor proveedor, int descuento, ArrayList<Servicio> servicios) {
        super(id, nombre, descripcion, precio, proveedor);
        this.descuento = descuento;
        this.servicios = servicios;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }
}
