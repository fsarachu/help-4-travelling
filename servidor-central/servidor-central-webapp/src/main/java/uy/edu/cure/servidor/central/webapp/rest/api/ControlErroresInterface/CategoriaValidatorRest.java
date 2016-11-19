package uy.edu.cure.servidor.central.webapp.rest.api.ControlErroresInterface;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.CategoriaValidator;

import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Created by victor on 16/11/16.
 */
@Path("/errores")
public class CategoriaValidatorRest {
    CategoriaValidator categoriaValidator = new CategoriaValidator();

    public CategoriaValidatorRest() {
    }


    @PUT
    @Produces("text/plain")
    @Path("validatorCategoria/{nombre}")
    public Response validator(@PathParam("nombre") String nombre, Categoria padre) {
        boolean log = categoriaValidator.validator(nombre, padre);
        return Response.status(Response.Status.OK).entity(log).build();
    }

}
