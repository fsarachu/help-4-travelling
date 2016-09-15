package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Reserva;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;
import uy.edu.cure.servidor.central.lib.controllers.ReservaController;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;

public class VerInfo {
    private JComboBox cmbInfo;
    private JTextArea txtInfo;
    private JPanel panelInfo;

    public VerInfo() {
        cargarCombo();
        cmbInfo.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                if (cmbInfo.getSelectedItem().equals("Proveedores")) {
                    ProveedorController proveedorController = new ProveedorController();
                    ArrayList<Proveedor> proveedores = proveedorController.listar();
                    for (Object obj : proveedores) {
                        txtInfo.append(obj.toString() + "\n");
                    }
                }
                if (cmbInfo.getSelectedItem().equals("Servicios")) {
                    ProductoController productoController = new ProductoController();
                    ArrayList<Servicio> servicios = productoController.listarServicios();
                    for (Object obj : servicios) {
                        txtInfo.append(obj.toString() + "\n");
                    }
                }
                if (cmbInfo.getSelectedItem().equals("Promociones")) {
                    ProductoController productoController = new ProductoController();
                    ArrayList<Promocion> promociones = productoController.listarPromociones();
                    for (Object obj : promociones) {
                        txtInfo.append(obj.toString() + "\n");
                    }
                }
                if (cmbInfo.getSelectedItem().equals("Reserva")) {
                    ReservaController reservaController = new ReservaController();
                    ArrayList<Reserva> reservas = reservaController.listar();
                    for (Object obj : reservas) {
                        txtInfo.append(obj.toString() + "\n");
                    }
                    /*ClienteController clienteController = new ClienteController();
                    ArrayList<Cliente> clientes = clienteController.listarTodos();
                    for (Object obj : clientes) {
                        txtInfo.append(obj.toString() + "\n");
                    }*/

                }
            }
        });
    }

    private void cargarCombo() {
        cmbInfo.addItem("Proveedores");
        cmbInfo.addItem("Servicios");
        cmbInfo.addItem("Promociones");
        cmbInfo.addItem("Reserva");
    }

    public JComboBox getCmbInfo() {
        return cmbInfo;
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