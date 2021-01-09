package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.IWOS;
import pojo.Goods;
import util.Conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class addGoods extends JFrame {

	private JPanel contentPane;
	private JTextField gid;
	private JTextField kind;
	private JTextField price;
	private JTextField num;
	private JTextField fid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addGoods frame = new addGoods();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public addGoods() {
		setTitle("\u5546\u54C1\u4E0A\u67B6");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 576, 511);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel.setBounds(39, 10, 109, 43);
		contentPane.add(lblNewLabel);
		
		gid = new JTextField();
		gid.setBounds(202, 10, 193, 43);
		contentPane.add(gid);
		gid.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u79CD\u7C7B");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(39, 86, 109, 43);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5355\u4EF7");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(39, 154, 109, 43);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("\u6570\u76EE");
		lblNewLabel_3.setForeground(Color.BLUE);
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 30));
		lblNewLabel_3.setBounds(39, 225, 109, 43);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblid = new JLabel("\u5546\u5BB6ID");
		lblid.setForeground(Color.BLUE);
		lblid.setFont(new Font("宋体", Font.PLAIN, 30));
		lblid.setBounds(39, 301, 109, 43);
		contentPane.add(lblid);
		
		kind = new JTextField();
		kind.setColumns(10);
		kind.setBounds(202, 86, 193, 43);
		contentPane.add(kind);
		
		price = new JTextField();
		price.setColumns(10);
		price.setBounds(202, 154, 193, 43);
		contentPane.add(price);
		
		num = new JTextField();
		num.setColumns(10);
		num.setBounds(202, 225, 193, 43);
		contentPane.add(num);
		
		fid = new JTextField();
		fid.setColumns(10);
		fid.setBounds(202, 301, 193, 43);
		contentPane.add(fid);
		
		JFrame jFrame = this;
		JButton btnNewButton = new JButton("\u4E0A\u67B6");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String gidString = gid.getText();
				int gid = Integer.valueOf(gidString);
				String kindString = kind.getText();
				String priceString = price.getText();
				int price = Integer.valueOf(priceString);
				String numString = num.getText();
				int num = Integer.valueOf(numString);
				String fidString = fid.getText();
				int fid = Integer.valueOf(fidString);
				
				Goods goods = new Goods();
				goods.setGid(gid);
				goods.setKind(kindString);
				goods.setPrice(price);
				goods.setNum(num);
				goods.setFid(fid);
				
				IWOS.addGoods(goods);
				JOptionPane.showMessageDialog(contentPane,"商品上架成功~！");
				jFrame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 55));
		btnNewButton.setBounds(176, 400, 219, 64);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\timg_gaitubao_709x474.jpg"));
		lblNewLabel_4.setBounds(0, 0, 562, 474);
		contentPane.add(lblNewLabel_4);
		this.setVisible(true);
	}

}
