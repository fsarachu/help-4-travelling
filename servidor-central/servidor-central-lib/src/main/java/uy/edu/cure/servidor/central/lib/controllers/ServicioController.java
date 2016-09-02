package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;
import uy.edu.cure.servidor.central.lib.servicios.ServicioService;

public class ServicioController {
    public void alta(Servicio servicio) {
        ServicioService servicioService = ServiceFactory.getServicioService();

        servicioService.agregar(servicio.getId(), servicio);

        Proveedor proveedor = servicio.getProveedor();

        proveedor.getServicios().add(servicio);

    }
}
