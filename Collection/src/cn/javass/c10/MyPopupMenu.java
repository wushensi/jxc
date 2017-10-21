package cn.javass.c10;

import java.awt.Button;
import java.awt.Color;
import java.awt.Font;
import java.awt.Frame;
import java.awt.MenuItem;
import java.awt.PopupMenu;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MyPopupMenu extends Frame implements ActionListener {

	/**
	 * @param args
	 */
	//111111
	private static PopupMenu p = null;
	private static Button b = null;
	
	//222222
	public void init(){
		Font f=new Font("Serif",Font.BOLD+Font.ITALIC,30);
		b = new Button("Press Me");
		b.setBackground(Color.BLUE);
		b.setFont(f);
		b.addActionListener(this);
		p = new PopupMenu("Popup");
		MenuItem item1 = new MenuItem("Save");
		MenuItem item2 = new MenuItem("Load");
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
