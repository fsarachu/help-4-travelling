package uy.edu.cure.servidor.central.dto;

import com.sun.security.ntlm.Client;

import java.util.ArrayList;
import java.util.Date;

public class Orden {
    private int id;
    private Date fechaCreacion;
    private double total;
    private ArrayList<Reserva> reservas;
    private Cliente cliente;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Date getFechaCreacion() {
        return fechaCreacion;
    }

    public void setFechaCreacion(Date fechaCreacion) {
        this.fechaCreacion = fechaCreacion;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }
}
