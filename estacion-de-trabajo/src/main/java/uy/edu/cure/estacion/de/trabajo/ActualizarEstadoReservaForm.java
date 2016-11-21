package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ClienteRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ReservaRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.RestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaClientes;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.TiposListas.ListaReservas;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Vector;

public class ActualizarEstadoReservaForm {
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

    public ActualizarEstadoReservaForm(){

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
                    ReservaRestController reservaController = new ReservaRestController();
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
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/listarCliente";
        RestController rest = new RestController();
        ListaClientes clientes = rest.doGET(url, ListaClientes.class);
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientes.getClientes()));
        jcbCliente.setModel(mdlCombo);
    }
    private void cargarComboReserva(Cliente cliente){
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXCliente/"+cliente;
        RestController rest = new RestController();
        ListaReservas reservas = rest.doPUT(url, cliente , ListaReservas.class);
        ComboBoxModel<Reserva> mdlCombo = new DefaultComboBoxModel<>( new Vector<Reserva>(reservas.getReservaArrayList()) );
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
