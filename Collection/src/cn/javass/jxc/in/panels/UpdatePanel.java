package cn.javass.jxc.in.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Date;
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
import cn.javass.jxc.user.vo.UserModel;



public class UpdatePanel extends JPanel {
	public UpdatePanel() {
		this.init();
	}
	public UpdatePanel(JFrame jframe,String uuid) {
		System.out.println("uuid---"+uuid);
		this.uuid=uuid;
		this.jframe=jframe;
		this.init();
	}
	private JFrame jframe;
	private JTextField txtId;
	private static String uuid;
	private JComboBox inUid;
	private JXDatePicker inDate;
	/**
	 * Update the panel.
	 */
	public void Update(){
		InMainEbi inMainEbi=InMainEbiFactory.getInMainEbi();
		InMain model=new InMain();
		model.setId(uuid);
		model.setInUserId((String)inUid.getSelectedItem());
		model.setInDate(inDate.getDate().getTime());
		inMainEbi.update(model);
		Back();
	}
	public void Back(){
		PanelUtil.changePanel(jframe, new InListPanel(jframe,null));
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
		
		JLabel lblNewLabel = new JLabel("\u8FDB\u8D27\u4EBA\u5458");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u8FDB\u8D27\u65F6\u95F4");
		label.setBounds(36, 105, 46, 14);
		add(label);
		
		JLabel LabelId = new JLabel("\u8FDB\u8D27\u7F16\u53F7");
		LabelId.setBounds(36, 30, 46, 14);
		add(LabelId);
		
		txtId = new JTextField();
		txtId.setColumns(10);
		txtId.setEditable(false);
		txtId.setBounds(92, 27, 86, 20);
		txtId.setText(uuid);
		add(txtId);
		//uuid=txtUuid;
		
		
		
		InMainEbi inMainEbi=InMainEbiFactory.getInMainEbi();
		InMain model=inMainEbi.getByUuid(uuid);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(92, 66, 86, 20);
		List<UserModel> userList=SerialUtil.readFromFile("User.txt");
		for(UserModel entity:userList){
			comboBox.addItem(entity.getUuid());
			System.out.println(entity.getUuid());
		}
		InMainEbi ebi=InMainEbiFactory.getInMainEbi();
		comboBox.setSelectedItem(ebi.getByUuid(uuid).getInUserId());
		System.out.println("comboBox ---uuid "+ uuid);
		inUid=comboBox;
		add(comboBox);
		
		
		//第三方日期控件
		JXDatePicker datepick = new JXDatePicker();	
		// 设置 date日期
		Date date=new Date();
		date.setTime(ebi.getByUuid(uuid).getInDate());
		datepick.setDate(date);
		inDate=datepick;
		datepick.setBounds(92, 106, 125, 20);
		add(datepick);
	}
}
