package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.CiudadController;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
@Path("/ciudad")
public class CiudadRestController {


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("nueva")
    public Response nueva(Ciudad ciudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.nueva(ciudad);
        return Response.status(Response.Status.OK).entity(ciudad).build();
    }

    @GET
    @Produces
    public Ciudad obtener(Integer idCiudad) {
        CiudadController ciudadController = new CiudadController();
        return ciudadController.obtener(idCiudad);
    }

    @GET
    @Produces
    public void modificar(Ciudad ciudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.modificar(ciudad);
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listar() {
        CiudadController ciudadController = new CiudadController();
        ArrayList<Ciudad> listado = ciudadController.listar();
        return Response.status(Response.Status.OK).entity(listado).build();
    }

}