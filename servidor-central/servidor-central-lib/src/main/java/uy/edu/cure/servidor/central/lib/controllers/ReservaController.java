package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ReservaController {

    public void nueva(Reserva reserva) {

        ReservaService reservaService = ServiceFactory.getReservaService();

//        reserva.getOrden().getIdReservas().add(reserva.getId());

        reservaService.agregar(reserva.getId(), reserva);

    }

    public void eliminar(int id) {
        ReservaService reservaService = ServiceFactory.getReservaService();

        reservaService.eliminar(id);
    }

    Reserva obtener(Integer id) {
        ReservaService reservaService = ServiceFactory.getReservaService();

        return reservaService.obtener(id);
    }

    public void modificar(Integer id, Reserva ciudad1) {
        ReservaService reservaService = ServiceFactory.getReservaService();

        reservaService.modificar(id, ciudad1);
    }

    public ArrayList<Reserva> listar() {
        ReservaService reservaService = ServiceFactory.getReservaService();

        return reservaService.listar();
    }

}
