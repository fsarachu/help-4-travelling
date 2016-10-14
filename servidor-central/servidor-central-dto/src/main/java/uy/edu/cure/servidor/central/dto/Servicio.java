package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Servicio extends Producto {
    private ArrayList<String> imagenes;
    private Integer idCategorias;
    private ArrayList<Categoria> categorias;
    private Ciudad origen;
    private Ciudad destino;

    public Servicio() {
        this.setTipo(TipoProducto.servicio);
        this.imagenes = new ArrayList<>();
        this.categorias = new ArrayList<>();
    }

    public Servicio(ArrayList<String> imagenes, Integer idCategorias, ArrayList<Categoria> categorias, Ciudad origen, Ciudad destino) {
        this.imagenes = imagenes;
        this.idCategorias = idCategorias;
        this.categorias = categorias;
        this.origen = origen;
        this.destino = destino;
    }

    public ArrayList<String> getImagenes() {
        return imagenes;
    }

    public void setImagenes(ArrayList<String> imagenes) {
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
        String mensaje  = super.getNombre() + " : " + super.getProveedor().getNombre();
        if (this.getOrigen() != null &&  this.getDestino() != null ) {
            mensaje += " Origen: " + this.getOrigen().getNombre() +"   Destino: " + this.getDestino().getNombre();
        }
        return mensaje;
    }
}
