package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class ReservaRestController {

    ReservaController reservaController = new ReservaController();

    @GET
    @Produces
    public void nueva(Cliente cliente) {
        reservaController.nueva(cliente);
    }

    @GET
    @Produces
    public Reserva obtener(Integer idReserva) {
        return reservaController.obtener(idReserva);
    }

    @GET
    @Produces
    public void modificar(Reserva reserva) {
        reservaController.modificar(reserva);
    }

    @GET
    @Produces
    public void eliminar(Integer idReserva) {
        reservaController.eliminar(idReserva);
    }

    @GET
    @Produces
    public ArrayList<Reserva> listar() {
        return reservaController.listar();
    }

    @GET
    @Produces
    public void actualizarEstado(Integer idReserva, EstadoReserva nuevoEstado) {
        reservaController.actualizarEstado(idReserva, nuevoEstado);
    }

    @GET
    @Produces
    public ArrayList<Reserva> listarReservasCliente(Cliente cliente) {
        return reservaController.listarReservasCliente(cliente);
    }
}
