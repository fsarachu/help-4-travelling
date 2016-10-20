package uy.edu.cure.servidor.web;

import org.primefaces.event.NodeExpandEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@SessionScoped
public class TreeManagedBean {
    private List<Categoria> categorias = new ArrayList<>();
    private TreeNode root;

    @PostConstruct
    public void buildTree() {
        root = new DefaultTreeNode("Root", null);

        CategoriaController categoriaController = new CategoriaController();
        ArrayList<Categoria> categorias = categoriaController.listar();
        for (Categoria categoria : categorias) {
            if (categoria.getPadre() == null) {
                recu(categoria, root);
            }
        }
    }
    private void recu(Categoria categoria, TreeNode father){
        TreeNode node = new DefaultTreeNode(categoria, father);
        ArrayList<Categoria> categorias = categoria.getHijos();
        for (Categoria categ : categorias) {
            recu(categ, node);
        }
    }

    public TreeManagedBean() {
    }


    private void createNode(Object tag, TreeNode parent) {
        TreeNode node = new DefaultTreeNode(tag, parent);
        //new DefaultTreeNode("hola", node);
        //new DefaultTreeNode("chau", node);
    }


    public TreeNode getRoot() {
        return root;
    }

    public void setRoot(TreeNode root) {
        this.root = root;
    }

    public List<Categoria> getCategorias() {
        return categorias;
    }

    public void setCategorias(List<Categoria> categorias) {
        this.categorias = categorias;
    }

}