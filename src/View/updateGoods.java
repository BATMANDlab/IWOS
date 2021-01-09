package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.Connection;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import Dao.IWOS;
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

public class updateGoods extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ResultSet rs;
	public int fid;
	private JTextField gidd;
	private JTextField numm;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { updateGoods frame = new updateGoods();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public updateGoods(int fid) {
		this.fid = fid;
		
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 914, 504);
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
		
		JScrollPane scrollPane = new JScrollPane(table);
		scrollPane.setBounds(0, 0, 900, 227);
		contentPane.add(scrollPane);
		
		JLabel lblNewLabel = new JLabel("\u5546\u54C1ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel.setBounds(25, 309, 85, 35);
		contentPane.add(lblNewLabel);
		
		gidd = new JTextField();
		gidd.setBounds(142, 309, 90, 35);
		contentPane.add(gidd);
		gidd.setColumns(10);
		
		
		JButton btnNewButton = new JButton("\u4E0B\u67B6");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String gidString = gidd.getText();
				int gid = Integer.valueOf(gidString);
				IWOS.removemyGoods(fid, gid);
				JOptionPane.showMessageDialog(contentPane,"商品已下架~！");
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton.setBounds(56, 376, 123, 55);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("\u5546\u54C1\u6570\u76EE");
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(328, 307, 135, 35);
		contentPane.add(lblNewLabel_1);
		
		numm = new JTextField();
		numm.setColumns(10);
		numm.setBounds(497, 309, 90, 35);
		contentPane.add(numm);
		
		JButton btnNewButton_1 = new JButton("\u66F4\u65B0\u5E93\u5B58");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String gidString = gidd.getText();
				int gid = Integer.valueOf(gidString);
				String numString = numm.getText();
				int num = Integer.valueOf(numString);
				IWOS.updateGoods(fid, gid, num);
				
				JOptionPane.showMessageDialog(contentPane,"更新成功~！");
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 25));
		btnNewButton_1.setBounds(380, 376, 167, 55);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u4E0B\u67B6\u5546\u54C1\u65E0\u987B\u586B\u5199\u6570\u76EE");
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 25));
		lblNewLabel_2.setBounds(603, 309, 259, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\sky_gaitubao_908x467.jpg"));
		lblNewLabel_3.setBounds(0, 0, 900, 467);
		contentPane.add(lblNewLabel_3);
		
		
		
		Connection con = Conn.getConnection();
		
		rs = IWOS.getmyGoods(fid);
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
