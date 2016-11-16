package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.servicios.conexion;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.sql.Connection;
import java.util.ArrayList;


@Path("/usuario")
public class ClienteRestController {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello Usuario";
    }

    @GET
    @Path("/nuevo")
    @Produces("text/plain")
    public void nuevo(Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.nuevo(cliente);
    }

    @GET
    @Produces
    public void eliminar(Integer idCliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.eliminar(idCliente);
    }

    @GET
    @Produces
    public Cliente obtener(Integer idCliente) {
        ClienteController clienteController = new ClienteController();
        return clienteController.obtener(idCliente);
    }

    @GET
    @Produces
    public Cliente obtenerXNombre(String nombre) {
        ClienteController clienteController = new ClienteController();
        return clienteController.obtenerXNombre(nombre);
    }

    @GET
    @Produces
    public Cliente obtenerXMail(String mail) {
        ClienteController clienteController = new ClienteController();
        return clienteController.obtenerXMail(mail);
    }

    @GET
    @Produces
    public void modificar(Cliente cliente) {
        ClienteController clienteController = new ClienteController();
        clienteController.modificar(cliente);
    }

    @GET
    @Produces
    public ArrayList<Cliente> listar() {
        ClienteController clienteController = new ClienteController();
        return clienteController.listar();
    }

    @GET
    @Produces
    public boolean nicknameExiste(String nickname) {
        ClienteController clienteController = new ClienteController();
        return clienteController.nicknameExiste(nickname);
    }

    @GET
    @Produces
    public boolean emailExiste(String email) {
        ClienteController clienteController = new ClienteController();
        return clienteController.emailExiste(email);
    }

    @GET
    @Produces
    public boolean comprobarlogin(String nickname, String contrasena) {
        ClienteController clienteController = new ClienteController();
        return clienteController.comprobarlogin(nickname, contrasena);
    }

    @GET
    @Produces
    public boolean comprobarloginMail(String email, String contrasena) {
        ClienteController clienteController = new ClienteController();
        return clienteController.comprobarloginMail(email, contrasena);
    }

    @GET
    @Produces
    public ArrayList<Cliente> listarCompradoresServicio(Servicio servicio) {
        ClienteController clienteController = new ClienteController();
        return clienteController.listarCompradoresServicio(servicio);
    }


}