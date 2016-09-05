package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ProveedorController {

    public void nuevo(Proveedor proveedor) {
        ProveedorService proveedorService = ServiceFactory.getProveedorService();

        proveedorService.agregar(proveedor.getId(), proveedor);
    }

    public ArrayList<Proveedor> listar() {
        ProveedorService proveedorService = ServiceFactory.getProveedorService();

        return proveedorService.listar();
    }
}
