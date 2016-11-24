package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaClientes;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaServicios;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;


public class ListadoCiudadForm {
    private JComboBox cmbCiudades;
    private JPanel panelPrincipal;
    private JList<Servicio> list;
    private JList<Cliente> listClientes;
    private DefaultListModel mdllistaCliente;
    private DefaultListModel mdllista;

    public ListadoCiudadForm() {
        LlenarCombobox llenarCombobox = new LlenarCombobox();
        cmbCiudades.setModel(llenarCombobox.cargarComboCiudad(cmbCiudades));

        cmbCiudades.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                mdllista = new DefaultListModel();
                list.setModel(mdllista);
                Ciudad ciudad = (Ciudad) cmbCiudades.getSelectedItem();
                String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/listarServicioXCiudad/";
                RestController rest = new RestController();
                ListaServicios serviciosLista = rest.doPUT(url, ciudad, ListaServicios.class);
                List<Servicio> servicios = new ArrayList<>(serviciosLista.getServicioArrayList());
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
                    String url = "http://localhost:8080/servidor-central-webapp/rest/api/cliente/listarcompradoresServicio";
                    RestController rest = new RestController();
                    ListaClientes clientesLista = rest.doPUT(url, (Servicio)list.getSelectedValue() , ListaClientes.class);
                    ArrayList<Cliente> clientes = clientesLista.getClienteArrayList();
                    for (Cliente cliente : clientes) {
                        mdllistaCliente.addElement(cliente);
                    }
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
