package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.ItemReserva;

public class ItemReservaBean {
    private ItemReserva itemReserva;

    public ItemReservaBean() {
    }

    public ItemReserva getItemReserva() {
        if (itemReserva == null) {
            itemReserva = new ItemReserva();
        }
        return itemReserva;
    }

    public void setItemReserva(ItemReserva itemReserva) {
        this.itemReserva = itemReserva;
    }
}
