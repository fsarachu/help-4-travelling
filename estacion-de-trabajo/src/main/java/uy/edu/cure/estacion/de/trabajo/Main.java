package uy.edu.cure.estacion.de.trabajo;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.SpringLayout;
//ssdgsgss
public class Main {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Principal window = new Principal();
					window.setBounds(20,20,400,300);
					window.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}