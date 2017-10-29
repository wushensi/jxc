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
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.factory.UuidDAOFactory;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.vo.InMain;
import cn.javass.jxc.user.UuidEnum;
import cn.javass.jxc.user.vo.UserModel;





public class AddPanel extends JPanel {
	private JFrame jframe;
	private static JTextField name,pwd,checkpwd;
	private static JXDatePicker inDate;
	private static JComboBox inUuid;
	/**
	 * Create the panel.
	 */
	public void Add(){
		
		InMain model=new InMain();
		InMainEbi ebi=InMainEbiFactory.getInMainEbi();
		UuidModel uuid=new UuidModel();
		//使用离散值enum枚举，对一个类 只限定生成特定几个的实例，重新实现uuid自动生产
		uuid.setModelName(UuidEnum.IN_UUID.toString());
		UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
		model.setId(uuidDao.getNextNum(uuid.getModelName()));
		model.setInUserId(inUuid.getSelectedItem().toString());
		model.setInDate(inDate.getDate().getTime());
		System.out.println(ebi.create(model));
		Back();
	}
	public void Back(){
		PanelUtil.changePanel(jframe, new InListPanel(jframe));
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
		btnAddUser.setBounds(44, 204, 89, 23);
		add(btnAddUser);
		
		JButton btnBack = new JButton("\u8FD4\u56DE");
		btnBack.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Back();
			}
		});
		btnBack.setBounds(210, 204, 89, 23);
		add(btnBack);
		
		JLabel lblNewLabel = new JLabel("\u8FDB\u8D27\u4EBA\u5458");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u8FDB\u8D27\u65F6\u95F4");
		label_1.setBounds(36, 106, 46, 14);
		add(label_1);
		List<UserModel> userList=SerialUtil.readFromFile("User.txt");
		JComboBox inUser = new JComboBox();
		for(UserModel model:userList){
			inUser.addItem(model.getUuid());
		}
		inUser.setBounds(92, 66, 86, 20);
		
		inUuid=inUser;
		add(inUser);
		
		//第三方日期控件
		JXDatePicker datepick = new JXDatePicker();
		
        // 设置 date日期
        datepick.setDate(new Date());
        inDate=datepick;
        datepick.setBounds(92, 106, 125, 20);
 
        add(datepick);
        
        
		
		
	}
	public AddPanel(JFrame jframe) {
		this.init();
		this.jframe=jframe;
	}
	
	public AddPanel(){
		this.init();
	}
}
