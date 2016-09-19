package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Promocion;
import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class AltaPromocion {
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
    private JTextArea txtLista;
    private Promocion promocion;
    private JScrollPane scroolPanelPromo;
    private JButton calcularPrecioButton;
    private DefaultListModel mdllista;


    public AltaPromocion() {
        txtDescuento.setText("0");
        cargoServicios();
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
                ProductoController productoController = new ProductoController();
                promocion.setNombre(txtNombre.getText());
                Double precio = new Double(txtPrecio.getText());
                promocion.setPrecio(precio);
                promocion.setDescripcion(txtNombre.getText());
                Integer dto = new Integer(getTxtDescuento().getText());
                promocion.setDescuento(dto);
                ArrayList<Servicio> ArrServicios = new ArrayList<Servicio>(serviciosElegidos);
                promocion.setServicios(ArrServicios);
                productoController.agregar(promocion);
            }
        });
    }

    public void calculoTotal(List<Servicio> serviciosElegidos) {
        txtPrecio.setText(null);
        precio = 0;
        double descuento = 0;
        Iterator<Servicio> iterator = serviciosElegidos.listIterator();
        for (int x = 0; x < serviciosElegidos.size(); x++) {
            ProductoController productoController = new ProductoController();
            Servicio servicio = (Servicio)productoController.obtener(serviciosElegidos.get(x).getId());
            precio = precio + servicio.getPrecio();
            txtPrecio.setText(Double.toString(precio));
            descuento = Double.parseDouble(txtDescuento.getText());
            descuento = 1-(descuento/100);
            txtTotalPromo.setText(Double.toString(precio * descuento));
        }
    }


    private void cargoServicios() {
        mdllista = new DefaultListModel();
        list.setModel(mdllista);
        ProductoController productoController = new ProductoController();
        List<Servicio> list1 = new ArrayList<>(productoController.listarServicios());
        for (Servicio servicio : list1) {
            mdllista.addElement(servicio);
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
