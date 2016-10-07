package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable {
    private Categoria padre;


    public ArrayList<Categoria> cargarCategorias() {
        CategoriaController categoriaController = new CategoriaController();
        ArrayList<Categoria> categorias = categoriaController.listar();
        /*for (Categoria categoria : categorias) {
            if (categoria.equals(padre)) {
                cate = padre;
            }
        }*/
        return categorias;
    }

    public CategoriaBean() {
    }

    public CategoriaBean(Categoria padre) {
        this.padre = padre;
    }

    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }
}
