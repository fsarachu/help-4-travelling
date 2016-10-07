package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.servicios.ProveedorService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ProveedorController {
    private ProveedorService proveedorService;

    public ProveedorController() {
        this.proveedorService = ServiceFactory.getProveedorService();
    }

    public void nuevo(Proveedor proveedor) {
        proveedor.setId(this.proveedorService.nextId());
        proveedorService.agregar(proveedor.getId(), proveedor);
    }

    public void eliminar(Integer idProveedor) {
        this.proveedorService.eliminar(idProveedor);
    }

    public Proveedor obtener(Integer idProveedor) {
        return this.proveedorService.obtener(idProveedor);
    }

    public void modificar(Proveedor proveedor) {
        this.proveedorService.modificar(proveedor.getId(), proveedor);
    }

    public ArrayList<Proveedor> listar() {
        return this.proveedorService.listar();
    }

    public boolean nicknameExiste(String nickname) {
        return this.proveedorService.nicknameExiste(nickname);
    }

    public boolean emailExiste(String email) {
        return this.proveedorService.emailExiste(email);
    }
}
