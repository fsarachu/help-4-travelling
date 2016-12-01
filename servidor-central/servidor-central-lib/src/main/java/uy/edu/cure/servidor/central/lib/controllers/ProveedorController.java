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

    public Proveedor obtenerXNombre (String nombre) { return this.proveedorService.obtenerXNombre(nombre);}

    public void modificar(Proveedor proveedor) {
        this.proveedorService.modificar(proveedor.getId(), proveedor);
    }

    public ArrayList<Proveedor> listar() {
        return this.proveedorService.listar();
    }

    public boolean nicknameExiste(String nickname) {
        return this.proveedorService.nicknameExiste(nickname);
    }

    public boolean comprobarlogin(String nickname, String contrasena) {
        return this.proveedorService.comprobarlogin(nickname,contrasena);
    }

    public boolean comprobarloginMail(String email, String contrasena) {
        return this.proveedorService.comprobarloginMail(email, contrasena);
    }

    public boolean emailExiste(String email) {
        return this.proveedorService.emailExiste(email);
    }
}
