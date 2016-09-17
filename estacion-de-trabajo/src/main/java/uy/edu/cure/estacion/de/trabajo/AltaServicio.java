package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Categoria;
import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.LlenarCombobox;
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
import java.awt.geom.Arc2D;
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
    private JButton btnImagen2;
    private JButton btnImagen3;
    private Integer txtIdCiudadOrigen;
    private Integer txtIdCiudadDestino;
    private String mensaje;
    private Integer txtIDProveedor;
    private DefaultMutableTreeNode categoriaSeleccionada;
    private JFileChooser fileChooser;
    private String txtImagen1;
    private String txtImagen2;
    private String txtImagen3;
    private Integer txtIdCategoria;
    private Categoria padre;
    private DefaultMutableTreeNode raiz;
    private DefaultMutableTreeNode node;

    public AltaServicio() {
        final LlenarCombobox llenarCombobox = new LlenarCombobox();
        cmbCiudadOrigen.setModel(llenarCombobox.cargarComboCiudad(cmbCiudadOrigen));
        cmbCiudadDestino.setModel(llenarCombobox.cargarComboCiudad(cmbCiudadDestino));
        cmbProveedor.setModel(llenarCombobox.cargarComboProveedores());
        cargarCategorias();
        llenarCombobox.cargarTree(raiz, tree1);
        tree1.addTreeSelectionListener(new TreeSelectionListener() {
            @Override
            public void valueChanged(TreeSelectionEvent treeSelectionEvent) {
                node = ((DefaultMutableTreeNode )tree1.getLastSelectedPathComponent());

                if (node.getUserObject() instanceof Categoria) {
                    Categoria categoria = (Categoria) node.getUserObject();
                    txtIdCategoria = categoria.getId();
                    padre = categoria;
                    cargarHijos(categoria);

                }

            }
        });

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
                    if (txtPrecio.getText().isEmpty()) {
                        Double.parseDouble(txtPrecio.getText());
                        txtPrecio.requestFocus();
                        mensaje = "Precio";
                        throw new NumberFormatException();
                    }
                    if (cmbCiudadOrigen.getSelectedItem().equals("")) {
                        mensaje = "Ciudad Origen no seleccionada";
                        throw new EmptyStackException();
                    }
                    if (cmbCiudadDestino.getSelectedItem().equals("")) {
                        cmbCiudadDestino.setSelectedItem(cmbCiudadOrigen.getSelectedItem());
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
                    servicio.setIdCategorias(txtIdCategoria);
                    ArrayList<String> imagenes = new ArrayList<String>();
                    imagenes.add(txtImagen1);
                    imagenes.add(txtImagen2);
                    imagenes.add(txtImagen3);
                    servicio.setImagenes(imagenes);
                    productoController.agregar(servicio);

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (NumberFormatException e) {
                    JOptionPane.showMessageDialog(null,"El precio es incorrecto","Atencion",JOptionPane.ERROR_MESSAGE);
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
                txtImagen1 = llenarCombobox.seleccionarImagen(lblImagen1, txtImagen1);
            }
        });
        btnImagen2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtImagen2 = llenarCombobox.seleccionarImagen(lblImagen2, txtImagen2);
            }
        });
        btnImagen3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                txtImagen3 = llenarCombobox.seleccionarImagen(lblImagen3, txtImagen3);
            }
        });
    }


    private void cargarHijos(Categoria cate) {
        CategoriaController categoriaController = new CategoriaController();

        ArrayList<Categoria> categorias = categoriaController.listarHijos(cate);
        for (Categoria categoria : categorias) {
            DefaultMutableTreeNode hijo = new DefaultMutableTreeNode();
            hijo.setUserObject(categoria);
            node.add(hijo);
        }
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
