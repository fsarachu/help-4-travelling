package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaProveedores;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 09/11/16.
 */
@Path("/proveedor")
public class ProveedorRestController {

    ProveedorController proveedorController = new ProveedorController();


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    @Path("nuevo")
    public Response nuevo(Proveedor proveedor) {
        proveedorController.nuevo(proveedor);
        return Response.status(Response.Status.OK).entity(proveedor).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login/{n}/{p}")
    public Response updateUsuario(@PathParam("n") String nickname, @PathParam("p")String contrasena){
        boolean log=  proveedorController.comprobarlogin(nickname, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("comprobarloginmail/{e}/{p}")
    public Response comprobarloginMail(@PathParam("e") String email, @PathParam("p") String contrasena) {
        boolean log = proveedorController.comprobarloginMail(email, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{idproveedor}")
    public Response eliminar(@PathParam("idproveedor") Integer idProveedor) {
        proveedorController.eliminar(idProveedor);
        return null;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{idproveedor}")
    public Response obtener(@PathParam("idproveedor") Integer idProveedor) {
        Proveedor log = proveedorController.obtener(idProveedor);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces("text/plain")
    @Path("modificar")
    public Response modificar(Proveedor proveedor) {
        proveedorController.modificar(proveedor);
        return null;
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listar() {
        ListaProveedores log = new ListaProveedores();
        log.setProveedorArrayList(proveedorController.listar());
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nicknameexiste/{nickname}")
    public Response nicknameExiste(@PathParam("nickname") String nickname) {
        boolean log = proveedorController.nicknameExiste(nickname);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("emailexiste/{email}")
    public Response emailExiste(@PathParam("email") String email) {
        boolean log = proveedorController.emailExiste(email);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXNombre/{nombre}")
    public Response obtenerXNombre(@PathParam("nombre") String nombre) {
        Proveedor cliente = proveedorController.obtenerXNombre(nombre);
        //System.out.println(cliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }


}