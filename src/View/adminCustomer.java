package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.IWOS;
import pojo.Customer;
import pojo.Firm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;

public class adminCustomer extends JFrame {

	private JPanel contentPane;
	private JTextField cid;
	private JTextField cname;
	private JTextField password;
	private JLabel lblNewLabel_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminCustomer frame = new adminCustomer();
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
	public adminCustomer() {
		setTitle("\u5BA2\u6237\u6CE8\u518C");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 579, 438);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5BA2\u6237ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(61, 45, 103, 50);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u5B57");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(61, 136, 103, 42);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(61, 242, 103, 42);
		contentPane.add(lblNewLabel_2);
		
		cid = new JTextField();
		cid.setBounds(247, 51, 195, 44);
		contentPane.add(cid);
		cid.setColumns(10);
		
		cname = new JTextField();
		cname.setBounds(246, 142, 194, 42);
		contentPane.add(cname);
		cname.setColumns(10);
		
		password = new JTextField();
		password.setBounds(246, 242, 195, 41);
		contentPane.add(password);
		password.setColumns(10);
		
		JFrame jFrame = this;
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String cidString = cid.getText();
				int id = Integer.parseInt(cidString);
				String cnameString = cname.getText();
				String passwordString = password.getText();
				
				Customer customer = new Customer(id,cnameString,passwordString);
				IWOS.addCustomer(customer);
				JOptionPane.showMessageDialog(contentPane,"注册成功~！");
				jFrame.dispose();
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 40));
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setBounds(179, 318, 207, 73);
		contentPane.add(btnNewButton);
		
		lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\timg_gaitubao_671x449.jpg"));
		lblNewLabel_3.setBounds(0, 0, 565, 401);
		contentPane.add(lblNewLabel_3);
		this.setVisible(true);
	}
}
