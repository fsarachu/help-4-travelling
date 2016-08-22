package uy.edu.cure.servidor.central.dto;

import java.awt.image.BufferedImage;
import java.util.ArrayList;

public class Servicio {
    private String nombre;
    private String descripcion;
    private double precio;
    private ArrayList<BufferedImage> imagenes;
    private ArrayList<Categoria> categorias;
    private ArrayList<Ciudad> ciudades;

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

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

    public ArrayList<Ciudad> getCiudades() {
        return ciudades;
    }

    public void setCiudades(ArrayList<Ciudad> ciudades) {
        this.ciudades = ciudades;
    }
}
