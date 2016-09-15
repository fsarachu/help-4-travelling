package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Servicio;
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

}
