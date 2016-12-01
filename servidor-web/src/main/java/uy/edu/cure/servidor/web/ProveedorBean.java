package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaProveedores;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

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
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/listar";
        RestController rest = new RestController();
        ListaProveedores u = rest.doGET(url, ListaProveedores.class);
        listProveedores = u.getProveedorArrayList();
    }

    public void seleccionarProveedor(Integer id) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/obtener/"+id;
        RestController rest = new RestController();
        proveedor = rest.doGET(url, Proveedor.class);
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
