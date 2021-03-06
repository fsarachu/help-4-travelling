package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.dto.TiposListas.ListaServicios;
import uy.edu.cure.servidor.central.lib.controllers.RestController;

import javax.swing.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.EmptyStackException;
import java.util.Iterator;
import java.util.List;

public class AltaPromocionForm {
    private JTextField txtNombre;
    private JButton btnCalcularTotal;
    private JComboBox cmbServicios;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelPromocion;
    private JLabel txtPrecio;
    private double precio = 0;
    private JTextField txtDescuento;
    private JPanel panelPromo;
    private JList<Servicio> list;
    private JList<Servicio> listElegidos;
    private JLabel txtTotalPromo;
    private JComboBox cmbProveedor;
    private JTextArea txtLista;
    private Promocion promocion;
    private JScrollPane scroolPanelPromo;
    private JButton calcularPrecioButton;
    private DefaultListModel mdllista;
    private String mensaje;

    public AltaPromocionForm() {
        LlenarCombobox llenarCombobox = new LlenarCombobox();
        cmbProveedor.setModel(llenarCombobox.cargarComboProveedores());
        final List<Servicio> servicios = new ArrayList<>();
        final DefaultListModel mdlservicios = new DefaultListModel();
        final List<Servicio> serviciosElegidos = new ArrayList<>();
        final DefaultListModel mdlElegidos = new DefaultListModel();
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelPromocion.setVisible(false);
            }
        });
        list.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getClickCount() == 2) {
                    int index = list.getSelectedIndex();
                    mdlElegidos.addElement(list.getSelectedValue());
                    listElegidos.setModel(mdlElegidos);
                    serviciosElegidos.add(list.getSelectedValue());
                    mdllista.removeElementAt(index);
                    calculoTotal(serviciosElegidos);
                }
            }
        });
        listElegidos.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent mouseEvent) {
                super.mouseClicked(mouseEvent);
                if (mouseEvent.getClickCount() == 2) {
                    int index = listElegidos.getSelectedIndex();
                    mdllista.addElement(listElegidos.getSelectedValue());
                    list.setModel(mdllista);
                    serviciosElegidos.remove(listElegidos.getSelectedValue());
                    mdlElegidos.removeElementAt(index);
                    calculoTotal(serviciosElegidos);
                }
            }
        });

        aceptarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                try {
                    if (txtNombre.getText().equals("")) {
                        txtNombre.requestFocus();
                        mensaje = "Ingrese Nombre de la Promocion";
                        throw new EmptyStackException();
                    }
                    /*if (txtDescuento.getText().isEmpty()) {
                        Double.parseDouble(txtDescuento.getText());
                        txtDescuento.requestFocus();
                        mensaje = "Descuento Incorrecto";
                        throw new NumberFormatException();
                    }*/

                    promocion = new Promocion();
                    promocion.setNombre(txtNombre.getText());
                    Double precio = new Double(txtPrecio.getText());
                    promocion.setPrecio(precio);
                    promocion.setDescripcion(txtNombre.getText());
                    Integer dto = new Integer(getTxtDescuento().getText());
                    promocion.setDescuento(dto);
                    ArrayList<Servicio> ArrServicios = new ArrayList<Servicio>(serviciosElegidos);
                    promocion.setServicios(ArrServicios);
                    String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/agregar";
                    RestController rest = new RestController();
                    Promocion promo = rest.doPUT(url, promocion , Promocion.class);
                    panelPromocion.setVisible(false);
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, mensaje, "Atencion", JOptionPane.ERROR_MESSAGE);
                } //catch (NumberFormatException e) {
                //JOptionPane.showMessageDialog(null, mensaje ,"Atencion",JOptionPane.ERROR_MESSAGE);
                //}

            }
        });
        cmbProveedor.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Proveedor proveedor = (Proveedor) cmbProveedor.getSelectedItem();
                cargoServicios(proveedor.getId());
            }
        });
    }

    public void calculoTotal(List<Servicio> serviciosElegidos) {
        txtPrecio.setText(null);
        precio = 0;
        double descuento = 0;
        Iterator<Servicio> iterator = serviciosElegidos.listIterator();
        for (int x = 0; x < serviciosElegidos.size(); x++) {
            String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/obtener/" +
                    serviciosElegidos.get(x).getId();
            RestController rest = new RestController();
            Servicio servicio = rest.doGET(url, Servicio.class);
            precio = precio + servicio.getPrecio();
            txtPrecio.setText(Double.toString(precio));
            descuento = Double.parseDouble(txtDescuento.getText());
            descuento = 1 - (descuento / 100);
            txtTotalPromo.setText(Double.toString(precio * descuento));
        }
    }


    private void cargoServicios(Integer idProveedor) {
        mdllista = new DefaultListModel();
        list.setModel(mdllista);
        String url = "http://localhost:8080/servidor-central-webapp/rest/api/producto/listarservicios";
        RestController rest = new RestController();
        ListaServicios servicios = rest.doGET(url, ListaServicios.class);
        List<Servicio> list1 = new ArrayList<>(servicios.getServicioArrayList());
        for (Servicio servicio : list1) {
            if (servicio.getProveedor().getId().equals(idProveedor)) {
                mdllista.addElement(servicio);
            }
        }

    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JButton getBtnCalcularTotal() {
        return btnCalcularTotal;
    }

    public void setBtnCalcularTotal(JButton btnCalcularTotal) {
        this.btnCalcularTotal = btnCalcularTotal;
    }

    public JComboBox getCmbServicios() {
        return cmbServicios;
    }

    public void setCmbServicios(JComboBox cmbServicios) {
        this.cmbServicios = cmbServicios;
    }

    public JButton getAceptarButton() {
        return aceptarButton;
    }

    public void setAceptarButton(JButton aceptarButton) {
        this.aceptarButton = aceptarButton;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }

    public JPanel getPanelPromocion() {
        return panelPromocion;
    }

    public void setPanelPromocion(JPanel panelPromocion) {
        this.panelPromocion = panelPromocion;
    }

    public JLabel getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JLabel txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JTextField getTxtDescuento() {
        return txtDescuento;
    }

    public void setTxtDescuento(JTextField txtDescuento) {
        this.txtDescuento = txtDescuento;
    }

    public JPanel getPanelPromo() {
        return panelPromo;
    }

    public void setPanelPromo(JPanel panelPromo) {
        this.panelPromo = panelPromo;
    }

    public JList getList() {
        return list;
    }

    public void setList(JList list) {
        this.list = list;
    }

    public JList getListElegidos() {
        return listElegidos;
    }

    public void setListElegidos(JList listElegidos) {
        this.listElegidos = listElegidos;
    }

    public JScrollPane getScroolPanelPromo() {
        return scroolPanelPromo;
    }

    public void setScroolPanelPromo(JScrollPane scroolPanelPromo) {
        this.scroolPanelPromo = scroolPanelPromo;
    }

    public JButton getCalcularPrecioButton() {
        return calcularPrecioButton;
    }

    public void setCalcularPrecioButton(JButton calcularPrecioButton) {
        this.calcularPrecioButton = calcularPrecioButton;
    }
}
