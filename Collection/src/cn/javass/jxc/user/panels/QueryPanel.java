package cn.javass.jxc.user.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.user.UserTypeEnum;
import cn.javass.jxc.user.business.ebi.UserEbi;
import cn.javass.jxc.user.business.factory.UserEbiFactory;
import cn.javass.jxc.user.vo.UserModel;
import cn.javass.jxc.user.vo.UserQueryModel;

public class QueryPanel extends JPanel {
	
	private JTextField txtName;
	private JFrame jframe;
	private JTextField txtUuid;
	private static JComboBox type;
	public QueryPanel() {
		this.init();
	}
	public QueryPanel(JFrame jframe) {
		
		this.jframe=jframe;
		this.init();
	}
	/**
	 *  Delete the panel.
	 */
	public void Query(){
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		UserQueryModel queryModel=new UserQueryModel();
		List<UserModel> list=null;
		queryModel.setUuid(txtUuid.getText());
		queryModel.setName(txtName.getText());
		queryModel.setType(type.getSelectedIndex());
		list=(List<UserModel>) userEbi.getByCondition(queryModel);
		//System.out.println("query list"+list);
		PanelUtil.changePanel(jframe, new ListPanel(jframe,list));
		Back();
	}
	/**
	 * Back the ListPanel
	 */
	public void Back(){
		PanelUtil.changePanel(jframe, new ListPanel(jframe));
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
		
		JLabel lblNewLabel = new JLabel("\u59D3 \u540D");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u7C7B\u578B");
		label.setBounds(36, 105, 46, 14);
		add(label);
		
		txtName = new JTextField();
		txtName.setBounds(132, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		JComboBox userType = new JComboBox();
		userType.setBounds(132, 102, 100, 20);
		userType.addItem("ÇëÑ¡Ôñ½ÇÉ«");
		
		for(UserTypeEnum enum1:UserTypeEnum.values()){
			userType.addItem(enum1.getName());
		}

		add(userType);
		type=userType;
		
		JLabel lblUuid = new JLabel("Uuid");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUuid = new JTextField();
		txtUuid.setColumns(10);
		txtUuid.setBounds(132, 27, 86, 20);
		add(txtUuid);
		
		
	}
	
	
}
