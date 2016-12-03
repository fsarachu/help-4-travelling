package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.*;
import uy.edu.cure.servidor.central.dto.TiposListas.*;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

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
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/listar";
                        RestController rest = new RestController();
                        ListaClientes clientesLista = rest.doGET(url, ListaClientes.class);
                        ArrayList<Cliente> clientes = clientesLista.getClienteArrayList();
                        for (Cliente cliente : clientes) {
                            txtInfo.append(cliente.getNombre() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Proveedores")) {
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/proveedor/listar";
                        RestController rest = new RestController();
                        ListaProveedores proveedoresLista = rest.doGET(url, ListaProveedores.class);
                        ArrayList<Proveedor> proveedores = proveedoresLista.getProveedorArrayList();
                        for (Proveedor proveedor : proveedores) {
                            txtInfo.append(proveedor.getNombreEmpresa() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Servicios")) {
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/listarservicios";
                        RestController rest = new RestController();
                        ListaServicios serviciosLista = rest.doGET(url, ListaServicios.class);
                        ArrayList<Servicio> servicios = serviciosLista.getServicioArrayList();
                        for (Servicio servicio : servicios) {
                            txtInfo.append(servicio.getNombre() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Promociones")) {
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/listarpromociones";
                        RestController rest = new RestController();
                        ListaPromociones promocionesLista = rest.doGET(url, ListaPromociones.class);
                        ArrayList<Promocion> promociones = promocionesLista.getPromocionArrayList();
                        for (Promocion promocion : promociones) {
                            txtInfo.append(promocion.getNombre() +
                                    "  - " + promocion.getDescripcion() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Reserva")) {
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/reserva/listar";
                        RestController rest = new RestController();
                        ListaReservas reservasLista = rest.doGET(url, ListaReservas.class);
                        ArrayList<Reserva> reservas = reservasLista.getReservaArrayList();
                        for (Reserva reserva : reservas) {
                            txtInfo.append(reserva.getCliente().getNombre() + "  "
                                    +reserva.getEstado() + "\n");
                        }
                    }
                    if (cmbInfo.getSelectedItem().equals("Logs")) {
                        String url = "http://localhost:8080/servidor-central-webapp/rest/api/loger/listar";
                        RestController rest = new RestController();
                        ListaLog listaLog = rest.doGET(url, ListaLog.class);
                        ArrayList<Log> logs = listaLog.getLogArrayList();
                        for (Log log : logs) {
                            txtInfo.append(log.getId() + "  "
                                    +log.getIp() + " " + log.getUrl() + " " + log.getSo() + " " +
                                    log.getUsr() + "\n");
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
        cmbInfo.addItem("Logs");
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
