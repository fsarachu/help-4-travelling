package uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas;

import uy.edu.cure.servidor.central.dto.Producto;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaProductos {
    private ArrayList<Producto> productoArrayList;

    public ListaProductos() {
    }

    public ArrayList<Producto> getProductoArrayList() {
        return productoArrayList;
    }

    public void setProductoArrayList(ArrayList<Producto> productoArrayList) {
        this.productoArrayList = productoArrayList;
    }
}

