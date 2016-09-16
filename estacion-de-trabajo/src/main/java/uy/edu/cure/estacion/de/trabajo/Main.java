package uy.edu.cure.estacion.de.trabajo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.setBounds(20,20,700,500);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}