package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Log;
import uy.edu.cure.servidor.central.lib.controllers.LogController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 03/12/16.
 */
@Path("/log")
public class LogRestController {
    LogController logController = new LogController();

    @PUT
    @Path("guardar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response guardar(Log log) {
        logController.nuevo(log);
        return Response.status(Response.Status.OK).entity(log).build();
    }



}
