package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ReservaController {

    public void nueva(Reserva reserva) {
    }

    public ArrayList<Reserva> listar() {
        ReservaService reservaService = ServiceFactory.getReservaService();

        return reservaService.listar();
    }
}
