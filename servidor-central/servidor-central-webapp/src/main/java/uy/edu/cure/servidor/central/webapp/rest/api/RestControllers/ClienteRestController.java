package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.util.ArrayList;


@Path("/cliente")
    public class ClienteRestController {

    @PUT
    @Path("nuevo")
    @Produces("text/plain")
    public Response nuevo( Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.nuevo(cliente);
        return null; ///Que retorno aquiiiii
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{cliente}")
    public Response eliminar(@PathParam("cliente") Integer idCliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.eliminar(idCliente);
        return Response.status(Response.Status.OK).entity(null).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{cliente}")
    public Response obtener(@PathParam("cliente") Integer idCliente) {
        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.obtener(idCliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXNombre/{nombre}")
    public Response obtenerXNombre(@PathParam("nombre") String nombre) {
        ClienteController clienteController = new ClienteController();
        Cliente cliente = clienteController.obtenerXNombre(nombre);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXMail/{mail}")
    public Response emailExiste(@PathParam("mail") String mail) {
        ClienteController clienteController = new ClienteController();
        boolean log = clienteController.emailExiste(mail);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXMail/{mail}")
    public Response obtenerXMail(@PathParam("mail") String mail) {
        ClienteController clienteController = new ClienteController();
        boolean log = clienteController.emailExiste(mail);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarCliente")
    public Response listar() {
        ClienteController clienteController = new ClienteController();
        ArrayList<Cliente> listado =clienteController.listar();
        return Response.status(Response.Status.OK).entity(listado).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nicknameExiste/{nickname}")
    public Response nicknameExiste(@PathParam("nickname") String nickname) {
        ClienteController clienteController = new ClienteController();
        boolean log = clienteController.nicknameExiste(nickname);
        return Response.status(Response.Status.OK).entity(log).build();
    }



    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login/{n}/{p}")
    public Response updateUsuario(@PathParam("n") String nickname, @PathParam("p")String contrasena){
        ClienteController clienteController = new ClienteController();
        boolean log=  clienteController.comprobarlogin(nickname, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login/{e}/{p}")
    public Response comprobarloginMail(@PathParam("e") String email, @PathParam("p") String contrasena) {
        ClienteController clienteController = new ClienteController();
        boolean log = clienteController.comprobarloginMail(email, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public ArrayList<Cliente> listarCompradoresServicio(Servicio servicio) {
        ClienteController clienteController = new ClienteController();
        return clienteController.listarCompradoresServicio(servicio);
    }

    @PUT
    @Produces
    public void modificar(Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.modificar(cliente);
    }

}