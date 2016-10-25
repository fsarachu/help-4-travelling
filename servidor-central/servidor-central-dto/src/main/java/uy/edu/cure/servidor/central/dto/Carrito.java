package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Carrito {
    private Integer id;
    private ArrayList<Integer> idItems;
    private ArrayList<ItemReserva> items;
    private Cliente cliente;
    private double total;

    public Carrito() {
        this.idItems = new ArrayList<>();
        this.items = new ArrayList<>();
        this.total = 0.0;
    }

    public Carrito(Integer id, ArrayList<Integer> idItems, ArrayList<ItemReserva> items, Cliente cliente, double total) {
        this.id = id;
        this.idItems = idItems;
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

    public ArrayList<Integer> getIdItems() {
        return idItems;
    }

    public void setIdItems(ArrayList<Integer> idItems) {
        this.idItems = idItems;
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

    public void addItem(ItemReserva itemReserva) {
        this.idItems.add(itemReserva.getId());
        this.items.add(itemReserva);
        this.setTotal(this.getTotal() + itemReserva.getSubTotal());
    }

    public void removeItem(ItemReserva itemReserva) {
        this.idItems.remove(itemReserva.getId());
        this.items.remove(itemReserva);
    }

}
