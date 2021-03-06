package uy.edu.cure.servidor.central.dto;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Promocion extends Producto {
    private int descuento;
    private ArrayList<Integer> idServicios;
    private ArrayList<Servicio> servicios;
    @JsonCreator
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

    public void calcularPrecioPromocion(){
        if(servicios!=null){
            double suma = 0;
            for(Servicio servicio : servicios){
                suma = suma + servicio.getPrecio();
            }

            suma = suma - suma * (this.getDescuento() / 100);
            this.setPrecio(suma);
        }
    }

    @Override
    public String toString() {

        return super.getNombre();
    }

}

