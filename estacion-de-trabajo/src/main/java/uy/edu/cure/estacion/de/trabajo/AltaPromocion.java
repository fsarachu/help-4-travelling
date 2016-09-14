package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;

public class AltaPromocion {
    private JTextField inNombre;
    private JButton agregarServicioButton;
    private JComboBox comboBox1;
    private JButton aceptarButton;
    private JButton cancelarButton;
    private JPanel panelPromocion;
    private JLabel txtPrecio;
    private JTextField inDescuento;
    private JButton calcularPrecioButton;

    public AltaPromocion() {

    }

    public JTextField getTextField1() {
        return inNombre;
    }

    public void setTextField1(JTextField textField1) {
        this.inNombre = textField1;
    }

    public JButton getAgregarServicioButton() {
        return agregarServicioButton;
    }

    public void setAgregarServicioButton(JButton agregarServicioButton) {
        this.agregarServicioButton = agregarServicioButton;
    }

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
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
