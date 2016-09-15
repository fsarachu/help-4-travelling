package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.CategoriaController;
import uy.edu.cure.servidor.central.lib.controllers.CiudadController;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.File;
import java.net.URL;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.List;
import java.util.Vector;

public class AltaServicio {
    private JPanel panelServicio;
    private JTextField txtNombre;
    private JTextField txtDescripcion;
    private JTextField txtPrecio;
    private JComboBox cmbCiudadDestino;
    private JComboBox cmbProveedor;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JTree tree1;
    private JComboBox cmbCiudadOrigen;
    private JLabel lblImagen1;
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    private JButton btnImagen1;
    private JButton button2;
    private JButton button3;
    private Integer txtIdCiudadOrigen;
    private Integer txtIdCiudadDestino;
    private String mensaje;
    private Integer txtIDProveedor;
    private DefaultMutableTreeNode categoriaSeleccionada;
    private JFileChooser fileChooser;
    private String txtImagen1;
    private String txtImagen2;
    private String txtImagen3;


    public AltaServicio() {
        cargarComboCiudad(cmbCiudadOrigen);
        cargarComboCiudad(cmbCiudadDestino);
        cargarComboProveedores();
        cargarCategorias();
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (txtNombre.getText().equals("")) {
                        txtNombre.requestFocus();
                        mensaje = "Nombre";
                        throw new EmptyStackException();
                    }
                    if (txtDescripcion.getText().equals("")) {
                        txtDescripcion.requestFocus();
                        mensaje = "Descripcion";
                        throw new EmptyStackException();
                    }
                    if (txtPrecio.getText().equals("")) {
                        txtPrecio.requestFocus();
                        mensaje = "Precio";
                        throw new EmptyStackException();
                    }
                    if (cmbCiudadOrigen.getSelectedItem().equals("")) {
                        mensaje = "Ciudad Origen no seleccionada";
                        throw new EmptyStackException();
                    }
                    if (cmbCiudadDestino.getSelectedItem().equals("")) {
                        mensaje = "Ciudad Destino no seleccionada";
                        throw new EmptyStackException();
                    }
                    if (cmbProveedor.getSelectedItem().equals("")) {
                        mensaje = "Proveedor no seleccionado";
                        throw new EmptyStackException();
                    }
                    ProductoController productoController = new ProductoController();
                    Servicio servicio = new Servicio();
                    servicio.setNombre(txtNombre.getText());
                    servicio.setDescripcion(txtDescripcion.getText());
                    double aDouble = Double.parseDouble(txtPrecio.getText());
                    servicio.setPrecio(aDouble);
                    Ciudad ciudad = new Ciudad();
                    ciudad.setId(cmbCiudadOrigen.getSelectedIndex());
                    servicio.setOrigen(ciudad);
                    Ciudad ciudad1 = new Ciudad();
                    ciudad1.setId(cmbCiudadDestino.getSelectedIndex());
                    servicio.setDestino(ciudad1);
                    //Integer idcategoria = Integer.parseInt(categoriaSeleccionada.toString());
                    servicio.setIdCategorias(1);
                    productoController.agregar(servicio);

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }
            }
        });
        cmbCiudadOrigen.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Ciudad ciudadOrigen = (Ciudad) cmbCiudadOrigen.getSelectedItem();
                txtIdCiudadOrigen = ciudadOrigen.getId();
            }
        });
        cmbCiudadDestino.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Ciudad ciudadDestino = (Ciudad) cmbCiudadDestino.getSelectedItem();
                txtIdCiudadDestino = ciudadDestino.getId();
            }
        });
        cmbProveedor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Proveedor proveedor = (Proveedor) cmbProveedor.getSelectedItem();
                txtIDProveedor = proveedor.getId();
            }
        });
        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                TreePath tp = tree1.getSelectionPath();
                categoriaSeleccionada = (DefaultMutableTreeNode) tp.getLastPathComponent();
            }
        });
        btnCancelar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelServicio.setVisible(false);
            }
        });
        btnImagen1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File archivoElegido = fileChooser.getSelectedFile();
                    txtImagen1 = archivoElegido.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, txtImagen1, "Atencion", JOptionPane.ERROR_MESSAGE);
                    String path = txtImagen1;
                    URL url = this.getClass().getResource(path);
                    ImageIcon icon = new ImageIcon(url);
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen1.getWidth(), lblImagen1.getHeight(), Image.SCALE_DEFAULT));
                    lblImagen1.setIcon(icono);

                }
            }
        });
    }


    private void cargarComboCiudad(JComboBox cmb) {
        CiudadController ciudadController = new CiudadController();
        List<Ciudad> ciudades = ciudadController.listar();
        ComboBoxModel<Ciudad> mdlCombo = new DefaultComboBoxModel<>(new Vector<Ciudad>(ciudades));
        cmb.setModel(mdlCombo);
    }

    private void cargarComboProveedores() {
        ProveedorController proveedorController = new ProveedorController();
        List<Proveedor> proveedores = proveedorController.listar();
        ComboBoxModel<Proveedor> mdlCombo = new DefaultComboBoxModel<>(new Vector<Proveedor>(proveedores));
        cmbProveedor.setModel(mdlCombo);
    }

    private void cargarCategorias() {
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
    }

    public JPanel getPanelServicio() {
        return panelServicio;
    }

    public void setPanelServicio(JPanel panelServicio) {
        this.panelServicio = panelServicio;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JTextField txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JTextField txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JComboBox getCmbCiudadDestino() {
        return cmbCiudadDestino;
    }

    public void setCmbCiudadDestino(JComboBox cmbCiudadDestino) {
        this.cmbCiudadDestino = cmbCiudadDestino;
    }

    public JComboBox getCmbProveedor() {
        return cmbProveedor;
    }

    public void setCmbProveedor(JComboBox cmbProveedor) {
        this.cmbProveedor = cmbProveedor;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JTree getTree1() {
        return tree1;
    }

    public void setTree1(JTree tree1) {
        this.tree1 = tree1;
    }

    public JComboBox getCmbCiudadOrigen() {
        return cmbCiudadOrigen;
    }

    public void setCmbCiudadOrigen(JComboBox cmbCiudadOrigen) {
        this.cmbCiudadOrigen = cmbCiudadOrigen;
    }

    public Integer getTxtIdCiudadOrigen() {
        return txtIdCiudadOrigen;
    }

    public void setTxtIdCiudadOrigen(Integer txtIdCiudadOrigen) {
        this.txtIdCiudadOrigen = txtIdCiudadOrigen;
    }

    public Integer getTxtIdCiudadDestino() {
        return txtIdCiudadDestino;
    }

    public void setTxtIdCiudadDestino(Integer txtIdCiudadDestino) {
        this.txtIdCiudadDestino = txtIdCiudadDestino;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }
}
