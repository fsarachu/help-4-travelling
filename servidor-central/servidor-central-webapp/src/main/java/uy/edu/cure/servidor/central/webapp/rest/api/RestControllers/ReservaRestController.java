package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaReservas;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 09/11/16.
 */
@Path("/reserva")
public class ReservaRestController {

    ReservaController reservaController = new ReservaController();


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("nueva")
    public Response nueva(Cliente cliente) {
        reservaController.nueva(cliente);
        return Response.status(Response.Status.OK).entity(true).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idreserva}")
    public Response obtener(@PathParam("idreserva") Integer idReserva) {
        Reserva reserva = reservaController.obtener(idReserva);
        return Response.status(Response.Status.OK).entity(reserva).build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("modificar")
    public Response modificar(Reserva reserva) {
        reservaController.modificar(reserva);
        return Response.status(Response.Status.OK).entity(reserva).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{idreserva}")
    public Response eliminar(@PathParam("idreserva") Integer idReserva) {
        reservaController.eliminar(idReserva);
        return Response.status(Response.Status.OK).entity(true).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listar() {
        ListaReservas log = new ListaReservas();
        log.setReservaArrayList(reservaController.listar());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("estadoreserva/{id}/{nuevoestado}")
    public Response actualizarEstado(@PathParam("id") Integer idReserva, @PathParam("nuevoestado") Integer nuevoEstado) {
        EstadoReserva estado ;
        estado = EstadoReserva.getEnum(nuevoEstado);
        reservaController.actualizarEstado(idReserva, estado);
        return Response.status(Response.Status.OK).entity(estado).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("listarReservaXCliente/")
    public Response listarReservasCliente(Cliente cliente) {
        ListaReservas log = new ListaReservas();
        log.setReservaArrayList(reservaController.listarReservasCliente(cliente));
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("listarReservaXProveedor/{idProveedor}")
    public Response listarReservasProveedor(@PathParam("idProveedor") Integer idProveedor) {
        ListaReservas log = new ListaReservas();
        log.setReservaArrayList(reservaController.listarReservasProveedor(idProveedor));
        return Response.status(Response.Status.OK).entity(log).build();
    }

}
