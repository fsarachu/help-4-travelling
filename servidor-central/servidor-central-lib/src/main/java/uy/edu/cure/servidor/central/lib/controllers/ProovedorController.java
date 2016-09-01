package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

public class ProovedorController {
    public void alta(Proveedor proveedor) {
        ProveedorService proveedorService = ServiceFactory.getProveedorService();

        proveedorService.agregar(proveedor);
    }
}
