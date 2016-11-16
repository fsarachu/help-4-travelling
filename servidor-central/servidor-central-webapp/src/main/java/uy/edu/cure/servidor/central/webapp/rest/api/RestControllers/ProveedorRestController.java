package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import javax.ws.rs.GET;
import javax.ws.rs.Produces;
import java.util.ArrayList;

/**
 * Created by victor on 09/11/16.
 */
public class ProveedorRestController {

    ProveedorController proveedorController = new ProveedorController();

    @GET
    @Produces
    public void nuevo(Proveedor proveedor) {
        proveedorController.nuevo(proveedor);
    }

    @GET
    @Produces
    public void eliminar(Integer idProveedor) {
        proveedorController.eliminar(idProveedor);
    }

    @GET
    @Produces
    public Proveedor obtener(Integer idProveedor) {
        return proveedorController.obtener(idProveedor);
    }

    @GET
    @Produces
    public void modificar(Proveedor proveedor) {
        proveedorController.modificar(proveedor);
    }

    @GET
    @Produces
    public ArrayList<Proveedor> listar() {
        return proveedorController.listar();
    }

    @GET
    @Produces
    public boolean nicknameExiste(String nickname) {
        return proveedorController.nicknameExiste(nickname);
    }

    @GET
    @Produces
    public boolean emailExiste(String email) {
        return proveedorController.emailExiste(email);
    }

}