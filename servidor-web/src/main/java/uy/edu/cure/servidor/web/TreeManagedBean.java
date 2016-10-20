package uy.edu.cure.servidor.web;

import org.primefaces.event.NodeSelectEvent;
import org.primefaces.model.DefaultTreeNode;
import org.primefaces.model.TreeNode;
import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.swing.*;
import java.util.ArrayList;
import java.util.List;


@ManagedBean
@SessionScoped


public class TreeManagedBean {
    private TreeNode singleSelectedTreeNode;
    private TreeNode onNodeSelect;
    private List<Categoria> categorias = new ArrayList<>();
    private TreeNode root;
    private Integer contador = 1;
    private List<TreeNode> list = new ArrayList<TreeNode>();



    public TreeManagedBean() {
        root = new DefaultTreeNode("Root", null);
        CategoriaController categoriacontroller = new CategoriaController();
        Categoria categoria = new Categoria();
        categoria.setId(1);
        for (int i = 1; i <= categoriacontroller.listar().size(); i++) {
            TreeNode nodo = new DefaultTreeNode();
            list.add(nodo);
        }
        construirArbol(categoria, root);
    }

    public void construirArbol(Categoria cate, TreeNode arbol) {
        CategoriaController categoriaController = new CategoriaController();
        Categoria categoria = categoriaController.obtener(contador);
        if (contador <= categoriaController.listar().size() && categoria != null) {
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

    public void buscoNodo(TreeNode nodo) {
        Integer cuento = 0;
        if (nodo != null) {
            for (int i = 0; i < list.size(); i++) {
                cuento++;
                if (nodo == list.get(i)) {
                    JOptionPane.showMessageDialog(null, cuento, "Atencion", JOptionPane.ERROR_MESSAGE);
                }
            }
        }
    }
    private void createNode(Object tag, TreeNode parent) {
        TreeNode node = new DefaultTreeNode(tag, parent);
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

    public Integer getContador() {
        return contador;
    }

    public void setContador(Integer contador) {
        this.contador = contador;
    }

    public List<TreeNode> getList() {
        return list;
    }

    public void setList(List<TreeNode> list) {
        this.list = list;
    }

    public TreeNode getSingleSelectedTreeNode() {
        return singleSelectedTreeNode;
    }

    public void setSingleSelectedTreeNode(TreeNode singleSelectedTreeNode) {
        buscoNodo(singleSelectedTreeNode);
        this.singleSelectedTreeNode = singleSelectedTreeNode;
    }

    public TreeNode getOnNodeSelect() {
        return onNodeSelect;
    }

    public void setOnNodeSelect(TreeNode onNodeSelect) {
        this.onNodeSelect = onNodeSelect;
    }
}
