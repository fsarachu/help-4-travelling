package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

public class RealizarReserva {
    private JTextField txtCantidadServicio;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JButton agregarButton;
    private JButton mostrarDatosButton;
    private JButton cancelarButton;
    private JComboBox jcbPromoServicio;
    private JPanel PanelAltaReserva;
    private JComboBox jcbCliente;
    private JRadioButton servicioRadioButton;
    private JRadioButton promocionRadioButton;
    private JList<ItemReserva> listReservas;
    private JButton btnAceptar;
    private JTextField txtPrecioTotal;
    private DefaultListModel mdllista;
    private String mensaje;
    private Carrito carrito;
    private Cliente cliente;
    private Producto producto;

    public RealizarReserva() {
        Date hoy = new Date();

        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaInicio.setText(formatter.format(hoy));
        txtFechaFin.setText(formatter.format(hoy));

        cargaComboCliente();

        servicioRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (servicioRadioButton.isSelected() == true) {
                    cargarComboServicio();
                }
            }
        });
        promocionRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (promocionRadioButton.isSelected() == true) {
                    cargarComboPromocion();
                }
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    if (jcbCliente.getSelectedItem().equals(-1)) {
                        jcbCliente.requestFocus();
                        mensaje = "Seleccione Cliente";
                        throw new EmptyStackException();
                    }
                    if (servicioRadioButton.isSelected() == promocionRadioButton.isSelected()) {
                        mensaje = "Servicio o Promocion";
                        throw new EmptyStackException();
                    }
                    if (txtCantidadServicio.getText().equals("")) {
                        txtCantidadServicio.requestFocus();
                        mensaje = "Cantidad Servicio";
                        throw new EmptyStackException();
                    }
                    if (txtFechaFin.getText().equals("")) {
                        txtFechaFin.requestFocus();
                        mensaje = "Fecha de Fin";
                        throw new EmptyStackException();
                    }
                    if (txtFechaInicio.getText().equals("")) {
                        txtFechaInicio.requestFocus();
                        mensaje = "Fecha de Inicio";
                        throw new EmptyStackException();
                    }
                    if (carrito == null) {
                        jcbCliente.requestFocus();
                        mensaje = "Debe elegir un Cliente";
                        throw new EmptyStackException();
                    }
                    ItemReserva item = new ItemReserva();
                    item.setCarrito(carrito);
                    item.setCantidad((Integer.parseInt(txtCantidadServicio.getText())));
                    item.setFechaInicio(formatter.parse(getTxtFechaInicio().getText()));
                    item.setFechaFin(formatter.parse(getTxtFechaFin().getText()));
                    item.setProducto(producto);
                    item.setSubTotal(item.getCantidad());
                    CarritoController carritofinal = new CarritoController();
                    carritofinal.agregarItem(item, item.getCarrito());
                    mostrarListaReservas();

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Verifique la información ingresada. " + e.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }
            }

        });

        listReservas.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getClickCount() == 2) {
                    int index = listReservas.getSelectedIndex();
                    CarritoController carritoController = new CarritoController();
                    carritoController.eliminarItem(listReservas.getSelectedValue());
                    mdllista.removeElementAt(index);
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PanelAltaReserva.setVisible(false);
            }
        });

        jcbPromoServicio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                producto = (Producto) jcbPromoServicio.getSelectedItem();
            }
        });

        jcbCliente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (itemEvent.getStateChange() == 1) {
                    cliente = (Cliente) jcbCliente.getSelectedItem();
                    carrito = cliente.getCarrito();
                    mostrarListaReservas();
                }
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                ReservaController reservaController = new ReservaController();
                reservaController.nueva(cliente);
                JOptionPane.showMessageDialog(null,"Reserva realizada con exito","Atencion",JOptionPane.INFORMATION_MESSAGE);
                PanelAltaReserva.setVisible(false);
            }
        });
    }

    private void cargarComboPromocion() {
        ProductoController productoController = new ProductoController();
        ArrayList<Promocion> promociones = productoController.listarPromociones();
        ComboBoxModel<Promocion> mdlCombo = new DefaultComboBoxModel<>(new Vector<Promocion>(promociones));
        jcbPromoServicio.setModel(mdlCombo);
    }

    private void cargarComboServicio() {
        ProductoController productoController = new ProductoController();
        ArrayList<Servicio> servicio = productoController.listarServicios();
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicio));
        jcbPromoServicio.setModel(mdlCombo);
    }

    private void cargaComboCliente() {
        ClienteController clientecontroller = new ClienteController();
        ArrayList<Cliente> clientes = clientecontroller.listar();
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientes));
        jcbCliente.setModel(mdlCombo);
    }

    private void mostrarListaReservas() {
        mdllista = new DefaultListModel();
        listReservas.setModel(mdllista);
        List<ItemReserva> carritoItems = carrito.getItems();
        for (ItemReserva itemReserva : carritoItems) {
            mdllista.addElement(itemReserva);
        }
    }

    public JTextField getTxtPrecioTotal() {
        return txtPrecioTotal;
    }

    public void setTxtPrecioTotal(JTextField txtPrecioTotal) {
        this.txtPrecioTotal = txtPrecioTotal;
    }

    public JTextField getTxtCantidadServicio() {
        return txtCantidadServicio;
    }

    public void setTxtCantidadServicio(JTextField txtCantidadServicio) {
        this.txtCantidadServicio = txtCantidadServicio;
    }

    public JTextField getTxtFechaInicio() {
        return txtFechaInicio;
    }

    public void setTxtFechaInicio(JTextField txtFechaInicio) {
        this.txtFechaInicio = txtFechaInicio;
    }

    public JTextField getTxtFechaFin() {
        return txtFechaFin;
    }

    public void setTxtFechaFin(JTextField txtFechaFin) {
        this.txtFechaFin = txtFechaFin;
    }

    public JButton getAgregarButton() {
        return agregarButton;
    }

    public void setAgregarButton(JButton agregarButton) {
        this.agregarButton = agregarButton;
    }

    public JButton getMostrarDatosButton() {
        return mostrarDatosButton;
    }

    public void setMostrarDatosButton(JButton mostrarDatosButton) {
        this.mostrarDatosButton = mostrarDatosButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }

    public JComboBox getJcbPromoServicio() {
        return jcbPromoServicio;
    }

    public void setJcbPromoServicio(JComboBox jcbPromoServicio) {
        this.jcbPromoServicio = jcbPromoServicio;
    }

    public JPanel getPanelAltaReserva() {
        return PanelAltaReserva;
    }

    public void setPanelAltaReserva(JPanel panelAltaReserva) {
        PanelAltaReserva = panelAltaReserva;
    }

    public JComboBox getJcbCliente() {
        return jcbCliente;
    }

    public void setJcbCliente(JComboBox jcbCliente) {
        this.jcbCliente = jcbCliente;
    }

    public JRadioButton getServicioRadioButton() {
        return servicioRadioButton;
    }

    public void setServicioRadioButton(JRadioButton servicioRadioButton) {
        this.servicioRadioButton = servicioRadioButton;
    }

    public JRadioButton getPromocionRadioButton() {
        return promocionRadioButton;
    }

    public void setPromocionRadioButton(JRadioButton promocionRadioButton) {
        this.promocionRadioButton = promocionRadioButton;
    }

    public JList<ItemReserva> getListReservas() {
        return listReservas;
    }

    public void setListReservas(JList<ItemReserva> listReservas) {
        this.listReservas = listReservas;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public DefaultListModel getMdllista() {
        return mdllista;
    }

    public void setMdllista(DefaultListModel mdllista) {
        this.mdllista = mdllista;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String mensaje) {
        this.mensaje = mensaje;
    }

    public Carrito getCarrito() {
        return carrito;
    }

    public void setCarrito(Carrito carrito) {
        this.carrito = carrito;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Producto getProducto() {
        return producto;
    }

    public void setProducto(Producto producto) {
        this.producto = producto;
    }
}