package cn.javass.c10;
import java.awt.Button;
import java.awt.Canvas;
import java.awt.CheckboxMenuItem;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Label;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Panel;
public class FrameWithPanel extends Frame{

	public FrameWithPanel(String string) {
		// TODO Auto-generated constructor stub
		super(string);
	}

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		MyCanvas mc=new MyCanvas();
		mc.setSize(100,100);
		mc.setBackground(Color.WHITE);
		FrameWithPanel fwp=new FrameWithPanel("frame with panel");
		Panel pan=new Panel();
		fwp.setSize(500,500);
		fwp.setBackground(Color.BLACK);
		fwp.setLocation(100, 100);
		
		Button b=new Button("Test");
		b.setBackground(Color.RED);
		
		Label l=new Label("Hello");
		l.setSize(20,20);
		l.setBackground(Color.GREEN);
		pan.add(mc);
		
		pan.add(b);
		pan.add(l);
		
		pan.setBackground(Color.GRAY);

		fwp.add(pan);
		MenuBar menu=new MenuBar();
		Menu m1=new Menu("File");
		MenuItem mi1=new MenuItem("new File");
		MenuItem mi2=new MenuItem("open File");
		MenuItem mi3=new MenuItem("save as");
		CheckboxMenuItem cmi=new CheckboxMenuItem("Persistent");
		m1.add(cmi);
		m1.add(mi3);
		m1.add(mi1);
		m1.add(mi2);
		Menu m2=new Menu("Edit");
		Menu m3=new Menu("Source");
		m2.add(m1);
		menu.add(m2);
		menu.add(m3);
		fwp.setMenuBar(menu);
		fwp.setVisible(true);
	}
	
	
	

}

class MyCanvas extends Canvas{
	@Override
	public void paint(Graphics g){
		g.setColor(Color.YELLOW);
		g.drawLine(1,1,10,20);
		
		g.drawString("helloworld", 10, 60);
	}
}
