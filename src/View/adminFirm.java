package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.IWOS;
import pojo.Firm;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Toolkit;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class adminFirm extends JFrame {

	private JPanel contentPane;
	private JTextField fid;
	private JTextField fname;
	private JTextField password;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					adminFirm frame = new adminFirm();
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
	public adminFirm() {
		setTitle("\u5546\u5BB6\u6CE8\u518C");
		setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\BATMAN\\Desktop\\mainicon.jpg"));
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 436, 388);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u5546\u5BB6ID");
		lblNewLabel.setForeground(Color.BLUE);
		lblNewLabel.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel.setBounds(46, 10, 77, 39);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u5E97\u540D");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setForeground(Color.BLUE);
		lblNewLabel_1.setBounds(46, 110, 77, 39);
		contentPane.add(lblNewLabel_1);
		
		fid = new JTextField();
		fid.setBounds(166, 10, 159, 39);
		contentPane.add(fid);
		fid.setColumns(10);
		
		fname = new JTextField();
		fname.setBounds(166, 110, 159, 39);
		contentPane.add(fname);
		fname.setColumns(10);
		
		
		JFrame jFrame= this;
		JButton btnNewButton = new JButton("\u6CE8\u518C");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String fidString = fid.getText();
				int id = Integer.parseInt(fidString);
				String fnameString = fname.getText();
				String passwordString = password.getText();
				
				Firm firm = new Firm(id,fnameString,passwordString);
				IWOS.addFirm(firm);
				JOptionPane.showMessageDialog(contentPane,"注册成功~！");
				jFrame.dispose();
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 25));
	
		btnNewButton.setBounds(151, 286, 115, 44);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setForeground(Color.BLUE);
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(46, 215, 77, 39);
		contentPane.add(lblNewLabel_2);
		
		password = new JTextField();
	
		password.setBounds(166, 205, 159, 39);
		contentPane.add(password);
		password.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\sky_gaitubao_908x467.jpg"));
		lblNewLabel_3.setBounds(0, 0, 422, 351);
		contentPane.add(lblNewLabel_3);
		this.setVisible(true);
	}
}
