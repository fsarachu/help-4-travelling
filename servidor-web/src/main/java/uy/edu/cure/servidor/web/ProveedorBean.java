package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ProveedorBean implements Serializable{
    private Proveedor proveedor;
    private List<Proveedor> listProveedores = new ArrayList<Proveedor>();

    public ProveedorBean() {
        cargarLista();
    }

    private void cargarLista(){
        ProveedorController proveedorController = new ProveedorController();
        listProveedores = proveedorController.listar();
    }

    public List<Proveedor> getListProveedores() {
        return listProveedores;
    }

    public void setListProveedores(List<Proveedor> listProveedores) {
        this.listProveedores = listProveedores;
    }

    public Proveedor getProveedor() {
        if (proveedor == null) {
            proveedor = new Proveedor();
        }
        return proveedor;
    }

    public void setProveedor(Proveedor proveedor) {
        this.proveedor = proveedor;
    }
}
