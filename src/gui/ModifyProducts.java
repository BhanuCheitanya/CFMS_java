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
import java.awt.Font;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.awt.event.ActionEvent;

public class ModifyProducts extends JFrame {

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
					ModifyProducts frame = new ModifyProducts();
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
	public ModifyProducts() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("PRODUCT");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(360, 36, 154, 42);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER PRODUCT ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(332, 97, 239, 37);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("PRODUCT ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(172, 155, 171, 42);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(353, 155, 198, 42);
		contentPane.add(textField);
		textField.setColumns(10);
		JLabel lblNewLabel_7 = new JLabel("INVALID PRODUCT ID");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(353, 211, 198, 24);
		contentPane.add(lblNewLabel_7);
		lblNewLabel_7.setVisible(false);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Select * From Products where ProductID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					pstmst.setString(1,textField.getText());
					ResultSet rs= pstmst.executeQuery();
					if(rs.next())
					{
					  textField_1.setText(rs.getString("ProductName"));
					  textField_2.setText(rs.getString("ProductType"));
					  textField_3.setText(rs.getString("ProductPrice"));
					  textField_4.setText(rs.getString("ProductQuantity"));
					  
					 	  	
					}
					else {
						lblNewLabel_7.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(603, 157, 127, 42);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_3 = new JLabel("PRODUCT NAME");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(170, 266, 190, 42);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("PRODUCT TYPE");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(170, 318, 190, 42);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PRODUCT PRICE\r\n");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(170, 370, 190, 42);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("PRODUCT QUANTITY");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(170, 422, 190, 42);
		contentPane.add(lblNewLabel_6);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Update Products set ProductName=?,ProductType=?,ProductPrice=?,ProductQuantity=? Where ProductID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					
					pstmst.setString(1, textField_1.getText());
					pstmst.setString(2, textField_2.getText());
					pstmst.setString(3, textField_3.getText());
					pstmst.setString(4, textField_4.getText());
					pstmst.setString(5,textField.getText());
					pstmst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Updated");
					} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
			
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(210, 497, 127, 37);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Delete From Products Where ProductID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					pstmst.setString(1,textField.getText());
					pstmst.executeUpdate();
					JOptionPane.showMessageDialog(null,"Successfully Deleted");
					} 
				catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(387, 497, 127, 37);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLOSE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want To Go Back","Select",JOptionPane.YES_NO_OPTION);
		        if(a==0)
		        {
		            setVisible(false);
		           new Products().setVisible(true);
		            
		        }
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(554, 497, 127, 37);
		contentPane.add(btnNewButton_3);
		
		textField_1 = new JTextField();
		textField_1.setBounds(428, 271, 284, 42);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(428, 323, 284, 42);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(428, 375, 284, 42);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(428, 427, 284, 42);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		
	}

}
