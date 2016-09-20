package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ProductoController {

    private ProductoService productoService;

    public ProductoController() {
        this.productoService = ServiceFactory.getProductoService();
    }

    public ArrayList<Producto> listarTodos() {
        return this.productoService.listar();
    }

    public void agregar(Producto producto) {
        producto.setId(this.productoService.nextId());
        this.productoService.agregar(producto.getId(), producto);
    }

    public void modificar(Producto producto) {
        this.productoService.modificar(producto.getId(), producto);
    }

    public void eliminar(Integer idProducto) {
        this.productoService.eliminar(idProducto);
    }

    public ArrayList<Servicio> listarServicios() {
        return this.productoService.listarServicios();
    }

    public ArrayList<Promocion> listarPromociones() {
        return this.productoService.listarPromociones();
    }

    public Producto obtener(Integer idProducto) {
        return this.productoService.obtener(idProducto);
    }

    public ArrayList<Servicio> listarServiciosPorCiudad(Ciudad ciudad) {
        return this.productoService.listarServiciosPorCiudad(ciudad);
    }

    ArrayList<Servicio> listarServiciosPorCategoria(Categoria categoria) {
        return this.productoService.listarServiciosPorCategoria(categoria);
    }

    ArrayList<Promocion> listarPromocionesPorCategoria(Categoria categoria) {
        return this.productoService.listarPromocionesPorCategoria(categoria);
    }

}
