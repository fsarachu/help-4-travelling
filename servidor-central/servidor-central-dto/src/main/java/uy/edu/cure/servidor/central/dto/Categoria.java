package uy.edu.cure.servidor.central.dto;


import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.util.ArrayList;
@JsonIdentityInfo(generator=ObjectIdGenerators.IntSequenceGenerator.class, property="@id")
public class Categoria {
    private Integer id;
    private String nombre;
    private Categoria padre;
    private ArrayList<Categoria> hijos;
    private EstadoCategoria estado;
    private String imagen;
    @JsonCreator
    public Categoria() {
        this.hijos = new ArrayList<>();
        this.estado = EstadoCategoria.visible;
    }

    public Categoria(Integer id, String nombre, Categoria padre, ArrayList<Categoria> hijos, EstadoCategoria estado, String imagen) {
        this.id = id;
        this.nombre = nombre;
        this.padre = padre;
        this.hijos = hijos;
        this.estado = estado;
        this.imagen = imagen;
    }

    public String getImagen() {
        return imagen;
    }

    public void setImagen(String imagen) {
        this.imagen = imagen;
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

    public ArrayList<Categoria> getHijos() {
        return hijos;
    }

    public void setHijos(ArrayList<Categoria> hijos) {
        this.hijos = hijos;
    }

    public EstadoCategoria getEstado() {
        return estado;
    }

    public void setEstado(EstadoCategoria estado) {
        this.estado = estado;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
