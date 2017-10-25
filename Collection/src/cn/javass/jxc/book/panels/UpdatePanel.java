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
	private JTextField txtSalePrice;
	private JFrame jframe;
	private JTextField txtUuid;
	private static JComboBox type;
	private static String uuid;
	private JTextField txtInPrice;
	/**
	 * Update the panel.
	 */
	public void Update(){
		BookModel model=new BookModel();
		model.setUuid(txtUuid.getText());
		model.setName(txtName.getText());
		model.setInPrice(Double.parseDouble(txtInPrice.getText()));
		model.setSalePrice(Double.parseDouble(txtSalePrice.getText()));
		BookEbi bookEbi=BookEbiFactory.getBookEbi();
		bookEbi.update(model);
		Back();
	}
	public void Back(){
		PanelUtil.changePanel(jframe, new BookListPanel(jframe,null));
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
		
		JLabel lblNewLabel = new JLabel("\u4E66 \u540D");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u8FDB\u8D27\u4EF7\u683C");
		label.setBounds(36, 105, 46, 14);
		add(label);
		
		JLabel label_1 = new JLabel("\u9500\u552E\u4EF7\u683C");
		label_1.setBounds(36, 145, 46, 14);
		add(label_1);
		
		txtName = new JTextField();
		txtName.setBounds(92, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		//name=txtName;
		
		
		txtSalePrice = new JTextField();
		txtSalePrice.setColumns(10);
		txtSalePrice.setBounds(92, 142, 86, 20);
		add(txtSalePrice);
		
		JLabel lblUuid = new JLabel("Uuid");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUuid = new JTextField();
		txtUuid.setColumns(10);
		txtUuid.setBounds(92, 27, 86, 20);
		add(txtUuid);
		//uuid=txtUuid;
		
		BookEbi bookEbi=BookEbiFactory.getBookEbi();
		BookModel model=bookEbi.getByUuid(uuid);
		
		txtUuid.setText(model.getUuid());
		txtUuid.setEditable(false);
		txtName.setText(model.getName());
		
		
		txtSalePrice.setText(String.valueOf(model.getSalePrice()));
		
		txtInPrice = new JTextField();
		txtInPrice.setText(String.valueOf(model.getInPrice()));
		txtInPrice.setColumns(10);
		txtInPrice.setBounds(92, 102, 86, 20);
		add(txtInPrice);
	}
	
	
}
