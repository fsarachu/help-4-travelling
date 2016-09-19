package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Vector;

public class CancelarReserva {
    private JComboBox jcbReservas;
    private JButton cancelarButton;
    private JButton aceptarButton;
    private JComboBox jcbCliente;
    private String mensaje;
    private Cliente cliente;

    CargarComboCliente();

    CargarComboReserva();

    aceptarButton.addActionListener(new ActionListener() {
        @Override
        public void actionPerformed (ActionEvent actionEvent){
            try{
                if (jcbCliente.getSelectedItem().equals("")){
                    jcbCliente.requestFocus();
                    mensaje = "Cliente";
                }
                if (jcbReservas.getSelectedItem().equals("")) {
                    jcbReservas.requestFocus();
                    mensaje = "Reserva";
                }
                cliente = (Cliente) jcbCliente.getSelectedItem();

            } catch (EmptyStackException e) {
            JOptionPane.showMessageDialog( null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE );
        }

        }
    });

    CargarComboCliente(){
        ClienteController clientecontroller = new ClienteController();
        ArrayList<Cliente> clientes = clientecontroller.listar();
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientes));
        jcbCliente.setModel(mdlCombo);
    }
    cargarComboReserva(){
        ReservaController reservaController = new ReservaController();
        ArrayList<Reserva> reservas = reservaController.listar();
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
}
