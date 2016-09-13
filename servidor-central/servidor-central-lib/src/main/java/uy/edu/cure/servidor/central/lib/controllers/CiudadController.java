package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CiudadController {

    public void nuevo(Ciudad ciudad) {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        ciudadService.agregar(ciudad.getId(), ciudad);
    }

    public void eliminar(int id) {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        ciudadService.eliminar(id);
    }

    Ciudad obtener(Integer id) {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Ciudad ciudad1) {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        ciudadService.modificar(id, ciudad1);
    }

    public ArrayList<Ciudad> listar() {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        return ciudadService.listar();
    }

}
