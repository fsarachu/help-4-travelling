package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.controllers.CiudadController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class CiudadRestController {

    @GET
    @Produces
    public void nueva(Ciudad ciudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.nueva(ciudad);
    }

    @GET
    @Produces
    public void eliminar(Integer idCiudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.eliminar(idCiudad);
    }

    @GET
    @Produces
    public Ciudad obtener(Integer idCiudad) {
        CiudadController ciudadController = new CiudadController();
        return ciudadController.obtener(idCiudad);
    }

    @GET
    @Produces
    public void modificar(Ciudad ciudad) {
        CiudadController ciudadController = new CiudadController();
        ciudadController.modificar(ciudad);
    }

    @GET
    @Produces
    public ArrayList<Ciudad> listar() {
        CiudadController ciudadController = new CiudadController();
        return ciudadController.listar();
    }

}