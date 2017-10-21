package cn.javass.c10.awt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;

public class DemoActionListener {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DemoActionListener window = new DemoActionListener();
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
	public DemoActionListener() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JPanel panel = new JPanel();
		panel.setBounds(45, 45, 233, 100);
		frame.getContentPane().add(panel);

		JButton btnCreate = new JButton("Create");
		btnCreate.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				
				System.out.println("mouseMoved");
			}
		});
		btnCreate.addActionListener(/*
									 * new ActionListener() { public void
									 * actionPerformed(ActionEvent e) {
									 * System.out.println("HelloWorld"); for(int
									 * i=0;i<100;i++){
									 * System.out.print(i+"   ");
									 * 
									 * } } }
									 */
		new myAction());
		panel.add(btnCreate);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println(e.getActionCommand()+" Action Perform");
			}
		});
		panel.add(btnNewButton);
		frame.setTitle("myFrame");
	}
}

class myAction implements ActionListener,MouseMotionListener{

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		System.out.println(e.getActionCommand()+" Action Perform");
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}
}