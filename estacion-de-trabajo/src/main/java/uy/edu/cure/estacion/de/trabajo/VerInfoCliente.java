package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;

public class VerInfoCliente {
    private JComboBox comboBox1;
    private JPanel panelnfoCliente;
    private JLabel txtNick;
    private JLabel txtNombre;
    private JLabel txtApellido;
    private JLabel txtCorreo;
    private JLabel txtFechaNacimiento;
    private JButton cancelarButton;
    private JButton aceptarButton;

    public JComboBox getComboBox1() {
        return comboBox1;
    }

    public void setComboBox1(JComboBox comboBox1) {
        this.comboBox1 = comboBox1;
    }

    public JPanel getPanelnfoCliente() {
        return panelnfoCliente;
    }

    public void setPanelnfoCliente(JPanel panelnfoCliente) {
        this.panelnfoCliente = panelnfoCliente;
    }

    public JLabel getTxtNick() {
        return txtNick;
    }

    public void setTxtNick(JLabel txtNick) {
        this.txtNick = txtNick;
    }

    public JLabel getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JLabel txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JLabel getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JLabel txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JLabel getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JLabel txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JLabel getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JLabel txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
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
}
