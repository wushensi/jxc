package cn.javass.c10;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.Frame;
import java.awt.Panel;

import javax.swing.JFrame;

public class SwingDemo {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SwingDemo window = new SwingDemo();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
	}

	/**
	 * Create the application.
	 */
	public SwingDemo() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.WEST);
		
		Button button = new Button("Button");
		frame.getContentPane().add(button, BorderLayout.CENTER);
	}

}
