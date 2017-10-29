package cn.javass.jxc.in.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import org.jdesktop.swingx.JXDatePicker;

import cn.javass.framework.io.SerialUtil;
import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.in.vo.InQueryMain;



public class QueryPanel extends JPanel {
	
	private JTextField txtInId;
	private JFrame jframe;
	private JTextField txtId;
	private static JComboBox type;
	private JXDatePicker dateLess,dateMore;
	public QueryPanel() {
		this.init();
	}
	public QueryPanel(JFrame jframe) {
		
		this.jframe=jframe;
		this.init();
	}
	/**
	 *  Query the panel.
	 */
	public void Query(){
		//收集参数
		InMainEbi ebi=InMainEbiFactory.getInMainEbi();
		List<InMain> queryList=new ArrayList<InMain>();
		InQueryMain inQueryMain=new InQueryMain();
		inQueryMain.setId(txtId.getText());
		inQueryMain.setInUserId(txtInId.getText());
		if(dateLess.getDate()==null){
			inQueryMain.setInDate(0);
		}else{
			inQueryMain.setInDate(dateLess.getDate().getTime());
		}
		if(dateMore.getDate()==null){
			inQueryMain.setInQueryDate(0);
		}else{
			inQueryMain.setInQueryDate(dateMore.getDate().getTime());
		}
		queryList=(List<InMain>) ebi.getByCondition(inQueryMain);
		//组织参数
		//遍历list 找到符合要求的对象 并加入到新的List
		//返回list到界面
		PanelUtil.changePanel(jframe, new InListPanel(jframe,queryList));
	}
	/**
	 * Back the ListPanel
	 */
	public void Back(){
		PanelUtil.changePanel(jframe, new InListPanel(jframe));
	}
	public void init(){
		setLayout(null);
		this.setSize(800, 600);
		
		JButton btnDelete = new JButton("\u67E5   \u627E");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Query();
			}
		});
		btnDelete.setBounds(36, 242, 89, 23);
		add(btnDelete);
		
		JButton btnBack = new JButton("\u8FD4   \u56DE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setBounds(187, 242, 89, 23);
		add(btnBack);
		
		JLabel lblNewLabel = new JLabel("\u8FDB\u8D27\u4EBA\u5458");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		txtInId = new JTextField();
		txtInId.setBounds(151, 66, 86, 20);
		add(txtInId);
		txtInId.setColumns(10);
		
		
		JLabel lblUuid = new JLabel("\u8FDB\u8D27\u7F16\u53F7");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setBounds(151, 27, 86, 20);
		add(txtId);
		
		JLabel lblNewLabel_1 = new JLabel("\u8FDB\u8D27\u65F6\u95F4");
		lblNewLabel_1.setBounds(36, 112, 69, 17);
		add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C0F\u4E8E");
		lblNewLabel_2.setBounds(115, 113, 46, 14);
		add(lblNewLabel_2);
		
		JLabel label_2 = new JLabel("\u5927\u4E8E");
		label_2.setBounds(274, 113, 46, 14);
		add(label_2);
		
		//第三方日期控件
		JXDatePicker datePickLess = new JXDatePicker();
				
		//设置 date日期
		//datePickLess.setDate(new Date());
		
		//inDate=datePickLess;
		datePickLess.setBounds(151, 110, 110, 20); 
		add(datePickLess);
		
		//第三方日期控件
		JXDatePicker datePickMore = new JXDatePicker();
						
		// 设置 date日期
		//datePickMore.setDate(new Date());
		//inDate=datepick;
		datePickMore.setBounds(308, 110, 132, 20); 
		add(datePickMore);
		dateLess=datePickLess;
		dateMore=datePickMore;
	}
}
