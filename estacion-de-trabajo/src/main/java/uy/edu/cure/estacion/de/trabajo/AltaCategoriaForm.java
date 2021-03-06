package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.EstadoCategoria;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaCategorias;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

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
        tree1.addTreeSelectionListener(treeSelectionEvent -> {
            node = ((DefaultMutableTreeNode) tree1.getLastSelectedPathComponent());
            if (node.getUserObject() instanceof Categoria) {
                Categoria categoria = (Categoria) node.getUserObject();
                padre = categoria;
                cargarHijos(categoria);
            }

        });

        btnAgregar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    String url = "http://localhost:8080/servidor-central-webapp/rest/api/errores/validatorCategoria/"+txtCategoria;
                    RestController rest = new RestController();
                    boolean log = rest.doPUT(url, padre , boolean.class);
                    if(!log) {
                        throw new IllegalArgumentException("La categoria ya existe");
                    }
                    DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) tree1.getLastSelectedPathComponent();
                    if (nodo != null) {
                        DefaultTreeModel mdl = (DefaultTreeModel) tree1.getModel();
                        mdl.insertNodeInto(new DefaultMutableTreeNode(txtCategoria.getText()), nodo, mdl.getChildCount(nodo));
                    }
                    Categoria categoria = new Categoria();
                    categoria.setPadre(padre);
                    categoria.setNombre(txtCategoria.getText());
                    categoria.setHijos(null);
                    url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/nueva";
                    rest = new RestController();
                    log = rest.doPUT(url, categoria , boolean.class);
                } catch (IllegalArgumentException e){
                    JOptionPane.showMessageDialog(null,"La categoria ya existe","Atencion",JOptionPane.ERROR_MESSAGE);
                }
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
                    String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/ocultar";
                    RestController rest = new RestController();
                    boolean log = rest.doPUT(url, padre , boolean.class);
                }
            }
        });
    }


    private void cargarHijos(Categoria cate) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/listarhijos";
        RestController rest = new RestController();
        ListaCategorias log = rest.doPUT(url, cate , ListaCategorias.class);
        ArrayList<Categoria> categorias = log.getCategoriaArrayList();
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
