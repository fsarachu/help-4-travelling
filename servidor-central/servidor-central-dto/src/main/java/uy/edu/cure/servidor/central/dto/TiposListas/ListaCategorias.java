package uy.edu.cure.servidor.central.dto.TiposListas;

import uy.edu.cure.servidor.central.dto.Categoria;

import java.util.ArrayList;

/**
 * Created by victor on 18/11/16.
 */
public class ListaCategorias {
    private ArrayList<Categoria> categoriaArrayList;

    public ListaCategorias() {
    }

    public ArrayList<Categoria> getCategoriaArrayList() {
        return categoriaArrayList;
    }

    public void setCategoriaArrayList(ArrayList<Categoria> categoriaArrayList) {
        this.categoriaArrayList = categoriaArrayList;
    }
}
