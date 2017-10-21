package cn.javass.c12.awt.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class QueryPanel extends JPanel {
	private JTextField txt_name;
	private JTextField txt_sex;
	private JTextField txt_age;
	private JTextField txt_address;
	private JFrame queryFrame;
	private String queryStr=null;
	private static List list=null;
	private List queryList=null;
	private static List initList=new ArrayList();
	private static int flag=0;
	
	/**
	 * Create the panel.
	 */
	public boolean ListQuery(List list,String queryStr){
		boolean flag=false;
		Object[] objs=(Object[]) list.toArray();
		list.clear();
		for(Object obj:objs){
			String str=(String)obj;
			if(queryStr.equals((str.substring(0, str.indexOf(","))))){
				flag=true;
				list.add(obj);
			}
		}
		return flag;
	}
	public void query(){
		//1:收集参数
		queryStr=this.txt_name.getText();

		//2、组织参数
		
		//3、添加到组件上
		queryList=list;
		boolean flag=this.ListQuery(queryList, queryStr);
		System.out.println("queryList---"+queryList);
		//4:根据返回值切换界面
		if(flag){
			this.queryFrame.getContentPane().removeAll();
			ListPanel listPanel=new ListPanel(queryList);
			listPanel.setMainFrame(this.queryFrame);
			//listPanel.setList(queryList);
			this.queryFrame.getContentPane().add(listPanel);
			this.queryFrame.getContentPane().validate();
		}
		
	}
	public void back(){
		/*if(flag==0){
			queryAllList=list;
		}else{
			queryAllList=this.queryList;
		}
		flag++;*/
		this.queryFrame.getContentPane().removeAll();
		ListPanel listPanel=new ListPanel(initList);
		listPanel.setMainFrame(this.queryFrame);
		listPanel.setList(initList);
		this.queryFrame.getContentPane().add(listPanel);
		this.queryFrame.getContentPane().validate();
		
	}
	public QueryPanel(JFrame queryFrame,List list) {
		this.queryFrame=queryFrame;
		this.list=list;
		if(flag==0){
			Object[] objs=list.toArray();
			for(Object obj:objs){
				this.initList.add(obj);
			}
			flag++;
			System.out.println("flag constructor queryAllList---"+initList);
		}
		System.out.println("constructor queryAllList---"+initList);
		this.setSize(800, 600);
		this.setLayout(null);
		
		JLabel label = new JLabel("\u67E5\u8BE2");
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
		
		txt_name = new JTextField();
		txt_name.setBounds(45, 63, 86, 20);
		
		
		
		add(txt_name);
		
		txt_name.setColumns(10);
	
		txt_sex = new JTextField();
		txt_sex.setColumns(10);
		txt_sex.setBounds(45, 112, 86, 20);
		
		
		
		add(txt_sex);
		
		txt_age = new JTextField();
		txt_age.setColumns(10);
		txt_age.setBounds(215, 63, 86, 20);
		
		
		
		add(txt_age);
		
		txt_address = new JTextField();
		txt_address.setColumns(10);
		txt_address.setBounds(215, 112, 86, 20);
		
		
		add(txt_address);
		
		JButton btn_query = new JButton("\u67E5\u8BE2");
		btn_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				query();
			}
		});
		btn_query.setBounds(75, 236, 89, 23);
		add(btn_query);
		
		JButton btn_back = new JButton("\u8FD4\u56DE");
		btn_back.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				back();
			}
		});
		btn_back.setBounds(215, 236, 89, 23);
		add(btn_back);
	}
}
