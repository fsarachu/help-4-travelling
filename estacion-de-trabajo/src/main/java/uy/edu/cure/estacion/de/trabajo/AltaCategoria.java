package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;
import java.awt.*;

/**
 * Created by victor on 05/09/16.
 */
public class AltaCategoria extends JFrame {
    private JTextField txtCategoria;
    private JRadioButton rbPadre;
    private JRadioButton rbHijode;
    private JComboBox cmbCategorias;
    private JButton btnAceptar;
    private JButton btnCancelar;
    private JPanel panelCategoria;

    public JTextField getTxtCategoria() {
        return txtCategoria;
    }

    public void setTxtCategoria(JTextField txtCategoria) {
        this.txtCategoria = txtCategoria;
    }

    public JRadioButton getRbPadre() {
        return rbPadre;
    }

    public void setRbPadre(JRadioButton rbPadre) {
        this.rbPadre = rbPadre;
    }

    public JRadioButton getRbHijode() {
        return rbHijode;
    }

    public void setRbHijode(JRadioButton rbHijode) {
        this.rbHijode = rbHijode;
    }

    public JComboBox getCmbCategorias() {
        return cmbCategorias;
    }

    public void setCmbCategorias(JComboBox cmbCategorias) {
        this.cmbCategorias = cmbCategorias;
    }

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
    }

    public void setBtnCancelar(JButton btnCancelar) {
        this.btnCancelar = btnCancelar;
    }

    public JPanel getPanelCategoria() {
        return panelCategoria;
    }

    public void setPanelCategoria(JPanel panelCategoria) {
        this.panelCategoria = panelCategoria;
    }
}
