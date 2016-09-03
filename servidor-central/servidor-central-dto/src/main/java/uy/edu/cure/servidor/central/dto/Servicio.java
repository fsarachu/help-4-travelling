package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Servicio extends Producto {
    private ArrayList<BufferedImage> imagenes;
    private ArrayList<Integer> idCategorias;
    private ArrayList<Categoria> categorias;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio() {
        this.imagenes = new ArrayList<>();
        this.idCategorias = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public Servicio(ArrayList<BufferedImage> imagenes, ArrayList<Integer> idCategorias, ArrayList<Categoria> categorias, Ciudad origen, Ciudad destino) {
        this.imagenes = imagenes;
        this.idCategorias = idCategorias;
        this.categorias = categorias;
        this.origen = origen;
        this.destino = destino;
    }

    public ArrayList<BufferedImage> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BufferedImage> imagenes) {
        this.imagenes = imagenes;
    }

    public ArrayList<Integer> getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(ArrayList<Integer> idCategorias) {
        this.idCategorias = idCategorias;
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
