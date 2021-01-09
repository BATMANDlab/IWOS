package View;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.sql.ResultSet;
import java.util.Vector;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import com.mysql.jdbc.Connection;

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

public class firmOrder extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private ResultSet rs;
	private int fid;
	private JLabel lblNewLabel;
	private JTextField oid;
	private JButton btnNewButton;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { firmOrder frame = new firmOrder();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public firmOrder(int fid) {
		this.fid = fid;
		
		setTitle("\u8BA2\u5355");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 1109, 421);
		contentPane = new JPanel();
		contentPane.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			}
		});
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		String [] columnNames = { "订单ID","商品ID" ,"商品种类" ,"价格", "数目","送货地址" ,"是否送达" ,"日期" ,"商家ID"};
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
		scrollPane.setBounds(0, 0, 1095, 208);
		contentPane.add(scrollPane);
		
		lblNewLabel = new JLabel("\u8BA2\u5355ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 41));
		lblNewLabel.setBounds(0, 237, 138, 51);
		contentPane.add(lblNewLabel);
		
		oid = new JTextField();
		oid.setBounds(189, 237, 87, 51);
		contentPane.add(oid);
		oid.setColumns(10);
		
		btnNewButton = new JButton("\u9001\u8FBE");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String oidString = oid.getText();
				int oid = Integer.valueOf(oidString);
				IWOS.isArrival(oid);
				JOptionPane.showMessageDialog(contentPane,"商品已送达~！");
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 41));
		btnNewButton.setBounds(65, 310, 164, 70);
		contentPane.add(btnNewButton);
		
		Connection connection = Conn.getConnection();
		
		rs = IWOS.getmyOrder(fid);
		
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
			    v.add(rs.getString(6));
			    v.add(rs.getString(7));
			    v.add(rs.getString(8));
			    v.add(rs.getString(9));
			    dtm.addRow(v);
			}
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		this.setVisible(true);
	}

}
