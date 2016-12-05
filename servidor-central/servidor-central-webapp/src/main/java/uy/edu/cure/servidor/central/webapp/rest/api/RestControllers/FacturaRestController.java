package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.lib.controllers.FacturaController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.io.File;

@Path("/factura")
public class FacturaRestController {

    //http://localhost:8080/servidor-central-webapp/rest/api/factura/pdf
    @GET
    @Produces("application/pdf")
    @Path("pdf")
    public Response nuevo() {
        FacturaController facturaController = new FacturaController();
        File res = facturaController.generarPDF();
        return Response.status(Response.Status.OK).entity(res).build();
    }

    /*@GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idcategoria}")
    public Response obtener(@PathParam("idcategoria") Integer idcategoria) {
        CategoriaController categoriaController = new CategoriaController();
        //Categoria log = categoriaController.obtener(idcategoria);
        return Response.status(Response.Status.OK).entity(log).build();
    }*/

}
