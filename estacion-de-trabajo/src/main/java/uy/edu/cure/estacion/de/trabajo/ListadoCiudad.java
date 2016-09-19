package uy.edu.cure.estacion.de.trabajo;

import uy.edu.cure.servidor.central.dto.Ciudad;
import uy.edu.cure.servidor.central.lib.controlErroresInteface.LlenarCombobox;
import uy.edu.cure.servidor.central.lib.controllers.CiudadController;
import uy.edu.cure.servidor.central.lib.controllers.ProductoController;

import javax.swing.*;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;


public class ListadoCiudad {
    private JComboBox cmbCiudades;
    private Integer txtIdCiudad;
    public ListadoCiudad() {
        LlenarCombobox llenarCombobox = new LlenarCombobox();
        llenarCombobox.cargarComboCiudad(cmbCiudades);


        cmbCiudades.addItemListener(new ItemListener() {
            @Override
            public void itemStateChanged(ItemEvent itemEvent) {
                Ciudad ciudadOrigen = (Ciudad) cmbCiudades.getSelectedItem();
                txtIdCiudad = ciudadOrigen.getId();
                ProductoController productoController = new ProductoController();
                //productoController.
            }
        });
    }
}
