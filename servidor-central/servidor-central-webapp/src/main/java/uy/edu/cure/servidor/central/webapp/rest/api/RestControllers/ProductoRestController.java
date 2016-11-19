package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaProductos;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaPromociones;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaServicios;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
@Path("/producto")
public class ProductoRestController {
    ProductoController productoController = new ProductoController();


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listarTodos() {
        ListaProductos log = new ListaProductos();
        log.setProductoArrayList(productoController.listarTodos());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("agregar")
    public Response agregar(Producto producto) {
        productoController.agregar(producto);
        return null;
    }

    @PUT
    @Produces("text/plain")
    @Path("modificar")
    public Response modificar(Producto producto) {
        productoController.modificar(producto);
        return null;
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{idproducto}")
    public Response eliminar(@PathParam("idproducto") Integer idProducto) {
        productoController.eliminar(idProducto);
        return null;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarservicios")
    public Response listarServicios() {
        ListaServicios log = new ListaServicios();
        log.setServicioArrayList(productoController.listarServicios());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarpromociones")
    public Response listarPromociones() {
        ListaPromociones log = new ListaPromociones();
        log.setPromocionArrayList(productoController.listarPromociones());
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idproducto}")
    public Response obtener(@PathParam("idproducto") Integer idProducto) {
        Producto log = productoController.obtener(idProducto);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("listarServicioXCiudad/")
    public Response listarServiciosPorCiudad(Ciudad ciudad) {
        return Response.status(Response.Status.OK).entity(productoController.
                listarServiciosPorCiudad(ciudad)).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("listarServiciosXCategoria/")
    public Response listarServiciosPorCategoria(Categoria categoria) {
        return Response.status(Response.Status.OK).entity(productoController.
                listarServiciosPorCategoria(categoria)).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("listarPromocionesXCategoria")
    public Response listarPromocionesPorCategoria(Categoria categoria) {
        return Response.status(Response.Status.OK).entity(productoController.
                listarPromocionesPorCategoria(categoria)).build();
    }

}