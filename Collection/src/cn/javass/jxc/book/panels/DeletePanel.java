package cn.javass.jxc.book.panels;

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

public class DeletePanel extends JPanel {
	
	private JTextField txtName;
	private JFrame jframe;
	private JTextField txtUuid;
	private static JComboBox type;
	private static String uuid;
	public DeletePanel() {
		this.init();
	}
	public DeletePanel(JFrame jframe,String uuid) {
		this.uuid=uuid;
		this.jframe=jframe;
		this.init();
	}
	/**
	 *  Delete the panel.
	 */
	public void Delete(){
		//获取Dao
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		//删除记录,并判断返回值
		if(!userEbi.delete(uuid)){
			JOptionPane.showMessageDialog(null, "对不起，用户不存在，删除失败");
		}
		
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
		
		JButton btnDelete = new JButton("\u5220   \u9664");
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(JOptionPane.showConfirmDialog(null, "是否删除记录")==JOptionPane.YES_OPTION){
					Delete();
					Back();
				}else{
					System.out.println("取消删除");
				}
			}
		});
		btnDelete.setBounds(73, 242, 89, 23);
		add(btnDelete);
		
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
		
		txtName = new JTextField();
		txtName.setBounds(92, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		JComboBox userType = new JComboBox();
		userType.setBounds(92, 102, 100, 20);

		add(userType);
		type=userType;
		
		JLabel lblUuid = new JLabel("Uuid");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUuid = new JTextField();
		txtUuid.setColumns(10);
		txtUuid.setBounds(92, 27, 86, 20);
		add(txtUuid);
		
		UserEbi userEbi=UserEbiFactory.getUserEbi();
		UserModel model=userEbi.getByUuid(uuid);
		
		txtUuid.setText(model.getUuid());
		txtUuid.setEditable(false);
		txtName.setText(model.getName());
		txtName.setEditable(false);
		
		userType.addItem(UserTypeEnum.getUserType(model.getType()));
		
	}
	
	
}
