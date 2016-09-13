package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;
import java.util.Date;
import java.util.Random;

public class Reserva {
    private Integer id;
    private Date fechaCreacion;
    private double total;
    private EstadoOrden estado;
    private ArrayList<Integer> idReservas;
    private ArrayList<ItemReserva> itemReservas;
    private Cliente cliente;

    public Reserva(Cliente cliente) {
        Random rand = new Random();

        this.id = Math.abs(rand.nextInt()); //TODO: generar los id bien!
        this.fechaCreacion = new Date();
        this.total = 0.0;
        this.estado = EstadoOrden.registrada;
        this.idReservas = new ArrayList<>();
        this.itemReservas = new ArrayList<>();
        this.cliente = cliente;
    }

    public Reserva(Integer id, Date fechaCreacion, double total, EstadoOrden estado, ArrayList<Integer> idReservas, ArrayList<ItemReserva> itemReservas, Cliente cliente) {
        this.id = id;
        this.fechaCreacion = fechaCreacion;
        this.total = total;
        this.estado = estado;
        this.idReservas = idReservas;
        this.itemReservas = itemReservas;
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

    public EstadoOrden getEstado() {
        return estado;
    }

    public void setEstado(EstadoOrden estado) {
        this.estado = estado;
    }

    public ArrayList<Integer> getIdReservas() {
        return idReservas;
    }

    public ArrayList<ItemReserva> getItemReservas() {
        return itemReservas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
