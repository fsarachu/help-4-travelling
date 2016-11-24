package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.webapp.rest.api.HardcodeoBean;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 21/11/16.
 */
@Path("/hardcodeo")
public class HardcodeoRestController {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("cargar")
    public Response hardcodeo() {
        ClienteController clienteController = new ClienteController();
        if (clienteController.listar().size() == 0 ) {
            HardcodeoBean hardcodeoBean = new HardcodeoBean();
        }
        return Response.status(Response.Status.OK).entity(true).build();
    }

}
