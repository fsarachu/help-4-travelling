package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

public class Principal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenuItem item1;
    private JMenuItem item2;
    private JMenuItem item3;
    private JMenuItem item4;
    private JMenuItem item5;
    private JMenuItem item6;
    private JMenuItem item7;
    private JMenuItem item8;
    private JMenuItem item9;
    private JMenuItem item10;
    private JMenuItem item11;
    private JMenuItem item12;
    private JMenuItem item13;

    private JFrame frame;

        public Principal() {
            setLayout(null);
            menuBar = new JMenuBar();
            setJMenuBar(menuBar);

            menu1 = new JMenu("Altas");
            menuBar.add(menu1);

            item1 = new JMenuItem("Usuario");
            menu1.add(item1);

            item2 = new JMenuItem("Categoria");
            menu1.add(item2);

            item3 = new JMenuItem("Servicio");
            menu1.add(item3);

            item4 = new JMenuItem("Promocion");
            menu1.add(item4);

            menu2 = new JMenu("Reservas");
            menuBar.add(menu2);

            item5 = new JMenuItem("Actualizar Servicio");
            menu2.add(item5);

            item6 = new JMenuItem("Realizar Reserva");
            menu2.add(item6);

            item7 = new JMenuItem("Cancelar Reserva");
            menu2.add(item7);

            item8 = new JMenuItem("Actualizar Estado de Reserva");
            menu2.add(item8);

            menu3 = new JMenu("Ver Informacion");
            menuBar.add(menu3);

            item9 = new JMenuItem("Cliente");
            menu3.add(item9);

            item10 = new JMenuItem("Proveedor");
            menu3.add(item10);

            item11 = new JMenuItem("Servicio");
            menu3.add(item11);

            item12 = new JMenuItem("Promocion");
            menu3.add(item12);

            item13 = new JMenuItem("Reserva");
            menu3.add(item13);

        }
}
