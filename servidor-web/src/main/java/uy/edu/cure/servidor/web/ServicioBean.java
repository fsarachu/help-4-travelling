package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.bean.ViewScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class ServicioBean implements Serializable{
    private Servicio servicio;
    private List<Producto> listarProductosServicio = new ArrayList<Producto>();
    private List<Producto> listarProducto = new ArrayList<Producto>();
    private List<Servicio> listaServicios = new ArrayList<Servicio>();


    public ServicioBean() {
        cargarServiciosPromos();
    }

    public String cargarServicios(Integer id) {
        listarProductosServicio = null;
        for (Producto producto : listarProducto ) {
            if (producto.getProveedor().getId().equals(id)) {
                listarProductosServicio.add(producto);
            }
        }
        return "AgregarServicioPromo?faces-redirect=true";
    }

    public void cargarServiciosXCategoria(Categoria categoria) {
        ProductoController productoController = new ProductoController();
        listaServicios = productoController.listarServiciosPorCategoria(categoria);
        // "AgregarServicioPromo?faces-redirect=true";
    }

    public boolean serviciosCargados(){
        if (listarProductosServicio.size() != 0){
            return true;
        } else {
            return false;
        }
    }

    public List<Servicio> getListaServicios() {
        return listaServicios;
    }

    public void setListaServicios(List<Servicio> listaServicios) {
        this.listaServicios = listaServicios;
    }

    public List<Producto> getListarProductosServicio() {
        return listarProductosServicio;
    }

    public void setListarProductosServicio(List<Producto> listarProductosServicio) {
        this.listarProductosServicio = listarProductosServicio;
    }

    public void cargarServiciosPromos(){
        ProductoController productoController = new ProductoController();
        listarProducto = productoController.listarTodos();
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

    public List<Producto> getListarProducto() {
        return listarProducto;
    }

    public void setListarProducto(List<Producto> listarProducto) {
        this.listarProducto = listarProducto;
    }
}
