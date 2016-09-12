package uy.edu.cure.estacion.de.trabajo;

import javafx.stage.WindowEvent;
import uy.edu.cure.servidor.central.dto.Cliente;
import uy.edu.cure.servidor.central.dto.Proveedor;
import uy.edu.cure.servidor.central.lib.controllers.ClienteController;
import uy.edu.cure.servidor.central.lib.controllers.ProveedorController;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
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
    //private JFrame panelMain;
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
                //cancelarButton.getParent().dispatchEvent(new java.awt.event.WindowEvent( new  ));
                //JOptionPane.showMessageDialog(null, null, "HOLA", JOptionPane.INFORMATION_MESSAGE);
                //AltaUsuario.super.dispose();
                //System.exit(0);
                //dispose();

                //AltaUsuario.super.dispose();
                //AltaUsuario.super.getRootPane().setVisible(false);

                Container pan = cancelarButton.getParent();
                pan.removeAll();
                pan.repaint();
                pan.setVisible(false);

            }
        });





        btnAceptar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                //String mensaje = "";

                try {
                    if (txtNickName.getText().equals("")) {
                        txtNickName.requestFocus();
                        //mensaje = "Nickname";
                        throw  new IllegalArgumentException("Ingrese Nickname");
                    }
                    if (txtNombre.getText().equals("")) {
                        txtNombre.requestFocus();
                        //mensaje = "Nombre";
                        throw new IllegalArgumentException("Ingrese Nombre");
                    }
                    if (txtApellido.getText().equals("")) {
                        txtApellido.requestFocus();
                        //mensaje = "Apellido";
                        throw new IllegalArgumentException("Ingrese Apellido");
                    }
                    if (txtCorreo.getText().equals("")) {
                        txtCorreo.requestFocus();
                        //mensaje = "Correo";
                        throw new IllegalArgumentException("Ingrese Correo");
                    }



                    if(rbtnCliente.isSelected()){

                        Cliente cliente = new Cliente();
                        cliente.setId(1);
                        cliente.setNickname(txtNickName.getText());
                        cliente.setNombre(txtNombre.getText());
                        cliente.setApellido(txtApellido.getText());
                        cliente.setCorreo(txtCorreo.getText());
                        cliente.setFechaNacimiento(formatter.parse(txtFechaNacimiento.getText()));

                        ClienteController clienteController = new ClienteController();
                        clienteController.nuevo(cliente);

                    }else if (rbtnProveedor.isSelected() ) {

                        if (txtEmpresa.getText().equals("")) {
                            txtEmpresa.requestFocus();
                            //mensaje = "Empresa";
                            throw new IllegalArgumentException("Ingrese Empresa");
                        }
                        if (txtLink.getText().equals("")) {
                            txtLink.requestFocus();
                            //mensaje = "Link del proveedor";
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

                        ProveedorController proveedorController = new ProveedorController();
                        proveedorController.nuevo(provedor);

                    }
                    cancelarButton.doClick();


                } catch (IllegalArgumentException e) {
                    JOptionPane.showMessageDialog(null, e.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                } catch (ParseException e) {
                    JOptionPane.showMessageDialog(null, "Verifique la información ingresada. "+e.getMessage(), "Datos inválidos", JOptionPane.ERROR_MESSAGE);
                }

            }
        });
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


}
