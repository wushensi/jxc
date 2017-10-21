package cn.javass.c10.awt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;

import cn.javass.c10.awt.panel.ListPanel;

public class AddressApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddressApp window = new AddressApp();
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
	public AddressApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setSize(800,600);
		frame.getContentPane().setLayout(new BorderLayout());
		ListPanel listPanel = new ListPanel(null);
		listPanel.setMainFrame(frame);
		frame.getContentPane().add(listPanel);
	}
	
	public JPanel getJContentPane(){
		return null;
	}
	
	private JFrame getJFrame(){
		return frame;
	}

}
