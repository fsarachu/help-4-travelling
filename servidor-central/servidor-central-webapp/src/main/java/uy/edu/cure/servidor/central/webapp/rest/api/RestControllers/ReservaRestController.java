package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaReservas;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
@Path("/reserva")
public class ReservaRestController {

    ReservaController reservaController = new ReservaController();


    @PUT
    @Produces("text/plain")
    @Path("nueva")
    public Response nueva(Cliente cliente) {
        reservaController.nueva(cliente);
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idreserva}")
    public Response obtener(@PathParam("idreserva") Integer idReserva) {
        Reserva reserva = reservaController.obtener(idReserva);
        return Response.status(Response.Status.OK).entity(reserva).build();
    }


    @PUT
    @Produces("text/plain")
    @Path("modificar")
    public Response modificar(Reserva reserva) {
        reservaController.modificar(reserva);
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{idreserva}")
    public Response eliminar(@PathParam("idreserva") Integer idReserva) {
        reservaController.eliminar(idReserva);
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarreservas")
    public Response listar() {
        ListaReservas log = new ListaReservas();
        log.setReservaArrayList(reservaController.listar());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estadoreserva/{id}/{estado}")
    public Response actualizarEstado(@PathParam("id") Integer idReserva, @PathParam("estado") EstadoReserva nuevoEstado) {
        reservaController.actualizarEstado(idReserva, nuevoEstado);
        return null;
    }

    @PUT
    @Produces("text/plain")
    @Path("listarReservaXCliente/")
    public Response listarReservasCliente(Cliente cliente) {
        return Response.status(Response.Status.OK).entity(reservaController.
                listarReservasCliente(cliente)).build();
    }

}
