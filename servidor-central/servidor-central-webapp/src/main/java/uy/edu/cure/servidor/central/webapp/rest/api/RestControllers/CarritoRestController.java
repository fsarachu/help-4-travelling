package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Carrito;
import uy.edu.cure.servidor.central.dto.ItemReserva;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 09/11/16.
 */
@Path("/carrito")
public class CarritoRestController {

    CarritoController carritoController = new CarritoController();

    @PUT
    @Produces("text/plain")
    @Path("actualizarTotal")
    public Response actualizarTotal(Carrito carrito) {
        carritoController.actualizarTotal(carrito);
        return Response.status(Response.Status.OK).entity(true).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenercarrito/{idcarrito}")
    public Response obtenerCarrito(@PathParam("idcarrito") Integer idCarrito) {
        Carrito log = carritoController.obtenerCarrito(idCarrito);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    ////////como le paso dos parametros
    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("agregaritem/{item}")
    public Response agregarItem(ItemReserva itemReserva, Carrito carrito) {
        CarritoController carritoController = new CarritoController();
        carritoController.agregarItem(itemReserva, carrito);
        return null;
    }

}
