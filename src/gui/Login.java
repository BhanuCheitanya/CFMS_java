package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTextField;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Login extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login frame = new Login();
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
	public Login() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 901, 652);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("LOGIN ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel.setBounds(198, 232, 173, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("PASSWORD\r\n");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(198, 331, 173, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("LOGIN DETAILS");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 42));
		lblNewLabel_2.setBounds(285, 56, 305, 70);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("Invalid Login Credentials");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(309, 149, 281, 37);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		JButton btnNewButton = new JButton("LOGIN");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(textField.getText().equals("Admin")&& passwordField.getText().equals("Admin1234"))
				{
				
					setVisible(false);
				    new Main().setVisible(true);
				}
				
				else {
					
					lblNewLabel_3.setVisible(true);
				}
				
			}
		});
		btnNewButton.setBounds(279, 454, 92, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE\r\n");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				 int a=JOptionPane.showConfirmDialog(null,"Do You Want To Close The Application ","Select",JOptionPane.YES_NO_OPTION);
			        if(a==0)
			        {
			            System.exit(0);
			        }
			}
		});
		btnNewButton_1.setBounds(478, 454, 101, 37);
		contentPane.add(btnNewButton_1);
		
		textField = new JTextField();
		textField.setBounds(478, 232, 234, 39);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(478, 337, 234, 37);
		contentPane.add(passwordField);
		
		

	}
}
