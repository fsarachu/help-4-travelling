package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.ItemReserva;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public class ItemReservaBean implements Serializable{
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
