package uy.edu.cure.servidor.central.dto;

/**
 * Created by victor on 26/11/16.
 */
public class Item_Carrito {
    private ItemReserva itemReserva;
    private Carrito carrito;

    public Item_Carrito() {
    }

    public ItemReserva getItemReserva() {
        return itemReserva;
    }

    public void setItemReserva(ItemReserva itemReserva) {
        this.itemReserva = itemReserva;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }
}
