package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class ProductoRestController {
    ProductoController productoController = new ProductoController();
    @GET
    @Produces
    public ArrayList<Producto> listarTodos() {
        return productoController.listarTodos();
    }

    @GET
    @Produces
    public void agregar(Producto producto) {
        productoController.agregar(producto);
    }

    @GET
    @Produces
    public void modificar(Producto producto) {
        productoController.modificar(producto);
    }

    @GET
    @Produces
    public void eliminar(Integer idProducto) {
        productoController.eliminar(idProducto);
    }

    @GET
    @Produces
    public ArrayList<Servicio> listarServicios() {
        return productoController.listarServicios();
    }

    @GET
    @Produces
    public ArrayList<Promocion> listarPromociones() {
        return productoController.listarPromociones();
    }

    @GET
    @Produces
    public Producto obtener(Integer idProducto) {
        return productoController.obtener(idProducto);
    }

    @GET
    @Produces
    public ArrayList<Servicio> listarServiciosPorCiudad(Ciudad ciudad) {
        return productoController.listarServiciosPorCiudad(ciudad);
    }

    @GET
    @Produces
    public ArrayList<Servicio> listarServiciosPorCategoria(Categoria categoria) {
        return productoController.listarServiciosPorCategoria(categoria);
    }

    @GET
    @Produces
    public ArrayList<Promocion> listarPromocionesPorCategoria(Categoria categoria) {
        return productoController.listarPromocionesPorCategoria(categoria);
    }

}