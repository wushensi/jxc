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
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.factory.UuidDAOFactory;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.user.UserTypeEnum;
import cn.javass.jxc.user.UuidEnum;
import cn.javass.jxc.user.business.ebi.UserEbi;
import cn.javass.jxc.user.business.factory.UserEbiFactory;
import cn.javass.jxc.user.vo.UserModel;


public class AddPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtPwd;
	private JTextField txtCheckPwd;
	private JFrame jframe;
	private static JTextField name,pwd,checkpwd;
	private static JComboBox type;
	/**
	 * Create the panel.
	 */
	public void Add(){
		
		UserModel model=new UserModel();
		UuidModel uuid=new UuidModel();
		//使用离散值enum枚举，对一个类 只限定生成特定几个的实例，重新实现uuid自动生产
		uuid.setModelName(UuidEnum.USER_UUID.toString());
		UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
		model.setUuid(uuidDao.getNextNum(uuid.getModelName()));
		model.setName(name.getText());
		model.setPwd(pwd.getText());
		model.setType(UserTypeEnum.getUserName(((String)type.getSelectedItem())));
		UserEbi userebi=UserEbiFactory.getUserEbi();
		if(!(pwd.getText().equals(checkpwd.getText()))){
			JOptionPane.showMessageDialog(null, "密码错误，请重新输入");
		}else if(!(userebi.create(model))){
			JOptionPane.showMessageDialog(null, "对不起，用户已存在，请重新输入");
		}
		Back();
	}
	public void Back(){
		//System.out.println(jframe);
		/*jframe.getContentPane().removeAll();
		jframe.getContentPane().add(new ListPanel(jframe));
		jframe.getContentPane().validate();*/
		PanelUtil.changePanel(jframe, new ListPanel(jframe));
	}
	public void init(){
		setLayout(null);
		this.setSize(800, 600);
		
		JButton btnAddUser = new JButton("\u6DFB\u52A0");
		btnAddUser.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Add();
			}
		});
		btnAddUser.setBounds(73, 242, 89, 23);
		add(btnAddUser);
		
		JButton btnBack = new JButton("\u8FD4\u56DE");
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
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801");
		label_2.setBounds(36, 188, 46, 14);
		add(label_2);
		
		txtName = new JTextField();
		txtName.setBounds(92, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		name=txtName;
		
		
		txtPwd = new JTextField();
		txtPwd.setColumns(10);
		txtPwd.setBounds(92, 142, 86, 20);
		add(txtPwd);
		pwd=txtPwd;
		
		
		txtCheckPwd = new JTextField();
		txtCheckPwd.setColumns(10);
		txtCheckPwd.setBounds(92, 185, 86, 20);
		add(txtCheckPwd);
		checkpwd=txtCheckPwd;
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 102, 100, 20);
		for(UserTypeEnum enum1:UserTypeEnum.values()){
			comboBox.addItem(enum1.getName());
		}
		add(comboBox);
		type=comboBox;
		
	}
	public AddPanel(JFrame jframe) {
		this.init();
		this.jframe=jframe;
	}
	
	public AddPanel(){
		this.init();
	}
}
