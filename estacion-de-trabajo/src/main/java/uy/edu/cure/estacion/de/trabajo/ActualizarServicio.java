package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Servicio;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.LlenarCombobox;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ActualizarServicio extends JFrame {
    private JComboBox cmbServicio;
    private JButton buttonAcept;
    private JButton buttonCancel;
    private JComboBox jcbCategoria;
    private JTextField inDescripcion;
    private JTextField inImagenes;
    private JTextField inPrecio;
    private JTextField inCiudadOrigen;
    private JTextField inCiudadDestino;
    private JLabel txtCiudadDestino;
    private JLabel txtCiudadOrigen;
    private JLabel txtPrecio;
    private JLabel imagenes;
    private String txtImagen1;
    private String txtImagen2;
    private String txtImagen3;
    private JLabel txtDescripcion;
    private JTextField inCategoria;
    private JPanel panelActServicio;
    private JComboBox cmbCiudadOrigen;
    private JComboBox cmbCiudadDestino;
    private JButton btnImagen1;
    private JButton btnImagen3;
    private JButton btnImagen2;
    private JLabel lblImagen1;
    private JLabel lblImagen2;
    private JLabel lblImagen3;
    private JLabel lblCiudadOrigen;
    private JLabel lblCiudadDestino;
    private JLabel lblCategoria;
    private JComboBox jcbInCategoria;
    private Integer txtIdServicio;

    public ActualizarServicio() {
        final LlenarCombobox llenarCombobox = new LlenarCombobox();
        cmbServicio.setModel(llenarCombobox.cargarComboServicios());
        cmbCiudadOrigen.setModel(llenarCombobox.cargarComboCiudad(cmbCiudadOrigen));
        cmbCiudadDestino.setModel(llenarCombobox.cargarComboCiudad(cmbCiudadDestino));

        cmbServicio.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Servicio servicio = (Servicio) cmbServicio.getSelectedItem();
                txtIdServicio = servicio.getId();
                inDescripcion.setText(servicio.getDescripcion());
                String precio = Double.toString(servicio.getPrecio());
                inPrecio.setText(precio);
                lblCiudadOrigen.setText(servicio.getOrigen().getNombre());
                lblCiudadDestino.setText(servicio.getDestino().getNombre());
                String imagen;
                ImageIcon icon;
                Icon icono;
                imagen = servicio.getImagenes().get(0);
                if (imagen != null) {
                    icon = new ImageIcon(imagen.toString());
                    icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen1.getWidth(), lblImagen1.getHeight(), Image.SCALE_DEFAULT));
                    lblImagen1.setIcon(icono);
                }
                imagen = servicio.getImagenes().get(1);
                if (imagen != null) {
                    icon = new ImageIcon(imagen.toString());
                    icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen2.getWidth(), lblImagen2.getHeight(), Image.SCALE_DEFAULT));
                    lblImagen2.setIcon(icono);
                }
                imagen = servicio.getImagenes().get(2);
                if (imagen != null) {
                    icon = new ImageIcon(imagen.toString());
                    icono = new ImageIcon(icon.getImage().getScaledInstance(lblImagen3.getWidth(), lblImagen3.getHeight(), Image.SCALE_DEFAULT));
                    lblImagen3.setIcon(icono);
                }
            }
        });
        buttonCancel.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                panelActServicio.setVisible(false);
            }
        });

        btnImagen1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LlenarCombobox llenarCombobox1 = new LlenarCombobox();
                txtImagen1 = llenarCombobox.seleccionarImagen(lblImagen1, txtImagen1);
            }
        });
        btnImagen2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LlenarCombobox llenarCombobox1 = new LlenarCombobox();
                txtImagen2 = llenarCombobox.seleccionarImagen(lblImagen2, txtImagen2);
            }
        });
        btnImagen3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                LlenarCombobox llenarCombobox1 = new LlenarCombobox();
                txtImagen3 = llenarCombobox.seleccionarImagen(lblImagen3, txtImagen3);
            }
        });
    }


    public JComboBox getCmbServicio() {
        return cmbServicio;
    }

    public void setCmbServicio(JComboBox cmbServicio) {
        this.cmbServicio = cmbServicio;
    }

    public JButton getButtonAcept() {
        return buttonAcept;
    }

    public void setButtonAcept(JButton buttonAcept) {
        this.buttonAcept = buttonAcept;
    }

    public JButton getButtonCancel() {
        return buttonCancel;
    }

    public void setButtonCancel(JButton buttonCancel) {
        this.buttonCancel = buttonCancel;
    }

    public JComboBox getJcbCategoria() {
        return jcbCategoria;
    }

    public void setJcbCategoria(JComboBox jcbCategoria) {
        this.jcbCategoria = jcbCategoria;
    }

    public JTextField getInDescripcion() {
        return inDescripcion;
    }

    public void setInDescripcion(JTextField inDescripcion) {
        this.inDescripcion = inDescripcion;
    }

    public JTextField getInImagenes() {
        return inImagenes;
    }

    public void setInImagenes(JTextField inImagenes) {
        this.inImagenes = inImagenes;
    }

    public JTextField getInPrecio() {
        return inPrecio;
    }

    public void setInPrecio(JTextField inPrecio) {
        this.inPrecio = inPrecio;
    }

    public JTextField getInCiudadOrigen() {
        return inCiudadOrigen;
    }

    public void setInCiudadOrigen(JTextField inCiudadOrigen) {
        this.inCiudadOrigen = inCiudadOrigen;
    }

    public JTextField getInCiudadDestino() {
        return inCiudadDestino;
    }

    public void setInCiudadDestino(JTextField inCiudadDestino) {
        this.inCiudadDestino = inCiudadDestino;
    }

    public JLabel getTxtCiudadDestino() {
        return txtCiudadDestino;
    }

    public void setTxtCiudadDestino(JLabel txtCiudadDestino) {
        this.txtCiudadDestino = txtCiudadDestino;
    }

    public JLabel getTxtCiudadOrigen() {
        return txtCiudadOrigen;
    }

    public void setTxtCiudadOrigen(JLabel txtCiudadOrigen) {
        this.txtCiudadOrigen = txtCiudadOrigen;
    }

    public JLabel getTxtPrecio() {
        return txtPrecio;
    }

    public void setTxtPrecio(JLabel txtPrecio) {
        this.txtPrecio = txtPrecio;
    }

    public JLabel getImagenes() {
        return imagenes;
    }

    public void setImagenes(JLabel imagenes) {
        this.imagenes = imagenes;
    }

    public JLabel getTxtDescripcion() {
        return txtDescripcion;
    }

    public void setTxtDescripcion(JLabel txtDescripcion) {
        this.txtDescripcion = txtDescripcion;
    }

    public JTextField getInCategoria() {
        return inCategoria;
    }

    public void setInCategoria(JTextField inCategoria) {
        this.inCategoria = inCategoria;
    }

    public JPanel getPanelActServicio() {
        return panelActServicio;
    }

    public void setPanelActServicio(JPanel panelActServicio) {
        this.panelActServicio = panelActServicio;
    }

    public JComboBox getCmbCiudadOrigen() {
        return cmbCiudadOrigen;
    }

    public void setCmbCiudadOrigen(JComboBox cmbCiudadOrigen) {
        this.cmbCiudadOrigen = cmbCiudadOrigen;
    }

    public JComboBox getCmbCiudadDestino() {
        return cmbCiudadDestino;
    }

    public void setCmbCiudadDestino(JComboBox cmbCiudadDestino) {
        this.cmbCiudadDestino = cmbCiudadDestino;
    }

    public JButton getBtnImagen1() {
        return btnImagen1;
    }

    public void setBtnImagen1(JButton btnImagen1) {
        this.btnImagen1 = btnImagen1;
    }

    public JButton getBtnImagen3() {
        return btnImagen3;
    }

    public void setBtnImagen3(JButton btnImagen3) {
        this.btnImagen3 = btnImagen3;
    }

    public JButton getBtnImagen2() {
        return btnImagen2;
    }

    public void setBtnImagen2(JButton btnImagen2) {
        this.btnImagen2 = btnImagen2;
    }

    public JLabel getLblImagen1() {
        return lblImagen1;
    }

    public void setLblImagen1(JLabel lblImagen1) {
        this.lblImagen1 = lblImagen1;
    }

    public JLabel getLblImagen2() {
        return lblImagen2;
    }

    public void setLblImagen2(JLabel lblImagen2) {
        this.lblImagen2 = lblImagen2;
    }

    public JLabel getLblImagen3() {
        return lblImagen3;
    }

    public void setLblImagen3(JLabel lblImagen3) {
        this.lblImagen3 = lblImagen3;
    }

    public JComboBox getJcbInCategoria() {
        return jcbInCategoria;
    }

    public void setJcbInCategoria(JComboBox jcbInCategoria) {
        this.jcbInCategoria = jcbInCategoria;
    }

    public Integer getTxtIdServicio() {
        return txtIdServicio;
    }

    public void setTxtIdServicio(Integer txtIdServicio) {
        this.txtIdServicio = txtIdServicio;
    }
}


