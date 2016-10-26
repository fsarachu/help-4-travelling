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
public class ServicioBean implements Serializable {
    private Servicio servicio;
    private List<Producto> listarProductosServicio = new ArrayList<Producto>();
    private List<Producto> listarProducto = new ArrayList<Producto>();
    private List<Servicio> listaServicios = new ArrayList<Servicio>();
    private List<Categoria> listaCategorias = new ArrayList<Categoria>();
    private String buscar;

    public ServicioBean() {
        cargarServiciosPromos();
    }


    public void cargarServiciosXCategoria(Categoria categoria) {
        ProductoController productoController = new ProductoController();
        listaServicios = productoController.listarServiciosPorCategoria(categoria);
    }

    public String buscarServicio(Integer id) {
        ProductoController productoController = new ProductoController();
        if (!id.equals(null)) {
            servicio = (Servicio) productoController.obtener(id);
            for (Categoria categoria : servicio.getCategorias()) {
                listaCategorias.add(categoria);
            }
            return "VerInfoServicio?faces-redirect=true";
        } else {
            return null;
        }

    }

    public String cargaServiciosCarrito(Integer id) {
        ProductoController productoController = new ProductoController();
        if (!id.equals(null)) {
            servicio = (Servicio) productoController.obtener(id);
            for (Categoria categoria : servicio.getCategorias()) {
                listaCategorias.add(categoria);
            }
            return "AgregarAlCarrito?faces-redirect=true";
        } else {
            return null;
        }

    }

    public String buscarServicioPromo(String busqueda) {
        listarProducto.clear();
        ProductoController productoController = new ProductoController();
        listarProductosServicio = productoController.listarTodos();
        for (Producto producto : listarProductosServicio) {
            if (producto.getNombre().contains(busqueda) || producto.getDescripcion().contains(busqueda)) {
                listarProducto.add(producto);
            }
        }
        /*listaServicios = productoController.listarServicios();
        CategoriaController categoriaController = new CategoriaController();
        List<Categoria> categorias = categoriaController.listar();
        for (Categoria categoria : categorias) {
            if (!categoria.getNombre().contains(busqueda)) {
                categorias.remove(categoria);
            }
        }
        for (Servicio servicios: listaServicios){
            for (int i=0 ; i<servicios.getCategorias().size() ; i++)
                if (servicios.getCategorias().get(i).getNombre().contains(busqueda)
        }*/
        return "Buscar.xhtml?faces-redirect=true";
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

    public void cargarServiciosPromos() {
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

    public String getBuscar() {
        return buscar;
    }

    public void setBuscar(String buscar) {
        this.buscar = buscar;
    }
}
