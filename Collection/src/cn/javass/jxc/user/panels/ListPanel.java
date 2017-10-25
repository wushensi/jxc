package cn.javass.jxc.user.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.user.business.ebo.UserEbo;
import cn.javass.jxc.user.business.factory.UserEbiFactory;
import cn.javass.jxc.user.vo.BookModel;

public class ListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame frame;
	private static List<BookModel> list;
	
	private JList jlist;
	public ListPanel(){
		this.init(list);
	}
	
	public void Add(){
		/*frame.getContentPane().removeAll();
		frame.getContentPane().add(new AddPanel(frame));
		frame.getContentPane().validate();*/
		PanelUtil.changePanel(frame, new AddPanel(frame));
	}
	
	public void Update(String uuid){
		PanelUtil.changePanel(frame, new UpdatePanel(frame,uuid));
	}
	
	public void Delete(String uuid){
		PanelUtil.changePanel(frame, new DeletePanel(frame,uuid));
	}
	
	public void Query(){
		PanelUtil.changePanel(frame, new QueryPanel(frame));
	}
	
	public ListPanel(JFrame frame) {
		this.frame=frame;
		this.init(list);
	}
	
	public ListPanel(JFrame frame,List<BookModel> list) {
		this.frame=frame;
		this.list=list;
		this.init(list);
	}
	
	public void init(List<BookModel> dataList){
		this.setSize(800, 600);
		setLayout(null);
		JLabel label = new JLabel("\u7528\u6237\u5217\u8868");
		label.setBounds(10, 31, 107, 14);
		add(label);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0\u7528\u6237");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		btnAdd.setBounds(10, 181, 89, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("\u66F4\u65B0\u7528\u6237");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookModel model=new BookModel();
				model=(BookModel)jlist.getSelectedValue();
				if(model!=null){
					Update(model.getUuid());
				}else{
					JOptionPane.showMessageDialog(null, "对不起，请选择一个用户进行更新");
				}
			}
		});
		btnUpdate.setBounds(125, 181, 89, 23);
		add(btnUpdate);
		JList list = new JList();
		JScrollPane scroll=new JScrollPane(list);
		scroll.setBounds(25, 71, 171, 86);
		
		//原来是一个List来回传递，现在不需要了，任何Panel都直接跟Ebo要数据就可以
		UserEbo userEbo=(UserEbo) UserEbiFactory.getUserEbi();
		if(dataList!=null){
			list.setListData(dataList.toArray());
		}else{
			list.setListData((userEbo.getByAll()).toArray());
		}
		list.setBounds(25, 71, 171, 86);
		add(scroll);
		jlist=list;
		
		
		JButton btnDel = new JButton("\u5220   \u9664");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				BookModel model=new BookModel();
				model=(BookModel)jlist.getSelectedValue();
				if(model!=null){
					Delete(model.getUuid());
				}else{
					JOptionPane.showMessageDialog(null, "对不起，请选择一个用户进行删除");
				}
			}
		});
		btnDel.setBounds(244, 181, 89, 23);
		add(btnDel);
		
		JButton btnQuery = new JButton("\u67E5\u8BE2\u7528\u6237");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query();
			}
		});
		btnQuery.setBounds(361, 181, 89, 23);
		add(btnQuery);
		
	}
}
