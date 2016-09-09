package uy.edu.cure.servidor.central.dto;

import java.util.ArrayList;

public class Categoria {
    private Integer id;
    private String nombre;
    private Categoria padre;
    private ArrayList<Integer> idHijos;
    private ArrayList<Categoria> hijos;

    public Categoria() {
    }

    public Categoria(Integer id, String nombre, Categoria padre, ArrayList<Integer> idHijos, ArrayList<Categoria> hijos) {
        this.id = id;
        this.nombre = nombre;
        this.padre = padre;
        this.idHijos = idHijos;
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

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public ArrayList<Integer> getIdHijos() {
        return idHijos;
    }

    public ArrayList<Categoria> getHijos() {
        return hijos;
    }

}
