package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Categoria {
    private Integer id;
    private String nombre;
    private Categoria padre;
    private ArrayList<Categoria> hijos;

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

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public ArrayList<Categoria> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Categoria> hijos) {
        this.hijos = hijos;
    }
}
