package uy.edu.cure.servidor.central.lib.controllers;

import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.lib.servicios.ProductoService;
import uy.edu.cure.servidor.central.lib.servicios.ServiceFactory;

import java.util.ArrayList;

public class ProductoController {

    private ProductoService productoService;

    public ProductoController() {
        this.productoService = ServiceFactory.getProductoService();
    }

    public ArrayList<Producto> listar() {
        return this.productoService.listar();
    }

    public void agregar(Producto producto) {
        this.productoService.agregar(producto.getId(), producto);
    }

    public void modificar(Producto producto) {
        this.productoService.modificar(producto.getId(), producto);
    }

    public void eliminar(Integer idProducto) {
        this.productoService.eliminar(idProducto);
    }
    

}
