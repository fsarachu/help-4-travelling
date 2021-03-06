package uy.edu.cure.servidor.web;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaCategorias;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@ManagedBean
@SessionScoped
public class CategoriaBean implements Serializable {
    private Categoria categoria;
    private Categoria padre;
    private List<Categoria> listCategorias = new ArrayList<Categoria>();


    public CategoriaBean() { cargarCategorias(); }

    private void cargarCategorias() {
        listCategorias = listarRest();
    }

    public ArrayList<Categoria> listarRest(){
            String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/listar/";
            RestController rest = new RestController();
            ListaCategorias u = rest.doGET(url, ListaCategorias.class);
            return u.getCategoriaArrayList();
    }

    public void retornoCategorias(Integer id){

    }
    public Categoria getPadre() {
        return padre;
    }

    public void setPadre(Categoria padre) {
        this.padre = padre;
    }

    public Categoria getCategoria() {
        if (categoria == null) {
            categoria = new Categoria();
        }
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public List<Categoria> getListCategorias() {
        return listCategorias;
    }

    public void setListCategorias(List<Categoria> listCategorias) {
        this.listCategorias = listCategorias;
    }

}

