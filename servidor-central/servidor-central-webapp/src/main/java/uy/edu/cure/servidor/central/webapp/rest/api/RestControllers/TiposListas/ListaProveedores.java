package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas;

import uy.edu.cure.servidor.central.dto.Proveedor;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaProveedores {
    private ArrayList<Proveedor> proveedorArrayList;

    public ListaProveedores() {
    }

    public ArrayList<Proveedor> getProveedorArrayList() {
        return proveedorArrayList;
    }

    public void setProveedorArrayList(ArrayList<Proveedor> proveedorArrayList) {
        this.proveedorArrayList = proveedorArrayList;
    }
}
