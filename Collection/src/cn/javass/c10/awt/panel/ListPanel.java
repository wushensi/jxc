package cn.javass.c10.awt.panel;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JList;
import javax.swing.JPanel;

public class ListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private static List list=null;
	private static List queryAllList=null;
	private String listInfo=null;
	JList jList_address =null;

	public static List getList() {
		return list;
	}

	public static void setList(List list) {
		ListPanel.list = list;
	}

	public void showJList_address(JList jList_address){
		System.out.println("list--->"+list);
		if(list!=null){
			//1:
			//Collection col=list
			
			//2:
			Object objs[]=list.toArray();
			
			//3:将数据添加到组件上
			jList_address.setListData(objs);
		}	
	}
	
	private JFrame mainFrame=null;
	public JFrame getMainFrame() {
		return mainFrame;
	}

	public void setMainFrame(JFrame mainFrame) {
		this.mainFrame = mainFrame;
	}

	public ListPanel(List list) {
		this.list=list;
		queryAllList=list;
		this.setSize(800, 600);
		this.setLayout(null);
		JButton btn_add = new JButton("\u8F6C\u5230\u65B0\u589E");
		btn_add.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toAdd();
			}
		});
		btn_add.setBounds(231, 423, 89, 23);
		add(btn_add);

		JButton btn_update = new JButton("\u8F6C\u5230\u4FEE\u6539");
		btn_update.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toUpdate();
			}
		});
		btn_update.setBounds(357, 423, 89, 23);
		add(btn_update);
		
		jList_address = new JList();
		jList_address.setBounds(258, 220, 433, 134);
		add(jList_address);
		showJList_address(jList_address);
		
		JButton btn_delete = new JButton("\u8F6C\u5230\u5220\u9664");
		btn_delete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toDelete();
			}
		});
		btn_delete.setBounds(602, 423, 89, 23);
		add(btn_delete);
		
		JButton btn_query = new JButton("\u67E5\u8BE2");
		btn_query.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				toQuery();
			}
		});
		btn_query.setBounds(474, 423, 89, 23);
		add(btn_query);
		
	}

	// /////////////
	public  void toAdd() {
		this.mainFrame.getContentPane().removeAll();
		AddPanel addPanel=new AddPanel();
		addPanel.setAddFrame(this.mainFrame);
		this.mainFrame.getContentPane().add(addPanel);
		this.mainFrame.getContentPane().validate();
		
	}

	public  void toUpdate() {
		this.mainFrame.getContentPane().removeAll();
		listInfo=(String)this.jList_address.getSelectedValue();
		this.mainFrame.getContentPane().add(new UpdatePanel(this.mainFrame,list,listInfo));
		this.mainFrame.getContentPane().validate();
	}
	
	public  void toDelete() {
		this.mainFrame.getContentPane().removeAll();
		listInfo=(String)this.jList_address.getSelectedValue();
		this.mainFrame.getContentPane().add(new DeletePanel(this.mainFrame,list,listInfo));
		this.mainFrame.getContentPane().validate();
	}
	
	public  void toQuery() {
		this.mainFrame.getContentPane().removeAll();
		this.mainFrame.getContentPane().add(new QueryPanel(this.mainFrame,list));
		this.mainFrame.getContentPane().validate();
	}
}
