package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ServicioBean implements Serializable{
    private Servicio servicio;
    private List<Servicio> listarServicio = new ArrayList<Servicio>();

    public ServicioBean() {
        cargarServicios(1); //cargar parametro ?????????
    }

    public void cargarServicios(Integer id) {
        ProductoController productoController = new ProductoController();
        ArrayList<Servicio> guardarService = productoController.listarServicios();
        for (Servicio servicios : guardarService ) {
            if (servicios.getProveedor().getId().equals(id)) {
                listarServicio.add(servicios);
            }
        }
    }

    public List<Servicio> getListarServicio() {
        return listarServicio;
    }

    public void setListarServicio(List<Servicio> listarServicio) {
        this.listarServicio = listarServicio;
    }

    public Servicio getServicio() {
        if (servicio == null) {
            servicio = new Servicio();
        }
        return servicio;
    }

    public void setServicio(Servicio servicio) {
        this.servicio = servicio;
    }

}
