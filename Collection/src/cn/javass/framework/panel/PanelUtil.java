package cn.javass.framework.panel;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class PanelUtil {

	public static void changePanel(JFrame frame,JPanel panel){
		frame.getContentPane().removeAll();
		frame.getContentPane().add(panel);
		frame.getContentPane().validate();
	}
}
