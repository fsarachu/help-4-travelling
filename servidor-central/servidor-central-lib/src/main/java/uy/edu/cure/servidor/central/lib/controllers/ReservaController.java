package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class ReservaController {

    public void alta(Reserva reserva){

        ReservaService reservaService = ServiceFactory.getReservaService();

        reservaService.agregar(reserva.getId(), reserva);

    }

}
