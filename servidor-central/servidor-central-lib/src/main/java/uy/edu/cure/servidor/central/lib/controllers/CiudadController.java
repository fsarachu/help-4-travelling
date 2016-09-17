package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.servicios.CiudadService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class CiudadController {
    private CiudadService ciudadService;

    public CiudadController() {
        this.ciudadService = ServiceFactory.getCiudadService();
    }

    public void nueva(Ciudad ciudad) {
        ciudad.setId(this.ciudadService.nextId());
        this.ciudadService.agregar(ciudad.getId(), ciudad);
    }

    public void eliminar(Integer idCiudad) {
        this.ciudadService.eliminar(idCiudad);
    }

    Ciudad obtener(Integer idCiudad) {
        return this.ciudadService.obtener(idCiudad);
    }

    public void modificar(Ciudad ciudad) {
        this.ciudadService.modificar(ciudad.getId(), ciudad);
    }

    public ArrayList<Ciudad> listar() {
        return this.ciudadService.listar();
    }

}
