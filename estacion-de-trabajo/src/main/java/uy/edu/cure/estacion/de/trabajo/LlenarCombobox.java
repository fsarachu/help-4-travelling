package uy.edu.cure.estacion.de.trabajo;


import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.CategoriaRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.CiudadRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ProductoRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ProveedorRestController;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;

public class LlenarCombobox {

    public ComboBoxModel cargarComboCiudad(JComboBox cmb) {
        CiudadRestController ciudadController = new CiudadRestController();
        List<Ciudad> ciudades = ciudadController.listar();
        ComboBoxModel<Ciudad> mdlCombo = new DefaultComboBoxModel<>(new Vector<Ciudad>(ciudades));
        return mdlCombo;
    }

    public ComboBoxModel cargarComboProveedores() {
        ProveedorRestController proveedorController = new ProveedorRestController();
        List<Proveedor> proveedores = proveedorController.listar();
        ComboBoxModel<Proveedor> mdlCombo = new DefaultComboBoxModel<>(new Vector<Proveedor>(proveedores));
        return mdlCombo;
    }

    public void cargarTree(DefaultMutableTreeNode root, JTree tree1) {
        root = new DefaultMutableTreeNode("Categorias");
        CategoriaRestController categoriaController = new CategoriaRestController();
        ArrayList<Categoria> categorias = categoriaController.listar();
        for (Categoria categoria : categorias) {
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
        ProductoRestController productoController = new ProductoRestController();
        java.util.List<Servicio> servicios = productoController.listarServicios();
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicios));
        return mdlCombo;
    }

    public String seleccionarImagen(JLabel lbl,String txtImagen) {
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

