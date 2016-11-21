package uy.edu.cure.estacion.de.trabajo;


import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.RestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.*;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.List;
import java.io.File;
import java.util.*;

public class LlenarCombobox {

    public ComboBoxModel cargarComboCiudad(JComboBox cmb) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/ciudad/listar";
        RestController rest = new RestController();
        ListaCiudades u = rest.doGET(url, ListaCiudades.class);
        ComboBoxModel<Ciudad> mdlCombo = new DefaultComboBoxModel<>(new Vector<Ciudad>(u.getCiudadArrayList()));
        return mdlCombo;
    }

    public ComboBoxModel cargarComboProveedores() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/listar";
        RestController rest = new RestController();
        ListaProveedores u = rest.doGET(url, ListaProveedores.class);
        ComboBoxModel<Proveedor> mdlCombo = new DefaultComboBoxModel<>(new Vector<Proveedor>(u.getProveedorArrayList()));
        return mdlCombo;
    }

    public void cargarTree(DefaultMutableTreeNode root, JTree tree1) {
        root = new DefaultMutableTreeNode("Categorias");
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/categoria/listar";
        RestController rest = new RestController();
        ListaCategorias categorias = rest.doGET(url, ListaCategorias.class);
        for (Categoria categoria : categorias.getCategoriaArrayList()) {
            if (categoria.getPadre() == null) {
                DefaultMutableTreeNode cat = new DefaultMutableTreeNode();
                cat.setUserObject(categoria);
                if (categoria.getEstado().equals(EstadoCategoria.visible)) {
                    root.add(cat);
                }
            }
        }
        DefaultTreeModel modelo = new DefaultTreeModel(root);
        tree1.setModel(modelo);
        tree1.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
    }

    public ComboBoxModel cargarComboServicios() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/listarservicios";
        RestController rest = new RestController();
        ListaServicios servicios = rest.doGET(url, ListaServicios.class);
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicios.getServicioArrayList()));
        return mdlCombo;
    }

    public String seleccionarImagen(JLabel lbl, String txtImagen) {
        JFileChooser fileChooser = new JFileChooser();
        if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
            File archivoElegido = fileChooser.getSelectedFile();
            txtImagen = archivoElegido.getAbsolutePath();
            ImageIcon icon = new ImageIcon(txtImagen);
            Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lbl.getWidth(), lbl.getHeight(), Image.SCALE_DEFAULT));
            lbl.setIcon(icono);
        }
        return txtImagen;
    }

}

