package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.ItemReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ItemReservaController {

    public void nueva(ItemReserva itemReserva) {

        ItemReservaService itemReservaService = ServiceFactory.getItemReservaService();

        itemReserva.getReserva().getIdReservas().add(itemReserva.getId());

        itemReservaService.agregar(itemReserva.getId(), itemReserva);

    }

    public ArrayList<ItemReserva> listar() {
        ItemReservaService itemReservaService = ServiceFactory.getItemReservaService();

        return itemReservaService.listar();
    }

}
