package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;


public class ActualizarServicio extends JFrame{
    private JComboBox comboBoxServicio;
    private JButton buttonAcept;
    private JButton buttonCancel;


    public JComboBox getComboBoxServicio() {
        return comboBoxServicio;
    }

    public void setcomboBoxServicio(JComboBox comboBoxServicio){
        this.comboBoxServicio = comboBoxServicio;
    }

    public void setButtonAcept(JButton buttonAcept) {
        this.buttonAcept = buttonAcept;
    }

    public JButton getButtonAcept() {
        return buttonAcept;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }
}
