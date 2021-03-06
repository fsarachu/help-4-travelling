package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaProductos;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaPromociones;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaServicios;

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
    @Path("agregar")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response agregar(Producto producto) {
        ProductoController productoController1 = new ProductoController();
        productoController1.agregar(producto);
        return Response.status(Response.Status.OK).entity(producto).build();
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
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("listarServiciosXCategoria/")
    public Response listarServiciosPorCategoria(Categoria categoria) {
        ListaServicios listaServicios = new ListaServicios();
        ArrayList<Servicio> tm = productoController.listarServiciosPorCategoria(categoria);
        listaServicios.setServicioArrayList(tm);
        return Response.status(Response.Status.OK).entity(listaServicios).build();
    }

    @PUT
    @Produces("text/plain")
    @Path("listarPromocionesXCategoria")
    public Response listarPromocionesPorCategoria(Categoria categoria) {
        return Response.status(Response.Status.OK).entity(productoController.
                listarPromocionesPorCategoria(categoria)).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("obtenerserviciosXproveedor/{proveedor}")
    public Response obtenerServiciosXProveedor(@PathParam("proveedor") Integer proveedor) {
        ListaProductos listaProductos = new ListaProductos();
        ArrayList<Producto> tm = productoController.listarServiciosXProveedor(proveedor);
        listaProductos.setProductoArrayList(tm);
        return Response.status(Response.Status.OK).entity(listaProductos).build();
    }


}