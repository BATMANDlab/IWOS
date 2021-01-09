package View;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.security.auth.login.AccountException;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.Font;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class mainFirm extends JFrame {

	private JPanel contentPane;
	public int fid;

	/**
	 * Launch the application.
	 */
	/*
	 * public static void main(String[] args) { EventQueue.invokeLater(new
	 * Runnable() { public void run() { try { mainFirm frame = new mainFirm();
	 * frame.setVisible(true); } catch (Exception e) { e.printStackTrace(); } } });
	 * }
	 */

	/**
	 * Create the frame.
	 */
	public mainFirm(int fid) {
		this.fid = fid;
		setTitle("\u5546\u5BB6\u4E3B\u9875");
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 550, 402);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("\u67E5\u770B\u8BA2\u5355");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new firmOrder(fid);
			}
		});
		btnNewButton.setForeground(Color.BLUE);
		btnNewButton.setFont(new Font("ËÎÌו", Font.PLAIN, 45));
		
		btnNewButton.setBounds(136, 10, 241, 82);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u65B0\u54C1\u4E0A\u67B6");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new addGoods();
			}
		});
		btnNewButton_1.setForeground(Color.BLUE);
		btnNewButton_1.setFont(new Font("ËÎÌו", Font.PLAIN, 45));
		btnNewButton_1.setBounds(136, 134, 241, 89);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("\u66F4\u65B0\u5E93\u5B58");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				new updateGoods(fid);
			}
		});
		btnNewButton_2.setForeground(Color.BLUE);
		btnNewButton_2.setFont(new Font("ËÎÌו", Font.PLAIN, 45));
		btnNewButton_2.setBounds(136, 276, 241, 79);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("D:\\\u8003\u8BD5\u8D44\u6599\\JAVA\\\u5927\u4E09\u4E0A_\u5B9E\u8BAD\\sky_gaitubao_690x355.jpg"));
		lblNewLabel.setBounds(10, 10, 526, 355);
		contentPane.add(lblNewLabel);
		this.setVisible(true);
	}

}
