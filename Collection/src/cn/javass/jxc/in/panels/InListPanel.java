package cn.javass.jxc.in.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;
import java.util.Map;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.vo.InDetail;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.user.panels.ListPanel;


public class InListPanel extends JPanel {

	/**
	 * Create the panel.
	 */
	private JFrame frame;
	private static List<InMain> list;
	private Map<InMain,List<InDetail>> map;
	
	private JList jlist;
	private InMain updateMain;
	public InListPanel(){
		this.init(list,map);
	}
	
	public void Add(){
		PanelUtil.changePanel(frame, new AddInDetailPanel(frame));
	}
	
	public void Update(String uuid){
		PanelUtil.changePanel(frame, new UpdateInDetailPanel(frame,updateMain));
	}
	
	public void Delete(String mainID){
		PanelUtil.changePanel(frame, new DeleteInDetailPanel(frame,mainID));
	}
	
	public void Query(){
		PanelUtil.changePanel(frame, new QueryInDetailPanel(frame));
	}
	public void Back(){
		PanelUtil.changePanel(frame, new ListPanel(frame));
	}
	public InListPanel(JFrame frame) {
		this.frame=frame;
		this.init(list,map);
	}
	
	public InListPanel(JFrame frame,List<InMain> list) {
		this.frame=frame;
		this.list=list;
		this.init(list,map);
	}
	
	public InListPanel(Map<InMain,List<InDetail>> map,JFrame frame) {
		this.frame=frame;
		this.map=map;
		this.init(list,map);
	}
	
	public void init(List<InMain> dataList,final Map<InMain,List<InDetail>> map){
		this.setSize(800, 600);
		setLayout(null);
		JLabel label = new JLabel("\u8FDB\u8D27\u7BA1\u7406");
		label.setBounds(10, 31, 107, 14);
		add(label);
		
		JButton btnAdd = new JButton("\u6DFB\u52A0\u8FDB\u8D27");
		btnAdd.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		btnAdd.setBounds(10, 181, 89, 23);
		add(btnAdd);
		
		JButton btnUpdate = new JButton("\u66F4\u65B0\u8FDB\u8D27");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateMain=(InMain)jlist.getSelectedValue();
				if(updateMain!=null){
					Update(updateMain.getId());
				}else{
					JOptionPane.showMessageDialog(null, "对不起，请选择一个用户进行更新");
				}
			}
		});
		
		btnUpdate.setBounds(125, 181, 89, 23);
		add(btnUpdate);
		final JList mainJList = new JList();
		
		JScrollPane mainScroll=new JScrollPane(mainJList);
		mainScroll.setBounds(25, 71, 171, 86);
		
		final JList detailJList = new JList();
		
		JScrollPane detailScroll=new JScrollPane(detailJList);
		detailScroll.setBounds(268, 71, 263, 86);
		
		//原来是一个List来回传递，现在不需要了，任何Panel都直接跟Ebo要数据就可以
		final InMainEbi ebi=InMainEbiFactory.getInMainEbi();
		if(dataList!=null){
			mainJList.setListData(dataList.toArray());
		}else if(map!=null){
			mainJList.setListData(map.keySet().toArray());
		}else{
			mainJList.setListData((ebi.getByAll()).toArray());
		}
		
		mainJList.setBounds(25, 71, 171, 86);
		add(mainScroll);
		add(detailScroll);
		jlist=mainJList;
		
		mainJList.addListSelectionListener(new ListSelectionListener() {
			public void valueChanged(ListSelectionEvent e) {
				if (!e.getValueIsAdjusting()){
					if(map!=null){
						detailJList.setListData(map.get(mainJList.getSelectedValue()).toArray());
					}else{
						detailJList.setListData(ebi.getByMapAll().get(mainJList.getSelectedValue()).toArray());
					}
					
				}
			}
		});
		
		JButton btnDel = new JButton("\u5220   \u9664");
		btnDel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				InMain model=new InMain();
				model=(InMain)jlist.getSelectedValue();
				if(model!=null){
					Delete(model.getId());
				}else{
					JOptionPane.showMessageDialog(null, "对不起，请选择一个用户进行删除");
				}
			}
		});
		btnDel.setBounds(244, 181, 89, 23);
		add(btnDel);
		
		JButton btnQuery = new JButton("\u67E5\u8BE2\u8FDB\u8D27");
		btnQuery.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query();
			}
		});
		btnQuery.setBounds(361, 181, 89, 23);
		add(btnQuery);
		
		JButton btnBack = new JButton("\u8FD4   \u56DE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setBounds(478, 181, 89, 23);
		add(btnBack);
	}
}
