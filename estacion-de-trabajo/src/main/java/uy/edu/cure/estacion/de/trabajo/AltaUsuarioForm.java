package uy.edu.cure.estacion.de.trabajo;


import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.*;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class AltaUsuarioForm extends JFrame {
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
    private JButton btnFoto;
    private JLabel lblFoto;
    private JPasswordField txtContrasena;
    private JPasswordField txtContrasenaConf;
    private JFileChooser fileChooser;
    private String txtImagen1;

    public AltaUsuarioForm() {
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
        btnFoto.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                fileChooser = new JFileChooser();
                if (fileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
                    File archivoElegido = fileChooser.getSelectedFile();
                    txtImagen1 = archivoElegido.getAbsolutePath();
                    JOptionPane.showMessageDialog(null, txtImagen1, "Atencion", JOptionPane.ERROR_MESSAGE);
                    ImageIcon icon = new ImageIcon(txtImagen1);
                    Icon icono = new ImageIcon(icon.getImage().getScaledInstance(lblFoto.getWidth(), lblFoto.getHeight(), Image.SCALE_DEFAULT));
                    lblFoto.setIcon(icono);
                }
            }
        });

        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {

                try {
                    if (txtNickName.getText().equals("")) {
                        txtNickName.requestFocus();
                        throw new IllegalArgumentException("Ingrese Nickname");
                    }
                    if (txtNombre.getText().equals("")) {
                        txtNombre.requestFocus();
                        throw new IllegalArgumentException("Ingrese Nombre");
                    }
                    if (txtApellido.getText().equals("")) {
                        txtApellido.requestFocus();
                        throw new IllegalArgumentException("Ingrese Apellido");
                    }

                    EmailValidator emailValidator = new EmailValidator();

                    if (!emailValidator.validate(txtCorreo.getText().trim())) {
                        txtCorreo.requestFocus();
                        throw new IllegalArgumentException("Compruebe Correo");
                    }
                    FechaValidator fechaValidator = new FechaValidator();
                    if (!fechaValidator.validate(txtFechaNacimiento.getText())) {
                        txtFechaNacimiento.requestFocus();
                        throw new ParseException("Compruebe Fecha",1);
                    }

                    UsuarioExisteValidator usuarioExisteValidator = new UsuarioExisteValidator();
                    if (!usuarioExisteValidator.validator(txtNickName.getText(), txtCorreo.getText())) {
                        throw new IllegalArgumentException("Usuario Existente");
                    }
                    ComparoContrasenaValidator comparoContrasenaValidator = new ComparoContrasenaValidator();
                    if (!comparoContrasenaValidator.passwordCorrecto(txtContrasena.getPassword(),txtContrasenaConf.getPassword())) {
                        throw new IllegalArgumentException("Las contrasenas no coinciden");
                    }

                    if (rbtnCliente.isSelected() == true) {

                        Cliente cliente = new Cliente();
                        cliente.setNickname(txtNickName.getText());
                        cliente.setNombre(txtNombre.getText());
                        cliente.setApellido(txtApellido.getText());
                        cliente.setCorreo(txtCorreo.getText());
                        cliente.setFechaNacimiento(formatter.parse(txtFechaNacimiento.getText()));
                        cliente.setImagen(txtImagen1);
                        String password = new String(txtContrasena.getPassword());
                        cliente.setContrasena(password);
                        ClienteController clienteController = new ClienteController();
                        clienteController.nuevo(cliente);
                        panelMain.setVisible(false);

                    } else if (rbtnProveedor.isSelected() == true) {

                        if (txtEmpresa.getText().equals("")) {
                            txtEmpresa.requestFocus();
                            throw new IllegalArgumentException("Ingrese Empresa");
                        }
                        if (txtLink.getText().equals("")) {
                            txtLink.requestFocus();
                            throw new IllegalArgumentException("Ingrese Link del proveedor");
                        }

                        Proveedor provedor = new Proveedor();
                        provedor.setId(1);
                        provedor.setNickname(txtNickName.getText());
                        provedor.setNombre(txtNombre.getText());
                        provedor.setApellido(txtApellido.getText());
                        provedor.setCorreo(txtCorreo.getText());
                        provedor.setFechaNacimiento(formatter.parse(txtFechaNacimiento.getText()));
                        provedor.setNombreEmpresa(txtEmpresa.getText());
                        provedor.setLinkEmpresa(txtLink.getText());
                        provedor.setImagen(txtImagen1);
                        ProveedorController proveedorController = new ProveedorController();
                        proveedorController.nuevo(provedor);
                        panelMain.setVisible(false);
                    }
                    if (txtImagen1.toString() != null) {
                        String destino = "/imagenes";
                        CopioImagen copioImagen = new CopioImagen();
                        copioImagen.copioArchivo(txtImagen1.toString() , destino );
                    }
                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Verifique la fecha ingresada. " , "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        });

        cancelarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelMain.setVisible(false);
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
