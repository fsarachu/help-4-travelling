package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.EstadoReserva;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaClientes;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaReservas;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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

        jcbCliente.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jcbCliente.getSelectedItem().equals("")) {
                        jcbCliente.requestFocus();
                        mensaje = "Cliente";
                    }
                    cliente = (Cliente) jcbCliente.getSelectedItem();
                    if (cliente == null) {
                        throw new EmptyStackException();
                    }
                    cargarComboReserva(cliente);
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);

                }
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (jcbReservas.getSelectedItem().equals("")) {
                        jcbReservas.requestFocus();
                        mensaje = "Reserva";
                    }
                    reserva = (Reserva) jcbReservas.getSelectedItem();
                    String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/estadoreserva/"
                            + reserva.getId() + "/" + EstadoReserva.cancelada;
                    RestController rest = new RestController();
                    Reserva u = rest.doGET(url, Reserva.class);
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }
                JOptionPane.showMessageDialog(null, "Reserva cancelada con exito", "Atencion", JOptionPane.INFORMATION_MESSAGE);
                PanelCancelarReserva.setVisible(false);
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                PanelCancelarReserva.setVisible(false);
            }
        });
    }

    private void cargaComboCliente() {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/listar";
        RestController rest = new RestController();
        ListaClientes clientesLista = rest.doGET(url, ListaClientes.class);
        ComboBoxModel<Cliente> mdlCombo = new DefaultComboBoxModel<>(new Vector<Cliente>(clientesLista.getClienteArrayList()));
        jcbCliente.setModel(mdlCombo);
    }

    private void cargarComboReserva(Cliente cliente) {
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listarReservaXCliente";
        RestController rest = new RestController();
        ListaReservas reservasLista = rest.doPUT(url, cliente, ListaReservas.class);
        ComboBoxModel<Reserva> mdlCombo = new DefaultComboBoxModel<>(new Vector<Reserva>(reservasLista.getReservaArrayList()));
        jcbReservas.setModel(mdlCombo);
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
