package cn.javass.jxc.book.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.util.List;

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
import cn.javass.jxc.book.vo.BookQueryModel;


public class QueryPanel extends JPanel {
	
	private JTextField txtName;
	private JFrame jframe;
	private JTextField txtUuid;
	private static JComboBox type;
	private JTextField txtInPriceLess;
	private JTextField txtInPriceMore;
	private JTextField txtSalePriceLess;
	private JTextField txtSalePriceMore;
	private double inPriceLess,inPriceMore,salePriceLess,salePriceMore;
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
		BookEbi bookEbi=BookEbiFactory.getBookEbi();
		BookQueryModel queryModel=new BookQueryModel();
		queryModel.setUuid(txtUuid.getText());
		queryModel.setName(txtName.getText());
		
		if(txtInPriceLess.getText().equals("")){
			inPriceLess=0d;
		}else{
			inPriceLess=Double.parseDouble(txtInPriceLess.getText());
		}
		if(txtInPriceMore.getText().equals("")){
			inPriceMore=0d;
		}else{
			inPriceMore=Double.parseDouble(txtInPriceMore.getText());
		}
		if(txtSalePriceLess.getText().equals("")){
			salePriceLess=0d;
		}else{
			salePriceLess=Double.parseDouble(txtSalePriceLess.getText());
		}
		if(txtSalePriceMore.getText().equals("")){
			salePriceMore=0d;
		}else{
			salePriceMore=Double.parseDouble(txtSalePriceMore.getText());
		}
		queryModel.setInPriceLess(inPriceLess);
		queryModel.setInPriceMore(inPriceMore);
		queryModel.setSalePriceLess(salePriceLess);
		queryModel.setSalePriceMore(salePriceMore);
		List<BookModel> list=(List<BookModel>) bookEbi.getByCondition(queryModel);
		PanelUtil.changePanel(jframe, new BookListPanel(jframe,list));
		Back();
	}
	/**
	 * Back the ListPanel
	 */
	public void Back(){
		PanelUtil.changePanel(jframe, new BookListPanel(jframe));
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
		
		JLabel lblNewLabel = new JLabel("\u4E66   \u540D\uFF1A");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		txtName = new JTextField();
		txtName.setBounds(151, 66, 86, 20);
		add(txtName);
		txtName.setColumns(10);
		
		/*for(UserTypeEnum enum1:UserTypeEnum.values()){
			userType.addItem(enum1.getName());
		}*/
		
		JLabel lblUuid = new JLabel("Uuid");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUuid = new JTextField();
		txtUuid.setColumns(10);
		txtUuid.setBounds(151, 27, 86, 20);
		add(txtUuid);
		
		JLabel lblNewLabel_1 = new JLabel("\u8FDB\u8D27\u4EF7\u683C\uFF1A");
		lblNewLabel_1.setBounds(36, 112, 69, 17);
		add(lblNewLabel_1);
		
		JLabel label = new JLabel("\u9500\u552E\u4EF7\u683C\uFF1A");
		label.setBounds(36, 149, 69, 14);
		add(label);
		
		txtInPriceLess = new JTextField();
		txtInPriceLess.addFocusListener(new FocusAdapter() {
			@Override
			public void focusGained(FocusEvent e) {
				txtInPriceLess.setText("");
				String inPrice=null;
			}
		});
		txtInPriceLess.setBounds(151, 110, 86, 20);
		add(txtInPriceLess);
		txtInPriceLess.setColumns(10);
		
		
		
		txtInPriceMore = new JTextField();
		txtInPriceMore.setColumns(10);
		txtInPriceMore.setBounds(319, 110, 86, 20);
		add(txtInPriceMore);
		
		txtSalePriceLess = new JTextField();
		txtSalePriceLess.setColumns(10);
		txtSalePriceLess.setBounds(151, 146, 86, 20);
		add(txtSalePriceLess);
		
		txtSalePriceMore = new JTextField();
		txtSalePriceMore.setColumns(10);
		txtSalePriceMore.setBounds(319, 146, 86, 20);
		add(txtSalePriceMore);
		
		JLabel lblNewLabel_2 = new JLabel("\u5C0F\u4E8E");
		lblNewLabel_2.setBounds(115, 113, 46, 14);
		add(lblNewLabel_2);
		
		JLabel label_1 = new JLabel("\u5C0F\u4E8E");
		label_1.setBounds(115, 149, 46, 14);
		add(label_1);
		
		JLabel label_2 = new JLabel("\u5927\u4E8E");
		label_2.setBounds(266, 113, 46, 14);
		add(label_2);
		
		JLabel label_3 = new JLabel("\u5927\u4E8E");
		label_3.setBounds(263, 149, 46, 14);
		add(label_3);
		
		
	}
}
