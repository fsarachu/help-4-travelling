package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.OrdenService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class OrdenController {

    public void nueva(Reserva reserva) {
    }

    public ArrayList<Reserva> listar() {
        OrdenService ordenService = ServiceFactory.getOrdenService();

        return ordenService.listar();
    }
}
