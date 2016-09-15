package uy.edu.cure.servidor.central.dto;


import java.util.ArrayList;

public class Categoria {
    private Integer id;
    private String nombre;
    private Integer padre;
    private ArrayList<Categoria> hijos;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, Integer padre, ArrayList<Categoria> hijos) {
        this.id = id;
        this.nombre = nombre;
        this.padre = padre;
        this.hijos = hijos;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public Integer getPadre() {
        return padre;
    }

    public void setPadre(Integer padre) {
        this.padre = padre;
    }

    public ArrayList<Categoria> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Categoria> hijos) {
        this.hijos = hijos;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
