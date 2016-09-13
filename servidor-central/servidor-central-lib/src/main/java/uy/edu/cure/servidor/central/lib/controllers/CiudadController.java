package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;
import java.util.Vector;

public class CiudadController {

    public void nuevo(Ciudad ciudad) {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        ciudadService.agregar(ciudad.getId(), ciudad);
    }

    public ArrayList<Ciudad> listar() {
        CiudadService ciudadService = ServiceFactory.getCiudadService();

        return ciudadService.listar();
    }

}
