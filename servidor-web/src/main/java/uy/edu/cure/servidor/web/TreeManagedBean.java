package uy.edu.cure.servidor.web;

import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaCategorias;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@SessionScoped


public class TreeManagedBean {
    private TreeNode onNodeSelect;
    private TreeNode root;
    private Integer contador = 1;
    private List<TreeNode> list = new ArrayList<TreeNode>();



    public TreeManagedBean() {
        root = new DefaultTreeNode("Root", null);
        Categoria categoria = new Categoria();
        categoria.setId(1);
        for (int i = 1; i <= listarRest().size(); i++) {
            TreeNode nodo = new DefaultTreeNode();
            list.add(nodo);
        }
        construirArbol(categoria, root);
    }

    public ArrayList<Categoria> listarRest(){
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/listar/";
        RestController rest = new RestController();
        ListaCategorias u = rest.doGET(url, ListaCategorias.class);
        return u.getCategoriaArrayList();
    }

    public Categoria obtenerRest(Integer categoria) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/obtener/"+categoria;
        RestController rest = new RestController();
        Categoria u = rest.doGET(url, Categoria.class);
        return u;
    }



    public void construirArbol(Categoria cate, TreeNode arbol) {
        Categoria categoria = obtenerRest(contador);
        if (contador <= listarRest().size() && categoria != null) {
            contador++;
            if (categoria.getPadre() == null) {
                TreeNode rama = new DefaultTreeNode(categoria, root);
                for (int i = 0; i < list.size(); i++) {
                    if (i == categoria.getId()) {
                        list.set(i, rama);
                    }
                }
                construirArbol(categoria, rama);
            } else {
                for (int i = 0; i < list.size(); i++) {
                    if (i == categoria.getPadre().getId()) {
                        arbol = list.get(i);
                    }
                }
                TreeNode rama = new DefaultTreeNode(categoria, arbol);
                for (int i = 0; i < list.size(); i++) {
                    if (i == categoria.getId()) {
                        list.set(i, rama);
                    }
                }
                construirArbol(categoria, rama);
            }
        }
    }

    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public TreeNode getOnNodeSelect() {
        return onNodeSelect;
    }

    public void setOnNodeSelect(TreeNode onNodeSelect) {
        this.onNodeSelect = onNodeSelect;
    }

}
