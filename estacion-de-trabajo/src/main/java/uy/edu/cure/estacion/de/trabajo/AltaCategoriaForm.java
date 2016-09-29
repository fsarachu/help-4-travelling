package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.EstadoCategoria;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class AltaCategoriaForm {
    private JTree tree1;
    private JPanel panelMain;
    private JTextField txtCategoria;
    private JButton btnAgregar;
    private JButton btnCancelar;
    private JButton cmdOcultar;
    private DefaultMutableTreeNode node;
    private DefaultMutableTreeNode hijo;
    private DefaultMutableTreeNode raiz;
    private Categoria padre;

    public AltaCategoriaForm() {
        final LlenarCombobox llenarCombobox = new LlenarCombobox();
        llenarCombobox.cargarTree(raiz, tree1);
        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                node = ((DefaultMutableTreeNode) tree1.getLastSelectedPathComponent());

                if (node.getUserObject() instanceof Categoria) {
                    Categoria categoria = (Categoria) node.getUserObject();
                    padre = categoria;
                    cargarHijos(categoria);
                }

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
                Categoria categoria = new Categoria();
                categoria.setPadre(padre);
                categoria.setNombre(txtCategoria.getText());
                categoria.setHijos(null);
                CategoriaController categoriaController = new CategoriaController();
                categoriaController.nueva(categoria);
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelMain.setVisible(false);
            }
        });
        cmdOcultar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                int dialogButton = JOptionPane.YES_NO_OPTION;
                if (JOptionPane.showConfirmDialog(null, "Existen servicios con esta categoria !!!!", "Atencion",
                        JOptionPane.YES_NO_OPTION) == JOptionPane.YES_OPTION) {
                    CategoriaController categoriaController = new CategoriaController();
                    categoriaController.ocultar(padre);
                }
            }
        });
    }


    private void cargarHijos(Categoria cate) {
        CategoriaController categoriaController = new CategoriaController();

        ArrayList<Categoria> categorias = categoriaController.listarHijos(cate);
        for (Categoria categoria : categorias) {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode();
            hijo.setUserObject(categoria);
            if (categoria.getEstado().equals(EstadoCategoria.visible)) {
                node.add(hijo);
            }
        }
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