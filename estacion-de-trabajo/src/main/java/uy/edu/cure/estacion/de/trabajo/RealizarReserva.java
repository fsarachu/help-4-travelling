package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.CarritoController;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import javax.xml.soap.Text;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.EmptyStackException;
import java.util.Vector;

public class RealizarReserva {
    private JTextField txtPrecioTotal;
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
    private JLabel precioTotal;
    private String mensaje;
    private Carrito carrito;
    private Cliente cliente;
    private Producto producto;

    public RealizarReserva() {
        new Hardcodeo();
        Date hoy = new Date();

        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaInicio.setText(formatter.format(hoy));
        txtFechaFin.setText(formatter.format(hoy));

        cargaComboCliente();

        servicioRadioButton.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (servicioRadioButton.isSelected()) {
                    cargarComboServicio();

                } else { if (promocionRadioButton.isSelected()){
                        cargarComboPromocion();
                    }
                }
            }
        });

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    if( servicioRadioButton.isSelected() == true){
                        //agregar servicio
                    } else if( promocionRadioButton.isSelected() == true){
                        //agregar promocion
                    }else {
                        mensaje = "Servicio o Promocion";
                        throw new EmptyStackException();
                    }
                    if (jcbPromoServicio.getSelectedItem().equals("")){
                        jcbPromoServicio.requestFocus();
                        mensaje = "Servicio o Promocion";
                    }
                    if (jcbCliente.getSelectedItem().equals("")) {
                        jcbCliente.requestFocus();
                        mensaje = "Cliente";
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

                    cliente = (Cliente) jcbCliente.getSelectedItem();
                    carrito =  cliente.getCarrito();

                    if(carrito == null){
                        throw new EmptyStackException();
                    }
                    ItemReserva item = new ItemReserva();
                    item.setCarrito( carrito );
                    item.setCantidad( (Integer.parseInt( txtCantidadServicio.getText() )) );
                    item.setFechaInicio( formatter.parse( getTxtFechaInicio().getText() ) );
                    item.setFechaFin( formatter.parse( getTxtFechaFin().getText() ) );
                    item.setProducto( producto );
                    item.setSubTotal( item.getCantidad() );//* producto.getPrecio() );
                    CarritoController carritofinal = new CarritoController();
                    carritofinal.agregarItem( item, carrito);

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog( null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE );
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog( null, "Verifique la información ingresada. " + e.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE );
                }
            }

        });

        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jcbCliente.getSelectedItem().equals("")) {
                        jcbCliente.requestFocus();
                        mensaje = "Cliente";
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
                    
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }

            }

        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PanelAltaReserva.setVisible(false);
            }
        });

        jcbCliente.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                cliente = (Cliente) jcbCliente.getSelectedItem();
                carrito = cliente.getCarrito();
            }
        });
        jcbPromoServicio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent e) {
                producto = (Producto) jcbPromoServicio.getSelectedItem();
            }
        });
    }

    private void cargarComboPromocion() {
        ProductoController productoController = new ProductoController();
        ArrayList<Promocion> promociones = productoController.listarPromociones();
        ComboBoxModel<Promocion> mdlCombo = new DefaultComboBoxModel<>(new Vector<Promocion>(promociones));
        jcbPromoServicio.setModel(mdlCombo);
    }

    private void cargarComboServicio () {
        ProductoController productoController = new ProductoController();
        ArrayList<Servicio> servicio = productoController.listarServicios();
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicio));
        jcbPromoServicio.setModel(mdlCombo);
    }

    private void cargaComboCliente () {
        ClienteController clientecontroller = new ClienteController();
        ArrayList<Cliente> clientes = clientecontroller.listar();
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientes));
        jcbCliente.setModel(mdlCombo);
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

    public JComboBox getJcbCliente() {
        return jcbCliente;
    }

    public void setJcbCliente(JComboBox jcbCliente) {
        this.jcbCliente = jcbCliente;
    }

    public JPanel getPanelAltaReserva() {
        return PanelAltaReserva;
    }

    public void setPanelAltaReserva(JPanel panelAltaReserva) {
        PanelAltaReserva = panelAltaReserva;
    }
}