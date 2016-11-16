package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ClienteRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ProductoRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ProveedorRestController;
import uy.edu.cure.servidor.central.webapp.rest.api.RestControllers.ReservaRestController;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class VerInfoForm {
    private JComboBox cmbInfo;
    private JTextArea txtInfo;
    private JPanel panelInfo;

    public VerInfoForm() {
        cargarCombo();
        cmbInfo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                txtInfo.setText(null);
                if (itemEvent.getStateChange() == 1) {
                    if (cmbInfo.getSelectedItem().equals("Clientes")) {
                        ClienteRestController clienteController = new ClienteRestController();
                        ArrayList<Cliente> clientes = clienteController.listar();
                        for (Cliente cliente : clientes) {
                            txtInfo.append(cliente.getNombre() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Proveedores")) {
                        ProveedorRestController proveedorController = new ProveedorRestController();
                        ArrayList<Proveedor> proveedores = proveedorController.listar();
                        for (Proveedor proveedor : proveedores) {
                            txtInfo.append(proveedor.getNombreEmpresa() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Servicios")) {
                        ProductoRestController productoController = new ProductoRestController();
                        ArrayList<Servicio> servicios = productoController.listarServicios();
                        for (Servicio servicio : servicios) {
                            txtInfo.append(servicio.getNombre() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Promociones")) {
                        ProductoRestController productoController = new ProductoRestController();
                        ArrayList<Promocion> promociones = productoController.listarPromociones();
                        for (Promocion promocion : promociones) {
                            txtInfo.append(promocion.getNombre() +
                                    "  - " + promocion.getDescripcion() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Reserva")) {
                        ReservaRestController reservaController = new ReservaRestController();
                        ArrayList<Reserva> reservas = reservaController.listar();
                        for (Reserva reserva : reservas) {
                            txtInfo.append(reserva.getCliente().getNombre() + "  "
                                    +reserva.getEstado() + "\n");
                        }
                    }
                }
            }
        });
    }

    private void cargarCombo() {
        cmbInfo.addItem("Clientes");
        cmbInfo.addItem("Proveedores");
        cmbInfo.addItem("Servicios");
        cmbInfo.addItem("Promociones");
        cmbInfo.addItem("Reserva");
    }


    public void setCmbInfo(JComboBox cmbInfo) {
        this.cmbInfo = cmbInfo;
    }

    public JTextArea getTxtInfo() {
        return txtInfo;
    }

    public void setTxtInfo(JTextArea txtInfo) {
        this.txtInfo = txtInfo;
    }

    public JPanel getPanelInfo() {
        return panelInfo;
    }

    public void setPanelInfo(JPanel panelInfo) {
        this.panelInfo = panelInfo;
    }
}
