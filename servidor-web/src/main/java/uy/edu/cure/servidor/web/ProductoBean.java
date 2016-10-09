package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Producto;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;

@ManagedBean
@SessionScoped
public abstract class ProductoBean implements Serializable{
    private Producto producto;

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}
