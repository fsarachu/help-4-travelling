package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.*;
import uy.edu.cure.servidor.central.lib.servicios.CategoriaService;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;
import java.util.Date;

@Path("/hardcodeo")
public class HardcodeoRestController {

    @PUT
    @Path("clientes")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoClientes(Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.nuevo(cliente);
        return Response.status(Response.Status.OK).entity(cliente).build(); ///Que retorno aquiiiii
    }

    @PUT
    @Path("paises")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hardcodeoPaises(Pais pais) {
        PaisController paisController = new PaisController();
        paisController.agregar(pais);
        return Response.status(Response.Status.OK).entity(pais).build(); ///Que retorno aquiiiii
    }

    @PUT
    @Path("ciudades")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response hardcodeoCiudades(Ciudad ciudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.nueva(ciudad);
        return Response.status(Response.Status.OK).entity(ciudad).build();
    }

    @PUT
    @Path("categorias")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoCategoria(Categoria categoria) {
        CategoriaController categoriaController = new CategoriaController();
        categoriaController.nueva(categoria);
        return Response.status(Response.Status.OK).entity(categoria).build();
    }

    @PUT
    @Path("proveedores")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoProveedor(Proveedor proveedor) {
        ProveedorController proveedorController = new ProveedorController();
        proveedorController.nuevo(proveedor);
        return Response.status(Response.Status.OK).entity(proveedor).build(); ///Que retorno aquiiiii
    }


    @PUT
    @Path("productos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoServicios(Producto producto) {
        ProductoController productoController = new ProductoController();
        productoController.agregar(producto);
        return Response.status(Response.Status.OK).entity(producto).build(); ///Que retorno aquiiiii
    }


    @PUT
    @Path("promociones")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoPromociones(Promocion promocion) {
        ProductoController productoctrl = new ProductoController();
        productoctrl.agregar(promocion);
        return Response.status(Response.Status.OK).entity(promocion).build(); ///Que retorno aquiiiii
    }


    @PUT
    @Path("carritos")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoCarritos(ItemReserva itemReserva, Carrito carrito) {
        CarritoController carritoController = new CarritoController();
        carritoController.agregarItem(itemReserva, carrito);
        return Response.status(Response.Status.OK).entity(carrito).build(); ///Que retorno aquiiiii
    }


    @GET
    @Path("reservas")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response harcodeoReservas() {
        ReservaController reservactrl = new ReservaController();
        ClienteController clientectrl = new ClienteController();

        reservactrl.nueva(clientectrl.obtener(1));

        reservactrl.nueva(clientectrl.obtener(2));
        reservactrl.nueva(clientectrl.obtener(2));

        reservactrl.nueva(clientectrl.obtener(3));

        reservactrl.nueva(clientectrl.obtener(4));

        reservactrl.nueva(clientectrl.obtener(5));
        reservactrl.nueva(clientectrl.obtener(5));
        reservactrl.nueva(clientectrl.obtener(5));

        reservactrl.nueva(clientectrl.obtener(6));
        reservactrl.nueva(clientectrl.obtener(6));

        return Response.status(Response.Status.OK).entity(null).build(); ///Que retorno aquiiiii
    }
}
