package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class CategoriaRestController {

    @GET
    @Produces
    public void nueva(Categoria nuevaCategoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.nueva(nuevaCategoria);
    }

    @GET
    @Produces
    public Categoria obtener(Integer idCategoria) {
        CategoriaController categoriaController = new CategoriaController();
        return categoriaController.obtener(idCategoria);
    }

    @GET
    @Produces
    public void modificar(Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.modificar(categoria);
    }

    @GET
    @Produces
    public ArrayList<Categoria> listar() {
        CategoriaController categoriaController = new CategoriaController();
        return categoriaController.listar();
    }

    @GET
    @Produces
    public ArrayList<Categoria> listarHijos(Categoria padre) {
        CategoriaController categoriaController = new CategoriaController();
        return categoriaController.listarHijos(padre);
    }

    @GET
    @Produces
    public void ocultar(Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.ocultar(categoria);
    }

}
