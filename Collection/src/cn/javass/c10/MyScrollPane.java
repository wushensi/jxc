package cn.javass.c10;

import java.awt.Button;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Panel;
import java.awt.ScrollPane;
import java.awt.TextField;

public class MyScrollPane extends Frame{

	public MyScrollPane(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyScrollPane msp=new MyScrollPane("ScrollPane Test");
		ScrollPane sp=new ScrollPane(ScrollPane.SCROLLBARS_ALWAYS);
		TextField t=new TextField(100);
		sp.add(t);
		msp.add(sp);
		msp.setBounds(30, 30, 250, 200); 
		msp.setVisible(true);
	}

}
