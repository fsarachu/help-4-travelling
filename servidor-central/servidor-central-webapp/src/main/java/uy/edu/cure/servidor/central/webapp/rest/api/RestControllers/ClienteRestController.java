package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaClientes;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;


@Path("/cliente")
    public class ClienteRestController {
    ClienteController clienteController = new ClienteController();


    @PUT
    @Path("nuevo")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response nuevo( Cliente cliente) {
        clienteController.nuevo(cliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("eliminar/{cliente}")
    public Response eliminar(@PathParam("cliente") Integer idCliente) {
        clienteController.eliminar(idCliente);
        return Response.status(Response.Status.OK).entity(null).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtener/{cliente}")
    public Response obtener(@PathParam("cliente") Integer idCliente) {
        Cliente cliente = clienteController.obtener(idCliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXNombre/{nombre}")
    public Response obtenerXNombre(@PathParam("nombre") String nombre) {
        Cliente cliente = clienteController.obtenerXNombre(nombre);
        //System.out.println(cliente);
        return Response.status(Response.Status.OK).entity(cliente).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("emailExiste/{mail}")
    public Response emailExiste(@PathParam("mail") String mail) {
        boolean log = clienteController.emailExiste(mail);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("obtenerXMail/{mail}")
    public Response obtenerXMail(@PathParam("mail") String mail) {
        Cliente log = clienteController.obtenerXMail(mail);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listar")
    public Response listar() {
        ListaClientes listaClientes = new ListaClientes();
        listaClientes.setClienteArrayList(clienteController.listar());
        return Response.status(Response.Status.OK).entity(listaClientes).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("nicknameExiste/{nickname}")
    public Response nicknameExiste(@PathParam("nickname") String nickname) {
        boolean log = clienteController.nicknameExiste(nickname);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("login/{n}/{p}")
    public Response updateUsuario(@PathParam("n") String nickname, @PathParam("p")String contrasena){
        boolean log=  clienteController.comprobarlogin(nickname, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("comprobarloginmail/{e}/{p}")
    public Response comprobarloginMail(@PathParam("e") String email, @PathParam("p") String contrasena) {
        boolean log = clienteController.comprobarloginMail(email, contrasena);
        return Response.status(Response.Status.OK).entity(log).build();
    }


    @PUT
    @Produces(MediaType.APPLICATION_JSON)
    @Path("listarcompradoresServicio")
    public Response listarCompradoresServicio(Servicio servicio) {
        ListaClientes listaClientes = new ListaClientes();
        listaClientes.setClienteArrayList(clienteController.listarCompradoresServicio(servicio));
        return Response.status(Response.Status.OK).entity(listaClientes).build();
    }

    @PUT
    @Produces
    public void modificar(Cliente cliente) {
        clienteController.modificar(cliente);
    }

}