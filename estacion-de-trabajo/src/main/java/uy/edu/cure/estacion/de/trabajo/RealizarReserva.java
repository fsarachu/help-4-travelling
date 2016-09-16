package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.lib.servicios.ReservaService;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Vector;

public class RealizarReserva {
    private JTextField txtPrecioTotal;
    private JTextField txtCliente;
    private JComboBox jcbServicio;
    private JTextField txtCantidadServicio;
    private JTextField txtFechaInicio;
    private JTextField txtFechaFin;
    private JButton agregarButton;
    private JButton mostrarDatosButton;
    private JButton cancelarButton;
    private JComboBox jcbPromocion;
    private JPanel PanelAltaReserva;
    private String mensaje;

    public RealizarReserva() {

        cargarComboServicio();

        cargarComboPromocion();

        agregarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //agregar servicio
            }
        });

        mostrarDatosButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (txtPrecioTotal.getText().equals("")) {
                        txtPrecioTotal.requestFocus();
                        mensaje = "Precio Total";
                        throw new EmptyStackException();
                    }
                    if (txtCliente.getText().equals("")) {
                        txtCliente.requestFocus();
                        mensaje = "Cliente";
                        throw new EmptyStackException();
                    }
                    if ((jcbServicio.getSelectedItem().equals("")) || (jcbPromocion.getSelectedItem().equals(""))) {
                        mensaje = "Servicio o Promocion no seleccionada";
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
                    Reserva reserva = new Reserva();
                    reserva.setId(1);
                    //reserva.setCliente(txtCliente.getText());
                    //reserva.setEstado(EstadoReserva.registrada);
                    //reserva.setFechaCreacion(); //fecha actual
                    //reserva.setCarrito(); // ni puta idea
                    //fecha inicio
                    //fecha fin
                    //servicio
                    //promocion

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
    }

    private void cargarComboPromocion() {
        ProductoController productoController = new ProductoController();
        ArrayList<Promocion> promociones = productoController.listarPromociones();
        ComboBoxModel<Promocion> mdlCombo = new DefaultComboBoxModel<>(new Vector<Promocion>(promociones));
        jcbPromocion.setModel(mdlCombo);
    }

    private void cargarComboServicio () {
        ProductoController productoController = new ProductoController();
        ArrayList<Servicio> servicio = productoController.listarServicios();
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicio));
        jcbServicio.setModel(mdlCombo);
    }

    public JTextField getTxtPrecioTotal() {
        return txtPrecioTotal;
    }

    public void setTxtPrecioTotal(JTextField txtPrecioTotal) {
        this.txtPrecioTotal = txtPrecioTotal;
    }

    public JTextField getTxtCliente() {
        return txtCliente;
    }

    public void setTxtCliente(JTextField txtCliente) {
        this.txtCliente = txtCliente;
    }

    public JComboBox getJcbServicio() {
        return jcbServicio;
    }

    public void setJcbServicio(JComboBox jcbServicio) {
        this.jcbServicio = jcbServicio;
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

    public JComboBox getJcbPromocion() {
        return jcbPromocion;
    }

    public void setJcbPromocion(JComboBox jcbPromocion) {
        this.jcbPromocion = jcbPromocion;
    }

    public JPanel getPanelAltaReserva() {
        return PanelAltaReserva;
    }

    public void setPanelAltaReserva(JPanel panelAltaReserva) {
        PanelAltaReserva = panelAltaReserva;
    }
}