package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.servicios.conexion;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import java.sql.SQLException;

// http://localhost:8080/servidor-central-webapp/rest/api
@Path("/test")
public class TestRestController {

    @GET
    @Produces("text/plain")
    public String getClichedMessage() {
        // Return some cliched textual content
        return "Hello JUnit";
    }

    @PUT
    @Path("update")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.APPLICATION_JSON)
    public Response updateUsuario(Cliente u) {
        u.setNombre("Nombre MODIFICADO POR MI METODO");
        return Response.status(Response.Status.OK).entity(u).build();
    }

    @GET
    @Path("traer/{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Response getPorId(@PathParam("id") int id) {
        Cliente u = new Cliente();
        conexion cn = new conexion();
        try {
            u = cn.buscarCliente(id);
            System.out.println(u.getNombre());
            cn.cerrar();
        } catch (SQLException e) {
            System.out.print("Error");
        }
        //u.setId(id);
        return Response.status(Response.Status.OK).entity(u).build();
    }

}
