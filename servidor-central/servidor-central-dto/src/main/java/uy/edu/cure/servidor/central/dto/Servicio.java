package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Servicio extends Producto {
    private ArrayList<BufferedImage> imagenes;
    private Integer idCategorias;
    private ArrayList<Categoria> categorias;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio() {
        this.setTipo(TipoProducto.servicio);
        this.imagenes = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public ArrayList<BufferedImage> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<BufferedImage> imagenes) {
        this.imagenes = imagenes;
    }

    public Integer getIdCategorias() {
        return idCategorias;
    }

    public void setIdCategorias(Integer idCategorias) {
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

    @Override
    public String toString() {
        return super.getNombre();
    }
}
