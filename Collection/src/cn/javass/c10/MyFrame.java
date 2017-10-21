package cn.javass.c10;

import java.awt.Button;
import java.awt.Color;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
public class MyFrame extends Frame implements ActionListener {
	public static FileDialog d=null; 
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyFrame mf=new MyFrame();
		mf.setSize(500, 500);
		mf.setBackground(Color.RED);
		
		
		
		Panel p=new Panel();
		
		p.setBackground(Color.BLACK);
		Button b=new Button("Button");
		b.setBackground(Color.RED);
		b.addActionListener(new MyFrame());
		p.add(b);
		p.setSize(100, 200);
		d=new FileDialog(mf,"FileDialog");
		/*d.setSize(200,200);
		d.add(new Label("HelloWorld"));*/
		//d.pack();
		ScrollPane sp=new ScrollPane();
		
		sp.setSize(100, 100);
		sp.setBackground(Color.WHITE);
		sp.add(p);
		mf.add(sp);
		mf.setVisible(true);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		d.setVisible(true);
	}

}