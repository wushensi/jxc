package cn.javass.jxc.user.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.user.UserTypeEnum;
import cn.javass.jxc.user.business.ebi.UserEbi;
import cn.javass.jxc.user.business.factory.UserEbiFactory;
import cn.javass.jxc.user.vo.UserModel;

public class UpdatePanel extends JPanel {
	public UpdatePanel() {
		this.init();
	}
	public UpdatePanel(JFrame jframe,String uuid) {
		this.uuid=uuid;
		this.jframe=jframe;
		this.init();
	}
	private JTextField txtName;
	private JTextField txtPwd;
	private JFrame jframe;
	private JTextField txtUuid;
	private static JComboBox type;
	private static String uuid;
	/**
	 * Update the panel.
	 */
	public void Update(){
		UserModel model=new UserModel();
		model.setUuid(txtUuid.getText());
		model.setName(txtName.getText());
		model.setPwd(txtPwd.getText());
		model.setType(type.getSelectedIndex());
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		userEbi.update(model);
		Back();
	}
	public void Back(){
		PanelUtil.changePanel(jframe, new ListPanel(jframe,null));
	}
	public void init(){
		setLayout(null);
		this.setSize(800, 600);
		
		JButton btnUpdate = new JButton("\u66F4   \u65B0");
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Update();
			}
		});
		btnUpdate.setBounds(73, 242, 89, 23);
		add(btnUpdate);
		
		JButton btnBack = new JButton("\u8FD4   \u56DE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setBounds(237, 242, 89, 23);
		add(btnBack);
		
		JLabel lblNewLabel = new JLabel("\u59D3 \u540D");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u7528\u6237\u7C7B\u578B");
		label.setBounds(36, 105, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u5BC6\u7801");
		label_1.setBounds(36, 145, 46, 14);
		add(label_1);
		
		txtName = new JTextField();
		txtName.setBounds(92, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		//name=txtName;
		
		
		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(92, 142, 86, 20);
		add(txtPwd);
		//pwd=txtPwd;
		
		JComboBox userType = new JComboBox();
		userType.setBounds(92, 102, 100, 20);
		/*for(UserTypeEnum enum1:UserTypeEnum.values()){
			userType.addItem(enum1.getName());
		}*/
		add(userType);
		type=userType;
		
		JLabel lblUuid = new JLabel("Uuid");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUuid = new JTextField();
		txtUuid.setColumns(10);
		txtUuid.setBounds(92, 27, 86, 20);
		add(txtUuid);
		//uuid=txtUuid;
		
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		UserModel model=userEbi.getByUuid(uuid);
		
		txtUuid.setText(model.getUuid());
		txtUuid.setEditable(false);
		txtName.setText(model.getName());
		
		for(UserTypeEnum enum1:UserTypeEnum.values()){
			userType.addItem(enum1.getName());
		}
		userType.setSelectedIndex((model.getType()-1));
		txtPwd.setText(model.getPwd());
	}
	
	
}
