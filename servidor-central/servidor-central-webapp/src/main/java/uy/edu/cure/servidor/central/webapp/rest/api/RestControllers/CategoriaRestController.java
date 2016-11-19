package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaCategorias;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

import java.util.ArrayList;

@Path("/categoria")
public class CategoriaRestController {


    @PUT
    @Path("nueva")
    @Produces("text/plain")
    public Response nuevo( Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.nueva(categoria);
        return null; ///Que retorno aquiiiii
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idcategoria}")
    public Response obtener(@PathParam("idcategoria") String idcategoria) {
        CategoriaController categoriaController = new CategoriaController();
        Categoria log = categoriaController.obtener(Integer.parseInt(idcategoria));
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("modificar/")
    public Response modificar(Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.modificar(categoria);
        return null;  ///que retorno
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listar() {
        CategoriaController categoriaController = new CategoriaController();
        ListaCategorias log = new ListaCategorias();
        log.setCategoriaArrayList(categoriaController.listar());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    //// revisar esta
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarhijos")
    public ArrayList<Categoria> listarHijos(Categoria padre) {
        CategoriaController categoriaController = new CategoriaController();
        return categoriaController.listarHijos(padre);
    }

    @PUT
    @Produces("text/plain")
    @Path("ocultar/")
    public Response ocultar(Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.ocultar(categoria);
        return null;
    }
}
