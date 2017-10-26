package cn.javass.jxc;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;

import cn.javass.jxc.book.panels.BookListPanel;



/**
 * 在初始化jList时发现问题
 * 1、明文密码
 * 2、type显示真实值，需要转换(使用枚举来动态转换用户类型type值)
 * @author wushensi
 *
 */
public class JxcApp {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JxcApp window = new JxcApp();
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
	public JxcApp() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setLayout(new BorderLayout());
		frame.setSize(800, 600);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new BookListPanel(frame));
		//frame.getContentPane().add(new ListPanel(frame));
	}

}
