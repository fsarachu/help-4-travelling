package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Servicio extends Producto {
    private ArrayList<BufferedImage> imagenes;
    private ArrayList<Categoria> categorias;
    private Ciudad origen;
    private Ciudad destino;

    public ArrayList<BufferedImage> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BufferedImage> imagenes) {
        this.imagenes = imagenes;
    }

    public ArrayList<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(ArrayList<Categoria> categorias) {
        this.categorias = categorias;
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
