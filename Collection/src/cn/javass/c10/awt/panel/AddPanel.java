package cn.javass.c10.awt.panel;

import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddPanel extends JPanel {
	private JTextField txt_name;
	private JTextField txt_sex;
	private JTextField txt_age;
	private JTextField txt_address;
	private JFrame addFrame=null;
	@java.lang.SuppressWarnings(value={"uncheck"})
	private static List list=new ArrayList();
	public JFrame getAddFrame() {
		return addFrame;
	}
	public void setAddFrame(JFrame addFrame) {
		this.addFrame = addFrame;
	}
	/**
	 * Create the panel.
	 */
	public void Add(){
		//1、获取参数
		String name=this.txt_name.getText();
		String age=this.txt_age.getText();
		String sex=this.txt_sex.getText();
		String address=this.txt_address.getText();
		
		//2、model object
		String str=name+","+age+","+sex+","+address;
		
		//3: collection storage
		boolean flag=list.add(str);
		//4: 成功返回值并换界面
		if(flag){
			ListPanel listPanel=new ListPanel(list);
			listPanel.setMainFrame(addFrame);
			listPanel.setList(list);
			System.out.println("list AddPanel---"+list);
			this.showList(list);
			this.addFrame.getContentPane().removeAll();
			this.addFrame.getContentPane().setLayout(new BorderLayout());
			this.addFrame.getContentPane().add(listPanel);
			this.addFrame.getContentPane().validate();
		}
		
	}
	public void showList(List list){
		Object[] objs=list.toArray();
		for(Object obj:objs){
			System.out.println(obj);
		}
	}
	public AddPanel() {
		this.setSize(800, 600);
		this.setLayout(null);
		
		JButton button = new JButton("\u65B0\u589E");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		button.setBounds(114, 180, 89, 23);
		add(button);
		
		JButton button_1 = new JButton("\u8FD4\u56DE");
		button_1.setBounds(248, 180, 89, 23);
		add(button_1);
		
		JLabel label = new JLabel("\u5730\u5740\u8584");
		label.setBounds(320, 11, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(22, 42, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(22, 78, 46, 14);
		add(label_2);
		
		JLabel lblNewLabel = new JLabel("\u5E74\u9F84");
		lblNewLabel.setBounds(192, 47, 46, 14);
		add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u4F4F\u5740");
		label_3.setBounds(192, 78, 46, 14);
		add(label_3);
		
		txt_name = new JTextField();
		txt_name.setBounds(65, 42, 86, 20);
		add(txt_name);
		txt_name.setColumns(10);
		
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(65, 75, 86, 20);
		add(txt_sex);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(232, 39, 86, 20);
		add(txt_age);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(232, 75, 86, 20);
		add(txt_address);
	}
}
