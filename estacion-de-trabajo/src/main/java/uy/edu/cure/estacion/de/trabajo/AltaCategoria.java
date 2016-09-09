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

public  class AltaCategoria {
    private JTree tree1;
    private JPanel panelMain;
    private JTextField txtCategoria;
    private JButton btnAgregar;
    private JButton btnEliminar;

    public AltaCategoria() {

        DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("raiz");
        CategoriaController categoriaController = new CategoriaController();
        ArrayList<Categoria> categorias =  categoriaController.listar();
        for (Categoria categoria : categorias) {
            DefaultMutableTreeNode cat = new DefaultMutableTreeNode();
            cat.setUserObject(categoria);
            raiz.add(cat);
        }
        DefaultTreeModel modelo = new DefaultTreeModel(raiz);
        this.tree1.setModel(modelo);
        tree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);

        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                TreePath tp = tree1.getSelectionPath();
                DefaultMutableTreeNode tm = (DefaultMutableTreeNode)tp.getLastPathComponent();
                JOptionPane.showMessageDialog(null, tm.getUserObject().toString(),"Mensaje",JOptionPane.ERROR_MESSAGE);
            }
        });


        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)tree1.getLastSelectedPathComponent();
                if (nodo != null) {
                    DefaultTreeModel mdl = (DefaultTreeModel)tree1.getModel();
                    mdl.insertNodeInto(new DefaultMutableTreeNode(txtCategoria.getText()),nodo , mdl.getChildCount(nodo));
                }
            }
        });
        btnEliminar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                DefaultMutableTreeNode nodo = (DefaultMutableTreeNode)tree1.getLastSelectedPathComponent();
                if (nodo != null) {
                    if (nodo.getLevel() != 0) {
                        DefaultTreeModel mdl = (DefaultTreeModel)tree1.getModel();
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
/*public class AltaCategoria {
    private DefaultMutableTreeNode modelo ;
    private DefaultMutableTreeNode categorias ;
    private JTree tree ;
    private JLabel lblCategoria;
    private JTextField txtCategoria;

    public AltaCategoria(){
        DefaultMutableTreeNode categorias = new DefaultMutableTreeNode("categorias");
        DefaultTreeModel modelo = new DefaultTreeModel(categorias);
        JTree tree = new JTree(modelo);
        JLabel lblCategoria = new JLabel();
        JTextField txtCategoria = new JTextField();
        lblCategoria.setText("Categoria");

    }


    public AltaCategoria(DefaultMutableTreeNode modelo, DefaultMutableTreeNode categorias) {
        this.modelo = modelo;
        this.categorias = categorias;
    }

    public DefaultMutableTreeNode getModelo() {
        return modelo;
    }

    public void setModelo(DefaultMutableTreeNode modelo) {
        this.modelo = modelo;
    }

    public DefaultMutableTreeNode getCategorias() {
        return categorias;
    }

    public void setCategorias(DefaultMutableTreeNode categorias) {
        this.categorias = categorias;
    }

    public JTree getTree() {
        return tree;
    }

    public void setTree(JTree tree) {
        this.tree = tree;
    }
}*/
