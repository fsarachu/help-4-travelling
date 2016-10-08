package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Producto;

public abstract class ProductoBean {
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
