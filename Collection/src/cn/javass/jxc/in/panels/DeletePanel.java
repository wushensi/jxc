package cn.javass.jxc.in.panels;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.SimpleDateFormat;
import java.util.Date;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import cn.javass.framework.panel.PanelUtil;
import cn.javass.jxc.in.business.ebi.InMainEbi;
import cn.javass.jxc.in.business.factory.InMainEbiFactory;
import cn.javass.jxc.in.vo.InMain;


public class DeletePanel extends JPanel {
	
	private JTextField txtInUid;
	private JFrame jframe;
	private JTextField txtUid;
	private static String uuid;
	private JTextField txtInDate;
	public DeletePanel() {
		this.init();
	}
	public DeletePanel(JFrame jframe,String uuid) {
		this.uuid=uuid;
		System.out.println("book uuid---"+uuid);
		this.jframe=jframe;
		this.init();
	}
	/**
	 *  Delete the panel.
	 */
	public void Delete(){
		//获取Dao
		//BookEbi bookEbi=BookEbiFactory.getBookEbi();
		InMainEbi inMainEbi=InMainEbiFactory.getInMainEbi();
		//删除记录,并判断返回值
		if(!inMainEbi.delete(uuid)){
			JOptionPane.showMessageDialog(null, "对不起，用户不存在，删除失败");
		}
		
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
		
		JLabel lblNewLabel = new JLabel("\u8FDB\u8D27\u4EBA\u5458");
		lblNewLabel.setBounds(36, 69, 46, 14);
		add(lblNewLabel);
		
		JLabel label = new JLabel("\u8FDB\u8D27\u65F6\u95F4");
		label.setBounds(36, 105, 46, 14);
		add(label);
		
		txtInUid = new JTextField();
		txtInUid.setBounds(92, 66, 86, 20);
		add(txtInUid);
		txtInUid.setColumns(10);
		
		JLabel lblUuid = new JLabel("\u8FDB\u8D27\u7F16\u53F7");
		lblUuid.setBounds(36, 30, 46, 14);
		add(lblUuid);
		
		txtUid = new JTextField();
		txtUid.setColumns(10);
		txtUid.setBounds(92, 27, 86, 20);
		add(txtUid);
		
		txtInDate = new JTextField();
		txtInDate.setBounds(92, 102, 86, 20);
		add(txtInDate);
		txtInDate.setColumns(10);
		
		InMainEbi inMainEbi=InMainEbiFactory.getInMainEbi();
		InMain model=inMainEbi.getByUuid(uuid);
		
		txtUid.setText(model.getId());
		txtUid.setEditable(false);
		txtInUid.setText(model.getInUserId());
		txtInUid.setEditable(false);
		Date date=new Date();
		date.setTime(model.getInDate());
		SimpleDateFormat sdf=new SimpleDateFormat("YYYY-MM-dd");
		txtInDate.setText((String)sdf.format(date));
		txtInDate.setEditable(false);
	}
}
