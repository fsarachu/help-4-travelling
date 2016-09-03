package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Servicio extends Producto {
    private ArrayList<BufferedImage> imagenes;
    private ArrayList<Integer> idCategorias;
    private ArrayList<Categoria> categorias;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio(Integer id, String nombre, String descripcion, double precio, Proveedor proveedor, ArrayList<BufferedImage> imagenes, ArrayList<Integer> idCategorias, ArrayList<Categoria> categorias, Ciudad origen, Ciudad destino) {
        super(id, nombre, descripcion, precio, proveedor);
        this.imagenes = imagenes;
        this.idCategorias = idCategorias;
        this.categorias = categorias;
        this.origen = origen;
        this.destino = destino;
    }

    public ArrayList<BufferedImage> getImagenes() {
        return imagenes;
    }

    public ArrayList<Integer> getIdCategorias() {
        return idCategorias;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public Ciudad getOrigen() {
        return origen;
    }

    public void setOrigen(Ciudad origen) {
        this.origen = origen;
    }

    public Ciudad getDestino() {
        return destino;
    }

    public void setDestino(Ciudad destino) {
        this.destino = destino;
    }
}
