package cn.javass.jxc.book.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.book.business.ebi.BookEbi;
import cn.javass.jxc.book.business.factory.BookEbiFactory;
import cn.javass.jxc.book.vo.BookModel;
import cn.javass.jxc.common.dao.dao.UuidDAO;
import cn.javass.jxc.common.dao.factory.UuidDAOFactory;
import cn.javass.jxc.common.vo.UuidModel;
import cn.javass.jxc.user.UserTypeEnum;
import cn.javass.jxc.user.UuidEnum;



public class AddPanel extends JPanel {
	private JTextField txtName;
	private JTextField txtInPrice;
	private JTextField txtSalePrice;
	private JFrame jframe;
	private static JTextField name,pwd,checkpwd;
	private static JComboBox type;
	/**
	 * Create the panel.
	 */
	public void Add(){
		
		BookModel model=new BookModel();
		UuidModel uuid=new UuidModel();
		//使用离散值enum枚举，对一个类 只限定生成特定几个的实例，重新实现uuid自动生产
		uuid.setModelName(UuidEnum.BOOK_UUID.toString());
		UuidDAO uuidDao=UuidDAOFactory.getUuidDAO();
		model.setUuid(uuidDao.getNextNum(uuid.getModelName()));
		model.setName(txtName.getText());
		model.setInPrice(Double.parseDouble(txtInPrice.getText()));
		model.setSalePrice(Double.parseDouble(txtSalePrice.getText()));
		BookEbi bookEbi=BookEbiFactory.getBookEbi();
		bookEbi.create(model);
		Back();
	}
	public void Back(){
		PanelUtil.changePanel(jframe, new BookListPanel(jframe));
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
		
		JLabel lblNewLabel = new JLabel("\u4E66 \u540D");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label_1 = new JLabel("\u8FDB\u8D27\u4EF7\u683C");
		label_1.setBounds(36, 106, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u9500\u552E\u4EF7\u683C");
		label_2.setBounds(36, 145, 46, 14);
		add(label_2);
		
		txtName = new JTextField();
		txtName.setBounds(92, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		name=txtName;
		
		
		txtInPrice = new JTextField();
		txtInPrice.setColumns(10);
		txtInPrice.setBounds(92, 106, 86, 20);
		add(txtInPrice);
		pwd=txtInPrice;
		
		
		txtSalePrice = new JTextField();
		txtSalePrice.setColumns(10);
		txtSalePrice.setBounds(92, 142, 86, 20);
		add(txtSalePrice);
		checkpwd=txtSalePrice;
		
		
	}
	public AddPanel(JFrame jframe) {
		this.init();
		this.jframe=jframe;
	}
	
	public AddPanel(){
		this.init();
	}
}
