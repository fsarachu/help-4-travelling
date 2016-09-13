package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.EmptyStackException;

public class AltaUsuario extends JFrame {
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

    public AltaUsuario() {
        rbtnCliente.setSelected(true);
        txtEmpresa.setVisible(false);
        txtLink.setVisible(false);
        lblEmpresa.setVisible(false);
        lblLink.setVisible(false);
        Date hoy = new Date();
        final SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        txtFechaNacimiento.setText(formatter.format(hoy));

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
                JOptionPane.showMessageDialog(null, null, "HOLA", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                String mensaje = "";
                Cliente cliente = new Cliente();
                try {
                    if (txtNickName.getText().equals("")) {
                        txtNickName.requestFocus();
                        mensaje = "Nickname";
                        throw new EmptyStackException();
                    }
                    if (txtNombre.getText().equals("")) {
                        txtNombre.requestFocus();
                        mensaje = "Nombre";
                        throw new EmptyStackException();
                    }
                    if (txtApellido.getText().equals("")) {
                        txtApellido.requestFocus();
                        mensaje = "Apellido";
                        throw new EmptyStackException();
                    }
                    if (txtCorreo.getText().equals("")) {
                        txtCorreo.requestFocus();
                        mensaje = "Correo";
                        throw new EmptyStackException();
                    }
                    if (txtEmpresa.getText().equals("")) {
                        txtEmpresa.requestFocus();
                        mensaje = "Empresa";
                        throw new EmptyStackException();
                    }
                    if (txtLink.getText().equals("")) {
                        txtLink.requestFocus();
                        mensaje = "Link del proveedor";
                        throw new EmptyStackException();
                    }
                    cliente.setId(1);
                    cliente.setNickname(txtNickName.getText());
                    cliente.setNombre(txtNombre.getText());
                    cliente.setApellido(txtApellido.getText());
                    cliente.setCorreo(txtCorreo.getText());
                    cliente.setFechaNacimiento(formatter.parse(txtFechaNacimiento.getText()));
                } catch (EmptyStackException e) {
                    JOptionPane.showMessageDialog(null, "Ingrese " + mensaje, "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Verifique la información ingresada", "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }
                ClienteController clienteController = new ClienteController();
                clienteController.nuevo(cliente);
            }
        });
    }

    public JLabel getLblNickname() {
        return lblNickname;
    }

    public void setLblNickname(JLabel lblNickname) {
        this.lblNickname = lblNickname;
    }

    public JRadioButton getRbtnCliente() {
        return rbtnCliente;
    }

    public void setRbtnCliente(JRadioButton rbtnCliente) {
        this.rbtnCliente = rbtnCliente;
    }

    public JRadioButton getRbtnProveedor() {
        return rbtnProveedor;
    }

    public void setRbtnProveedor(JRadioButton rbtnProveedor) {
        this.rbtnProveedor = rbtnProveedor;
    }

    public JTextField getTxtNickName() {
        return txtNickName;
    }

    public void setTxtNickName(JTextField txtNickName) {
        this.txtNickName = txtNickName;
    }

    public JTextField getTxtNombre() {
        return txtNombre;
    }

    public void setTxtNombre(JTextField txtNombre) {
        this.txtNombre = txtNombre;
    }

    public JTextField getTxtApellido() {
        return txtApellido;
    }

    public void setTxtApellido(JTextField txtApellido) {
        this.txtApellido = txtApellido;
    }

    public JTextField getTxtCorreo() {
        return txtCorreo;
    }

    public void setTxtCorreo(JTextField txtCorreo) {
        this.txtCorreo = txtCorreo;
    }

    public JTextField getTxtFechaNacimiento() {
        return txtFechaNacimiento;
    }

    public void setTxtFechaNacimiento(JTextField txtFechaNacimiento) {
        this.txtFechaNacimiento = txtFechaNacimiento;
    }

    public JTextField getTxtEmpresa() {
        return txtEmpresa;
    }

    public void setTxtEmpresa(JTextField txtEmpresa) {
        this.txtEmpresa = txtEmpresa;
    }

    public JTextField getTxtLink() {
        return txtLink;
    }

    public void setTxtLink(JTextField txtLink) {
        this.txtLink = txtLink;
    }

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

    public JLabel getLblEmpresa() {
        return lblEmpresa;
    }

    public void setLblEmpresa(JLabel lblEmpresa) {
        this.lblEmpresa = lblEmpresa;
    }

    public JLabel getLblLink() {
        return lblLink;
    }

    public void setLblLink(JLabel lblLink) {
        this.lblLink = lblLink;
    }
}
