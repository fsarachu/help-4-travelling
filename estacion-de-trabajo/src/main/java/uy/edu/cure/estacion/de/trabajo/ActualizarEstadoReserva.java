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

public class ActualizarEstadoReserva {
    private JComboBox jcbCliente;
    private JComboBox jcbReserva;
    private JComboBox jcbEstado;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelActualizarEstado;
    private String mensaje;
    private Cliente cliente;
    private Reserva reserva;
    private EstadoReserva estado;

    public ActualizarEstadoReserva (){

        cargaComboCliente();
        cargarComboEstado();

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
                    if (jcbReserva.getSelectedItem().equals( "" )) {
                        jcbReserva.requestFocus();
                        mensaje = "Reserva";
                    }
                    if (jcbEstado.getSelectedItem().equals("")){
                        jcbEstado.requestFocus();
                        mensaje = "Estado";
                    }

                    reserva = (Reserva) jcbReserva.getSelectedItem();
                    ReservaController reservaController = new ReservaController();
                    estado = (EstadoReserva) jcbEstado.getSelectedItem();
                    reservaController.actualizarEstado( reserva.getId(), estado);

                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog( null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE );
                }
                JOptionPane.showMessageDialog(null,"Reserva actualizada con exito","Atencion",JOptionPane.INFORMATION_MESSAGE);
                panelActualizarEstado.setVisible(false);
            }
        } );

        cancelarButton.addActionListener( new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelActualizarEstado.setVisible( false );
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
        jcbReserva.setModel( mdlCombo );
    }
    private void cargarComboEstado(){
        ComboBoxModel<EstadoReserva> mdlCombo = new DefaultComboBoxModel<>( EstadoReserva.values() );
        jcbEstado.setModel( mdlCombo );

    }

    public JPanel getPanelActualizarEstado() {
        return panelActualizarEstado;
    }

    public void setPanelActualizarEstado(JPanel panelActualizarEstado) {
        this.panelActualizarEstado = panelActualizarEstado;
    }
}
