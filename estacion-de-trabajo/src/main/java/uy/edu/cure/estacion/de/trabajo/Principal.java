package uy.edu.cure.estacion.de.trabajo;

import javax.swing.*;
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
    //private JFrame frame;
    private JPanel panelMain;

    public Principal() {
        Hardcodeo hardcodeo = new Hardcodeo();
        setLayout(null);
        menuBar = new JMenuBar();
        setJMenuBar(menuBar);

        menu1 = new JMenu("Altas");
        menuBar.add(menu1);

        item1 = new JMenuItem("Usuario");
        item1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/usuario.png")));
        menu1.add(item1);


        item2 = new JMenuItem("Categoria");
        item2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/categoria.png")));
        menu1.add(item2);

        item3 = new JMenuItem("Servicio");
        item3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/servicios.jpg")));
        menu1.add(item3);

        item4 = new JMenuItem("Promocion");
        item4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/promo.png")));
        menu1.add(item4);

        menu2 = new JMenu("Reservas");
        menuBar.add(menu2);

        item5 = new JMenuItem("Actualizar Servicio");
        item5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizarServicio.png")));
        menu2.add(item5);

        item6 = new JMenuItem("Realizar Reserva");
        item6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/reserva.png")));
        menu2.add(item6);

        item7 = new JMenuItem("Cancelar Reserva");
        item7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelarReserva.jpeg")));
        menu2.add(item7);

        item8 = new JMenuItem("Actualizar Estado de Reserva");
        item8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/actualizarEstado.jpeg")));
        menu2.add(item8);

        menu3 = new JMenu("Ver Informacion");
        menuBar.add(menu3);

        item9 = new JMenuItem("Ver");
        item9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/listadoCliente.jpeg")));
        menu3.add(item9);

        menu4 = new JMenu("Salir");
        menuBar.add(menu4);

        item10 = new JMenuItem("Salir");
        item10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/imagenes/cancelarReserva.jpeg")));
        menu4.add(item10);

        item1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContentPane(new AltaUsuario().getPanelMain());
                setVisible(true);

            }
        });

        item2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContentPane(new AltaCategoria().getPanelMain());
                setVisible(true);
            }
        });
        item3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContentPane(new AltaServicio().getPanelServicio());
                setVisible(true);
            }
        });
        item4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContentPane(new AltaPromocion().getPanelPromocion());
                setVisible(true);

            }
        });
        item5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                setContentPane(new ActualizarServicio().getPanelActServicio());
                setVisible(true);
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
                setContentPane(new VerInfo().getPanelInfo());
                setVisible(true);
            }
        });
        item10.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent actionEvent) {
                JOptionPane.showMessageDialog(null, "Gracias por utilizar el software", "Chau", JOptionPane.INFORMATION_MESSAGE);
                System.exit(0);
            }
        });

    }

}
