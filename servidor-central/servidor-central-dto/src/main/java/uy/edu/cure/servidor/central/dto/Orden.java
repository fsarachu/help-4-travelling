package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;
import java.util.Date;

public class Orden {
    private Integer id;
    private Date fechaCreacion;
    private double total;
    private ArrayList<Integer> idReservas;
    private ArrayList<Reserva> reservas;
    private Cliente cliente;

    public Orden(Integer id, Date fechaCreacion, double total, ArrayList<Integer> idReservas, ArrayList<Reserva> reservas, Cliente cliente) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
        this.idReservas = idReservas;
        this.reservas = reservas;
        this.cliente = cliente;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
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

    public ArrayList<Integer> getIdReservas() {
        return idReservas;
    }

    public ArrayList<Reserva> getReservas() {
        return reservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
