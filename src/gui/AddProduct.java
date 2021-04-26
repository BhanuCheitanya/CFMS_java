package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.ComboBoxEditor;
import javax.swing.DefaultComboBoxModel;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.Statement;
import java.awt.event.ActionEvent;

public class AddProduct extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AddProduct frame = new AddProduct();
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
	public AddProduct() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 30));
		lblNewLabel.setBounds(358, 40, 159, 36);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("KINDLY FILL THIS FORM TO ENTER PRODUCT DETAILS");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(173, 103, 506, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(152, 167, 192, 42);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(152, 230, 192, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRODUCT TYPE\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(152, 302, 192, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PRODUCT PRICE");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(152, 367, 192, 42);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PRODUCT QUANTITY");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(152, 419, 192, 42);
		contentPane.add(lblNewLabel_6);
		
		textField = new JTextField();
		textField.setBounds(445, 172, 268, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(445, 235, 268, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(445, 372, 268, 42);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(445, 432, 268, 42);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		JComboBox CB = new JComboBox();
		CB.setFont(new Font("Tahoma", Font.PLAIN, 20));
		CB.setModel(new DefaultComboBoxModel(new String[] {"SELECT TYPE", "SNACK", "COLD DRINK", "HOT DRINK", "SWEET"}));
		CB.setBounds(445, 302, 268, 42);
		contentPane.add(CB);
		
		JButton btnNewButton = new JButton("SAVE\r\n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String ProductID= textField.getText();
				String ProductName= textField_1.getText();
				String ProductType= (String)CB.getSelectedItem();
				String ProductPrice= textField_2.getText();
				String ProductQuantity= textField_3.getText();
				try {
					Connection con= ConnectionProvider.getCon();
					Statement st= con.createStatement();
					 st.executeUpdate("Insert into Products values('"+ProductID+"','"+ProductName+"','"+ProductType+"','"+ProductPrice+"','"+ProductQuantity+"')");
			           JOptionPane.showMessageDialog(null,"Succesfully Added");
			           setVisible(false);
			          new addEmployee().setVisible(true);
				}
				catch(Exception E)
				{
					 JOptionPane.showMessageDialog(null," Enter Data In The Correct Order!");
				}
			
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(281, 519, 100, 36);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CLOSE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want To Go Back","Select",JOptionPane.YES_NO_OPTION);
		        if(a==0)
		        {
		            setVisible(false);
		           new Products().setVisible(true);
		            
		        }
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(466, 519, 108, 36);
		contentPane.add(btnNewButton_1);
		
		
	}
}
