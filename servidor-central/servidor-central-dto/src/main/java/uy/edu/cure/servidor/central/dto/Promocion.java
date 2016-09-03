package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Promocion extends Producto {
    private int descuento;
    private ArrayList<Integer> idServicios;
    private ArrayList<Servicio> servicios;

    public Promocion(Integer id, String nombre, String descripcion, double precio, Proveedor proveedor, int descuento, ArrayList<Integer> idServicios, ArrayList<Servicio> servicios) {
        super(id, nombre, descripcion, precio, proveedor);
        this.descuento = descuento;
        this.idServicios = idServicios;
        this.servicios = servicios;
    }

    public int getDescuento() {
        return descuento;
    }

    public void setDescuento(int descuento) {
        this.descuento = descuento;
    }

    public ArrayList<Integer> getIdServicios() {
        return idServicios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

}

