package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Carrito {
    private Integer id;
    private ArrayList<ItemReserva> items;
    private Cliente cliente;
    private double total;

    public Carrito() {
    }

    public Carrito(Integer id, ArrayList<ItemReserva> items, Cliente cliente, double total) {
        this.id = id;
        this.items = items;
        this.cliente = cliente;
        this.total = total;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public ArrayList<ItemReserva> getItems() {
        return items;
    }

    public void setItems(ArrayList<ItemReserva> items) {
        this.items = items;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public double getTotal() {
        return total;
    }

    public void setTotal(double total) {
        this.total = total;
    }

    public void actualizarTotal() {
        double newTotal = 0.0;

        for (ItemReserva item : this.items) {
            newTotal += item.getPrecio();
        }

        this.total = newTotal;
    }
}
