package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltaCategoria {
    private JTree tree1;
    private JPanel panelMain;
    private JTextField txtCategoria;
    private JButton btnAgregar;
    private JButton btnEliminar;
    private DefaultMutableTreeNode tm;

    public AltaCategoria() {
        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Categorias");
        CategoriaController categoriaController = new CategoriaController();
        ArrayList<Categoria> categorias = categoriaController.listar();
        for (Categoria categoria : categorias) {
            DefaultMutableTreeNode cat = new DefaultMutableTreeNode();
            cat.setUserObject(categoria.getNombre());
            raiz.add(cat);
        }
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        this.tree1.setModel(modelo);
        tree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                TreePath tp = tree1.getSelectionPath();
                tm = (DefaultMutableTreeNode) tp.getLastPathComponent();
            }
        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
                if (nodo != null) {
                    DefaultTreeModel mdl = (DefaultTreeModel) tree1.getModel();
                    mdl.insertNodeInto(new DefaultMutableTreeNode(txtCategoria.getText()), nodo, mdl.getChildCount(nodo));
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
                if (nodo != null) {
                    if (nodo.getLevel() != 0) {
                        DefaultTreeModel mdl = (DefaultTreeModel) tree1.getModel();
                        mdl.removeNodeFromParent(nodo);
                    }
                }
            }
        });
    }

    public JTree getTree1() {
        return tree1;
    }

    public void setTree1(JTree tree1) {
        this.tree1 = tree1;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

}
