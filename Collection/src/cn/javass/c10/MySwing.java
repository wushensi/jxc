package cn.javass.c10;

import java.awt.Color;
import java.awt.Font;
import java.awt.MenuItem;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

public class MySwing extends JFrame implements ActionListener {

	/**
	 * @param args
	 */
	//111111
	private static JPopupMenu p = null;
	private static JButton b = null;
	
	//222222
	public void init(){
		Font f=new Font("Serif",Font.BOLD+Font.ITALIC,30);
		b = new JButton("Press Me");
		b.setBackground(Color.BLUE);
		b.setFont(f);
		b.addActionListener(this);
		p = new JPopupMenu("Popup");
		JMenuItem item1 = new JMenuItem("Save");
		JMenuItem item2 = new JMenuItem("Load");
		p.add(item1);
		p.add(item2);
		this.setSize(300, 200);
		this.add(b);
		this.add(p);
		this.setVisible(true);
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyPopupMenu frame=new MyPopupMenu();
		frame.init();
	}
	//33333333
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		p.show(b, 0, 0);
		System.out.println("界面事件的处理方法");
		
	}

}
