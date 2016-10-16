package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.Producto;
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
    private List<Producto> listarProductosServicio = new ArrayList<Producto>();
    private List<Producto> listarProducto = new ArrayList<Producto>();
    private List<Servicio> listaServicios = new ArrayList<Servicio>();
    private List<Categoria> listaCategorias = new ArrayList<Categoria>();


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
    }

    public String buscarServicio(Integer id){
        ProductoController productoController = new ProductoController();
        servicio = (Servicio)productoController.obtener(id);
        for (Categoria categoria : servicio.getCategorias()) {
            listaCategorias.add(categoria);
        }
        return "VerInfoServicio?faces-redirect=true";
    }

    public List<Categoria> getListaCategorias() {
        return listaCategorias;
    }

    public void setListaCategorias(List<Categoria> listaCategorias) {
        this.listaCategorias = listaCategorias;
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
