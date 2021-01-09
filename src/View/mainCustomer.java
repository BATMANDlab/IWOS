package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.IWOS;
import pojo.Goods;
import pojo.Order;
import util.Conn;

import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class mainCustomer extends JFrame {

	private JPanel contentPane;
	private final JScrollPane scrollPane;
	private JTable table;
	
	private ResultSet rs;
	private JTextField gidd;
	private JTextField kindd;
	private JTextField pricee;
	private JTextField numm;
	private JTextField fidd;
	private JTextField addresss;
	private JButton btnNewButton;
	private JLabel lblNewLabel;
	private JLabel lblNewLabel_1;
	private JLabel lblNewLabel_2;
	private JLabel lblid;
	private JLabel kinddsaasd;
	private JLabel addressasjklasdfjkl;
	private JButton btnNewButton_1;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					mainCustomer frame = new mainCustomer();
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
	public mainCustomer() {
		setTitle("\u5BA2\u6237\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 776, 501);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String [] columnNames = { "商品ID","种类" ,"价格", "数目","商家ID"};
		DefaultTableModel model = new DefaultTableModel(columnNames,0);
		table = new JTable(model){
			private static final long serialVersionUID = -333010582621839389L;
			public boolean isCellEditable(int row, int column) {
				return false;
			}
		};//设置表格不可编辑
		table.setBackground(Color.WHITE);
		table.setFont(new Font("宋体", Font.PLAIN, 18));
		table.setRowHeight(35);

		scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 762, 257);
		contentPane.add(scrollPane);
		
		gidd = new JTextField();
		gidd.setBounds(79, 267, 78, 41);
		contentPane.add(gidd);
		gidd.setColumns(10);
		
		kindd = new JTextField();
		kindd.setForeground(Color.BLUE);
		kindd.setFont(new Font("宋体", Font.PLAIN, 20));
		kindd.setBounds(342, 311, 208, 55);
		contentPane.add(kindd);
		kindd.setColumns(10);
		
		pricee = new JTextField();
		pricee.setBounds(341, 265, 81, 36);
		contentPane.add(pricee);
		pricee.setColumns(10);
		
		numm = new JTextField();
		numm.setBounds(649, 267, 66, 27);
		contentPane.add(numm);
		numm.setColumns(10);
		
		fidd = new JTextField();
		fidd.setBounds(79, 319, 80, 38);
		contentPane.add(fidd);
		fidd.setColumns(10);
		
		addresss = new JTextField();
		addresss.setBounds(112, 396, 295, 47);
		contentPane.add(addresss);
		addresss.setColumns(10);
		
		btnNewButton = new JButton("\u4E0B\u5355");
		SimpleDateFormat sdf =new SimpleDateFormat("yyyy-MM-dd HH:mm:ss" );
        Date d= new Date();
        String str = sdf.format(d);
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String gidString = gidd.getText();
				int gid = Integer.valueOf(gidString);
				String priceString = pricee.getText();
				double price = Double.valueOf(priceString);
				String numString = numm.getText();
				int num = Integer.valueOf(numString);
				String fidString = fidd.getText();
				int fid = Integer.valueOf(fidString);
				String kindString = kindd.getText();
				String addressString = addresss.getText();
				
				Order order = new Order();
				order.setGid(gid);
				order.setPrice(price);
				order.setNum(num);
				order.setFid(fid);
				order.setKind(kindString);
				order.setAddress(addressString);
				order.setArrival("0");
				order.setDate(str);
				
				IWOS.addOrder(order);
				IWOS.decreaseGoods(order);
				gidd.setText("");
				pricee.setText("");
				numm.setText("");
				fidd.setText("");
				kindd.setText("");
				addresss.setText("");
				JOptionPane.showMessageDialog(contentPane,"下单成功~！");
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 30));
		btnNewButton.setBounds(462, 385, 146, 58);
		contentPane.add(btnNewButton);
		
		lblNewLabel = new JLabel("\u5546\u54C1ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 267, 58, 41);
		contentPane.add(lblNewLabel);
		
		lblNewLabel_1 = new JLabel("\u5355\u4EF7");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(247, 263, 58, 41);
		contentPane.add(lblNewLabel_1);
		
		lblNewLabel_2 = new JLabel("\u6570\u76EE");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(566, 262, 58, 41);
		contentPane.add(lblNewLabel_2);
		
		lblid = new JLabel("\u5546\u5BB6ID");
		lblid.setForeground(Color.BLUE);
		lblid.setFont(new Font("宋体", Font.PLAIN, 18));
		lblid.setBounds(11, 316, 58, 41);
		contentPane.add(lblid);
		
		kinddsaasd = new JLabel("\u5546\u54C1\u79CD\u7C7B");
		kinddsaasd.setForeground(Color.BLUE);
		kinddsaasd.setFont(new Font("宋体", Font.PLAIN, 20));
		kinddsaasd.setBounds(234, 313, 106, 47);
		contentPane.add(kinddsaasd);
		
		addressasjklasdfjkl = new JLabel("\u5730\u5740");
		addressasjklasdfjkl.setForeground(Color.BLUE);
		addressasjklasdfjkl.setFont(new Font("宋体", Font.PLAIN, 31));
		addressasjklasdfjkl.setBounds(11, 394, 73, 46);
		contentPane.add(addressasjklasdfjkl);
		
		btnNewButton_1 = new JButton("\u5237\u65B0\u5546\u54C1");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				Connection con = Conn.getConnection();
				
				
				rs = IWOS.getAllGoods();
				DefaultTableModel dtm = (DefaultTableModel) table.getModel();
				dtm.setRowCount(0);
				
				try {
					while(rs.next()) {
					    Vector<String> v = new Vector<String>();
					    v.add(rs.getString(1));
					    v.add(rs.getString(2));
					    v.add(rs.getString(3));
					    v.add(rs.getString(4));
					    v.add(rs.getString(5));
					    dtm.addRow(v);
					}
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(628, 385, 134, 58);
		contentPane.add(btnNewButton_1);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\sky_gaitubao_902x464.jpg"));
		lblNewLabel_3.setBounds(0, 0, 762, 464);
		contentPane.add(lblNewLabel_3);
		
		
		
		Connection con = Conn.getConnection();
		
		
		rs = IWOS.getAllGoods();
		DefaultTableModel dtm = (DefaultTableModel) table.getModel();
		dtm.setRowCount(0);
		
		try {
			while(rs.next()) {
			    Vector<String> v = new Vector<String>();
			    v.add(rs.getString(1));
			    v.add(rs.getString(2));
			    v.add(rs.getString(3));
			    v.add(rs.getString(4));
			    v.add(rs.getString(5));
			    dtm.addRow(v);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}


		
		this.setVisible(true);
	}
}
