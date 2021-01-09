package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import Dao.IWOS;
import util.Conn;

import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import java.awt.Panel;

import javax.swing.ButtonGroup;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JRadioButton;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.nio.BufferUnderflowException;
import javax.swing.ImageIcon;
import java.awt.SystemColor;

public class login extends JFrame {

	private JPanel contentPane;
	private JTextField account;
	private JPasswordField password;
	
	public static int fid;
	public static int cid;
	public static String fpassword;
	public static String cpassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		//设置样式
		setLookAndFeel();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					login frame = new login();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	  private static void setLookAndFeel() {
	        try {
	          javax.swing.UIManager.setLookAndFeel("com.birosoft.liquid.LiquidLookAndFeel");
	        } catch (Exception e) {
	            e.printStackTrace();
	            // handle exception
	        }
	  
	    }

	/**
	 * Create the frame.
	 */
	public login() {
		setTitle("\u667A\u80FD\u8BA2\u6C34\u7CFB\u7EDF");
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 810, 486);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u667A\u80FD\u8BA2\u6C34\u7CFB\u7EDF");
		lblNewLabel.setForeground(new Color(0, 0, 205));
		lblNewLabel.setFont(new Font("方正粗黑宋简体", Font.PLAIN, 39));
		lblNewLabel.setBounds(277, 10, 268, 113);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("\u5546\u5BB6\u8FDB\u9A7B");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new adminFirm();
			}
		});

	
		
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_1.setBounds(115, 390, 157, 39);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u5BA2\u6237\u6CE8\u518C");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new adminCustomer();
			}
		});
		btnNewButton_2.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton_2.setBounds(541, 390, 157, 39);
		contentPane.add(btnNewButton_2);
		
		account = new JTextField();
		account.setBounds(315, 142, 179, 30);
		contentPane.add(account);
		account.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("\u8D26\u53F7");
		lblNewLabel_1.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(247, 133, 49, 44);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u5BC6\u7801");
		lblNewLabel_2.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(247, 225, 49, 39);
		contentPane.add(lblNewLabel_2);
		
		password = new JPasswordField();
		password.setBounds(315, 227, 179, 30);
		contentPane.add(password);
		
		ButtonGroup buttonGroup = new ButtonGroup();
		JRadioButton firm = new JRadioButton("\u5546\u5BB6");
		firm.setFont(new Font("宋体", Font.PLAIN, 20));
		firm.setBounds(329, 306, 98, 38);
		contentPane.add(firm);
		
		JRadioButton customer = new JRadioButton("\u5BA2\u6237");
		customer.setFont(new Font("宋体", Font.PLAIN, 20));
		customer.setBounds(475, 303, 98, 44);
		
		buttonGroup.add(firm);
		buttonGroup.add(customer);
		contentPane.add(customer);
		
		
		
		
		JLabel lblNewLabel_3 = new JLabel("\u89D2\u8272");
		lblNewLabel_3.setFont(new Font("宋体", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(247, 303, 49, 44);
		contentPane.add(lblNewLabel_3);
		
		JButton btnNewButton = new JButton("\u767B\u5F55");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				if(firm.isSelected()) {
					
					String id = account.getText();
					int account = Integer.parseInt(id);
					String passwordString = String.valueOf(password.getPassword());
					if(IWOS.isFirm(account, passwordString)) {
						
						fid = account;
						fpassword = passwordString;
						login.this.account.setText(null);
						password.setText(null);
						new mainFirm(fid);
					}else {
						login.this.account.setText(null);
						password.setText(null);
						JOptionPane.showMessageDialog(contentPane,"账号或密码不正确！");
					}
					
					
					
				}else if (customer.isSelected()) {
					String id = account.getText();
					int account = Integer.parseInt(id);
					String passwordString = String.valueOf(password.getPassword());
					
					if(IWOS.isCustomer(account, passwordString)) {
						
						cid = account;
						cpassword = passwordString;
						login.this.account.setText(null);
						password.setText(null);
						new mainCustomer();
					}else {
						login.this.account.setText(null);
						password.setText(null);
						JOptionPane.showMessageDialog(contentPane,"账号或密码不正确！");
					}
				}
				
			}
		});
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 20));
		btnNewButton.setBounds(329, 392, 157, 38);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4.setForeground(new Color(0, 0, 0));
		lblNewLabel_4.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\timg_gaitubao_671x449.jpg"));
		lblNewLabel_4.setBounds(0, 0, 796, 449);
		contentPane.add(lblNewLabel_4);
		
	}
}
