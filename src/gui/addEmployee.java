package gui;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import  java.sql.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class addEmployee extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					addEmployee frame = new addEmployee();
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
	public addEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(364, 26, 163, 37);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KINDLY FILL THIS FORM TO ADD DETAILS OF EMPLOYEE");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(189, 73, 514, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("EMPLOYEE ID\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(173, 134, 250, 35);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("EMPLOYEE NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(173, 187, 250, 35);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("EMPLOYEE AGE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(173, 243, 250, 35);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("EMPLOYEE GENDER");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(173, 296, 250, 35);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("EMPLOYEE PHONE NUMBER");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(173, 356, 250, 35);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("EMPLOYEE ADDRESS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(173, 420, 250, 35);
		contentPane.add(lblNewLabel_7);
		
		textField = new JTextField();
		textField.setBounds(527, 138, 220, 35);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(527, 191, 220, 35);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(527, 246, 220, 35);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		JComboBox CB = new JComboBox();
		CB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CB.setModel(new DefaultComboBoxModel(new String[] {"SELECT GENDER", "MALE", "FEMALE", "TRANSGENDER"}));
		CB.setBounds(527, 296, 220, 35);
		contentPane.add(CB);
		
		textField_3 = new JTextField();
		textField_3.setBounds(527, 357, 220, 35);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(527, 420, 220, 35);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String EmpID= textField.getText();
			String EmpName= textField_1.getText();
			String EmpAge = textField_2.getText();
			String EmpGender= (String)CB.getSelectedItem();
			String EmpPhone = textField_3.getText();
			String EmpAddress = textField_4.getText();
			
			try {
				Connection con= ConnectionProvider.getCon();
				Statement st= con.createStatement();
				 st.executeUpdate("Insert into Employee values('"+EmpID+"','"+EmpName+"','"+EmpAge+"','"+EmpGender+"','"+EmpPhone+"','"+EmpAddress+"')");
		           JOptionPane.showMessageDialog(null,"Succesfully Added");
		           setVisible(false);
		          new addEmployee().setVisible(true);
			}
			catch(Exception E)
			{
				 JOptionPane.showMessageDialog(null," Database Error!");
			}
		
					}
		});
		btnNewButton.setBounds(280, 504, 99, 37);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want To Go Back","Select",JOptionPane.YES_NO_OPTION);
		        if(a==0)
		        {
		            setVisible(false);
		           new Employee().setVisible(true);
		            
		        }
			}
		});
		btnNewButton_1.setBounds(492, 504, 103, 37);
		contentPane.add(btnNewButton_1);
		
		
	}
}
