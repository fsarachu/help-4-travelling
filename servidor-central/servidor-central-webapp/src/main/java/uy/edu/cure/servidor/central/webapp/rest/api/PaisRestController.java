package uy.edu.cure.servidor.central.webapp.rest.api;

import uy.edu.cure.servidor.central.dto.Pais;
import uy.edu.cure.servidor.central.lib.controllers.PaisController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class PaisRestController {

    @GET
    @Produces
    public void agregar(Pais pais) {
        PaisController paisController = new PaisController();
        paisController.agregar(pais);
    }

    @GET
    @Produces
    public void eliminar(Integer idPais) {
        PaisController paisController = new PaisController();
        paisController.eliminar(idPais);
    }

    @GET
    @Produces
    public void modificar(Pais pais) {
        PaisController paisController = new PaisController();
        paisController.modificar(pais);
    }

    @GET
    @Produces
    public ArrayList<Pais> listar() {
        PaisController paisController = new PaisController();
        return paisController.listar();
    }

}
