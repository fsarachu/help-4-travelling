package uy.edu.cure.estacion.de.trabajo;

import java.awt.EventQueue;

import javax.swing.JFrame;

public class Main {

	private JFrame frame;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PrincipalForm window = new PrincipalForm();
					window.setBounds(20,20,700,700);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}