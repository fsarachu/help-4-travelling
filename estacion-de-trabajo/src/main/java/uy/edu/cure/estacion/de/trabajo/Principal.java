package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Principal extends JFrame {
    private JMenuBar menuBar;
    private JMenu menu1;
    private JMenu menu2;
    private JMenu menu3;
    private JMenu menu4;
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
    private JMenuItem item14;
    private JFrame frame;

    public Principal() {
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Altas");
        menuBar.add(menu1);

        item1 = new JMenuItem("Usuario");
        item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagen/usuario.png")));
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

        menu4 = new JMenu("Salir");
        menuBar.add(menu4);

        item14 = new JMenuItem("Salir");
        menu4.add(item14);

        item14.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar el software", "Chau", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JFrame frame = new JFrame("AltaUsuario");
                frame.setContentPane(new AltaUsuario().getPanelMain());
                frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
                frame.setResizable(false);
                frame.setBounds(20,30,450,300);
                //frame.pack();
                frame.setVisible(true);
            }
        });
        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Categoria Seleccionada", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Servicio Seleccionada", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Promocion", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Actualizar Servicio", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ingresar Reserva", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item7.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Cancelar Reserva", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item8.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Actualizar estado de la Reserva", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item9.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ver Cliente", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ver Proveedor", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item11.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ver Servicio", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item12.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ver Promocion", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });
        item13.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Opcion Ver Reserva", "Atencion", JOptionPane.INFORMATION_MESSAGE);
            }
        });

    }

}
