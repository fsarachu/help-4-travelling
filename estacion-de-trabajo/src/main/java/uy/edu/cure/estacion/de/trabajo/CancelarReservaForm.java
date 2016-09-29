package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Vector;

public class CancelarReservaForm {
    private JComboBox jcbReservas;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JComboBox jcbCliente;
    private JPanel PanelCancelarReserva;
    private String mensaje;
    private Cliente cliente;
    private Reserva reserva;

    public CancelarReservaForm() {

        cargaComboCliente();

        jcbCliente.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jcbCliente.getSelectedItem().equals( "" )) {
                        jcbCliente.requestFocus();
                        mensaje = "Cliente";
                    }
                    cliente = (Cliente) jcbCliente.getSelectedItem();
                    if (cliente == null) {
                        throw new EmptyStackException();
                    }
                    cargarComboReserva( cliente );
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog( null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE );

                }
            }
        });

        aceptarButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jcbReservas.getSelectedItem().equals( "" )) {
                        jcbReservas.requestFocus();
                        mensaje = "Reserva";
                    }

                    reserva = (Reserva) jcbReservas.getSelectedItem();
                    ReservaController reservaController = new ReservaController();
                    reservaController.actualizarEstado( reserva.getId(), EstadoReserva.cancelada );

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog( null, "Ingrese " + mensaje, "Datos inválidos",JOptionPane.ERROR_MESSAGE );
                }
                JOptionPane.showMessageDialog(null,"Reserva cancelada con exito","Atencion",JOptionPane.INFORMATION_MESSAGE);
                PanelCancelarReserva.setVisible(false);
            }
        } );
        cancelarButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PanelCancelarReserva.setVisible( false );
            }
        } );
    }

    private void cargaComboCliente() {
        ClienteController clientecontroller = new ClienteController();
        ArrayList<Cliente> clientes = clientecontroller.listar();
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientes));
        jcbCliente.setModel(mdlCombo);
    }
    private void cargarComboReserva(Cliente cliente){
        ReservaController reservaController = new ReservaController();
        ArrayList<Reserva> reservas = reservaController.listarReservasCliente( cliente );
        ComboBoxModel<Reserva> mdlCombo = new DefaultComboBoxModel<>( new Vector<Reserva>(reservas) );
        jcbReservas.setModel( mdlCombo );
    }

    public JComboBox getJcbReservas() {
        return jcbReservas;
    }

    public void setJcbReservas(JComboBox jcbReservas) {
        this.jcbReservas = jcbReservas;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void setAceptarButton(JButton aceptarButton) {
        this.aceptarButton = aceptarButton;
    }

    public JComboBox getJcbCliente() {
        return jcbCliente;
    }

    public void setJcbCliente(JComboBox jcbCliente) {
        this.jcbCliente = jcbCliente;
    }

    public JPanel getPanelCancelarReserva() {
        return PanelCancelarReserva;
    }

    public void setPanelCancelarReserva(JPanel panelCancelarReserva) {
        PanelCancelarReserva = panelCancelarReserva;
    }
}
