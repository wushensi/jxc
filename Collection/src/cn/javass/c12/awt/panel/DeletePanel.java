package cn.javass.c12.awt.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class DeletePanel extends JPanel {
	private JTextField txt_name;
	private JTextField txt_sex;
	private JTextField txt_age;
	private JTextField txt_address;
	private JFrame deleteFrame;
	private String getInfo=null;
	private static List list=null;

	/**
	 * Create the panel.
	 */
	public boolean ListDelete(List list,String oldStr){
		boolean flag=false;
		Object[] objs=list.toArray();
		list.clear();
		for(Object str:objs){
			if(str.equals(oldStr)){
				flag=true;
				continue;
			}
			list.add(str);
		}
		return flag;
	}
	public void delete(){
		//1:收集参数
		
		
		//2、组织参数
		
		//3、添加到组件上
		boolean flag=this.ListDelete(list, getInfo);
		
		//4:根据返回值切换界面
		if(flag){
			back();
		}
		
	}
	public void back(){
		this.deleteFrame.getContentPane().removeAll();
		ListPanel listPanel=new ListPanel(list);
		listPanel.setMainFrame(this.deleteFrame);
		listPanel.setList(list);
		this.deleteFrame.getContentPane().add(listPanel);
		this.deleteFrame.getContentPane().validate();
	}
	public DeletePanel(JFrame updateFrame,List list,String getInfo) {
		this.deleteFrame=updateFrame;
		this.list=list;
		this.getInfo=getInfo;
		this.setSize(800, 600);
		this.setLayout(null);
		
		JLabel label = new JLabel("\u5220\u9664");
		label.setBounds(131, 26, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u59D3\u540D");
		label_1.setBounds(10, 66, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u6027\u522B");
		label_2.setBounds(10, 115, 46, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u5E74\u9F84");
		label_3.setBounds(159, 66, 46, 14);
		add(label_3);
		
		JLabel label_4 = new JLabel("\u5730\u5740");
		label_4.setBounds(159, 115, 46, 14);
		add(label_4);
		String[] parameter=getInfo.split(",");
		txt_name = new JTextField();
		txt_name.setBounds(45, 63, 86, 20);
		
		txt_name.setText(parameter[0]);
		txt_name.setEditable(false);
		add(txt_name);
		
		txt_name.setColumns(10);
	
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(45, 112, 86, 20);
		
		txt_sex.setText(parameter[1]);
		txt_sex.setEditable(false);
		add(txt_sex);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(215, 63, 86, 20);
		
		txt_age.setText(parameter[2]);
		txt_age.setEditable(false);
		add(txt_age);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(215, 112, 86, 20);
		txt_address.setEditable(false);
		txt_address.setText(parameter[3]);
		add(txt_address);
		
		JButton button1 = new JButton("\u5220\u9664");
		button1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				delete();
			}
		});
		button1.setBounds(75, 236, 89, 23);
		add(button1);
		
		JButton button2 = new JButton("\u8FD4\u56DE");
		button2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		button2.setBounds(215, 236, 89, 23);
		add(button2);
	}
}
