package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.*;

public class AltaUsuario extends JFrame{
    private JLabel lblNickname;
    private JRadioButton rbtnCliente;
    private JRadioButton rbtnProveedor;
    private JTextField txtNickName;
    private JTextField txtNombre;
    private JTextField txtApellido;
    private JTextField txtCorreo;
    private JTextField txtFechaNacimiento;
    private JTextField txtEmpresa;
    private JTextField txtLink;
    private JButton btnAceptar;
    private JButton cancelarButton;
    private JPanel panelMain;
    private JLabel lblEmpresa;
    private JLabel lblLink;

    public JButton getBtnAceptar() {
        return btnAceptar;
    }

    public void setBtnAceptar(JButton btnAceptar) {
        this.btnAceptar = btnAceptar;
    }

    public JButton getCancelarButton() {
        return cancelarButton;
    }

    public void setCancelarButton(JButton cancelarButton) {
        this.cancelarButton = cancelarButton;
    }

    public JPanel getPanelMain() {
        return panelMain;
    }

    public void setPanelMain(JPanel panelMain) {
        this.panelMain = panelMain;
    }

    public AltaUsuario() {
        rbtnCliente.setSelected(true);
        txtEmpresa.setVisible(false);
        txtLink.setVisible(false);
        lblEmpresa.setVisible(false);
        lblLink.setVisible(false);

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, null, "Aceptar", JOptionPane.ERROR_MESSAGE);
            }
        });
        rbtnProveedor.addChangeListener(new ChangeListener() {
            @Override
            public void stateChanged(ChangeEvent changeEvent) {
                if (rbtnProveedor.isSelected()) {
                    txtEmpresa.setVisible(true);
                    txtLink.setVisible(true);
                    lblEmpresa.setVisible(true);
                    lblLink.setVisible(true);
                } else {
                    txtEmpresa.setVisible(false);
                    txtLink.setVisible(false);
                    lblEmpresa.setVisible(false);
                    lblLink.setVisible(false);
                }
            }
        });
        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null,null,"HOLA",JOptionPane.INFORMATION_MESSAGE);

            }
        });
    }


}
