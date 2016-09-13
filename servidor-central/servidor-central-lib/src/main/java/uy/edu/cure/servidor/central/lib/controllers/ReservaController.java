package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ReservaController {

    public void nueva(ItemReserva itemReserva) {

        ReservaService reservaService = ServiceFactory.getReservaService();

        itemReserva.getOrden().getIdReservas().add(itemReserva.getId());

        reservaService.agregar(itemReserva.getId(), itemReserva);

    }

    public ArrayList<ItemReserva> listar() {
        ReservaService reservaService = ServiceFactory.getReservaService();

        return reservaService.listar();
    }

}
