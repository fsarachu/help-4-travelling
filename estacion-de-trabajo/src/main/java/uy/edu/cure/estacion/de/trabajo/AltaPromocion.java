package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Vector;

public class AltaPromocion {
    private JTextField inNombre;
    private JButton agregarServicioButton;
    private JComboBox cmbServicios;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelPromocion;
    private JLabel txtPrecio;
    private JTextField inDescuento;
    private JButton calcularPrecioButton;

    public AltaPromocion() {
        cargarServicios();
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelPromocion.setVisible(false);
            }
        });
    }

    private void cargarServicios() {
        ProductoController productoController = new ProductoController();
        List<Servicio> servicios = productoController.listarServicios();
        ComboBoxModel<Servicio> mdlCombo = new DefaultComboBoxModel<>(new Vector<Servicio>(servicios));
        cmbServicios.setModel(mdlCombo);
    }

    public AltaPromocion(JButton calcularPrecioButton) {
        this.calcularPrecioButton = calcularPrecioButton;
    }

    public JTextField getInNombre() {
        return inNombre;
    }

    public void setInNombre(JTextField inNombre) {
        this.inNombre = inNombre;
    }

    public JButton getAgregarServicioButton() {
        return agregarServicioButton;
    }

    public void setAgregarServicioButton(JButton agregarServicioButton) {
        this.agregarServicioButton = agregarServicioButton;
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

    public JTextField getInDescuento() {
        return inDescuento;
    }

    public void setInDescuento(JTextField inDescuento) {
        this.inDescuento = inDescuento;
    }

    public JButton getCalcularPrecioButton() {
        return calcularPrecioButton;
    }

    public void setCalcularPrecioButton(JButton calcularPrecioButton) {
        this.calcularPrecioButton = calcularPrecioButton;
    }
}
