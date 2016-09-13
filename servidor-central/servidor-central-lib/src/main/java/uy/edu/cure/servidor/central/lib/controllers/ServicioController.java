package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;

import java.util.ArrayList;

public class ServicioController {

    public void nuevo(Servicio servicio) {
        ServicioService servicioService = ServiceFactory.getServicioService();

        servicioService.agregar(servicio.getId(), servicio);

        Proveedor proveedor = servicio.getProveedor();

        proveedor.getServicios().add(servicio);

    }

    public void eliminar(int id) {
        ServicioService ciudadService = ServiceFactory.getServicioService();

        ciudadService.eliminar(id);
    }

    Servicio obtener(Integer id) {
        ServicioService ciudadService = ServiceFactory.getServicioService();

        return ciudadService.obtener(id);
    }

    public void modificar(Integer id, Servicio ciudad1) {
        ServicioService ciudadService = ServiceFactory.getServicioService();

        ciudadService.modificar(id, ciudad1);
    }

    public ArrayList<Servicio> listar() {
        ServicioService servicioService = ServiceFactory.getServicioService();

        return servicioService.listar();
    }
}
