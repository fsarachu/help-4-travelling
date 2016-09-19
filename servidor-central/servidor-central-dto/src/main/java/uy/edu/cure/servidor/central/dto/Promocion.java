package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Promocion extends Producto {
    private int descuento;
    private ArrayList<Integer> idServicios;
    private ArrayList<Servicio> servicios;

    public Promocion() {
        this.setTipo(TipoProducto.promocion);
        this.idServicios = new ArrayList<>();
        this.servicios = new ArrayList<>();
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

    public void setIdServicios(ArrayList<Integer> idServicios) {
        this.idServicios = idServicios;
    }

    public ArrayList<Servicio> getServicios() {
        return servicios;
    }

    public void setServicios(ArrayList<Servicio> servicios) {
        this.servicios = servicios;
    }

    @Override
    public String toString() {
        return "Descuento: " + descuento +
                ", servicios: " + servicios +
                '}';
    }
}

