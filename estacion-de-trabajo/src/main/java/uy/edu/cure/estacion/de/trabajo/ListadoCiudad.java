package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Producto;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.LlenarCombobox;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class ListadoCiudad {
    private JComboBox cmbCiudades;
    private JPanel panelPrincipal;
    private JList<Servicio> list;
    private JList<Cliente> listClientes;
    private DefaultListModel mdllistaCliente;
    private DefaultListModel mdllista;

    public ListadoCiudad() {
        LlenarCombobox llenarCombobox = new LlenarCombobox();
        cmbCiudades.setModel(llenarCombobox.cargarComboCiudad(cmbCiudades));

        cmbCiudades.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                mdllista = new DefaultListModel();
                list.setModel(mdllista);
                Ciudad ciudad = (Ciudad) cmbCiudades.getSelectedItem();
                ProductoController productoController = new ProductoController();
                List<Servicio> servicios = new ArrayList<>(productoController.listarServiciosPorCiudad(ciudad));
                for (Servicio servicio : servicios) {
                    mdllista.addElement(servicio);
                }
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getClickCount() == 1) {
                    mdllistaCliente = new DefaultListModel();
                    listClientes.setModel(mdllistaCliente);
                    ClienteController clienteController = new ClienteController();
                    ArrayList<Cliente> clientes = clienteController.listarCompradoresServicio((Servicio)list.getSelectedValue());
                    mdllistaCliente.addElement(clientes);
                }
            }
        });
    }

    public JComboBox getCmbCiudades() {
        return cmbCiudades;
    }

    public void setCmbCiudades(JComboBox cmbCiudades) {
        this.cmbCiudades = cmbCiudades;
    }

    public JPanel getPanelPrincipal() {
        return panelPrincipal;
    }

    public void setPanelPrincipal(JPanel panelPrincipal) {
        this.panelPrincipal = panelPrincipal;
    }

    public JList<Servicio> getList() {
        return list;
    }

    public void setList(JList<Servicio> list) {
        this.list = list;
    }

    public DefaultListModel getMdllista() {
        return mdllista;
    }

    public void setMdllista(DefaultListModel mdllista) {
        this.mdllista = mdllista;
    }
}
