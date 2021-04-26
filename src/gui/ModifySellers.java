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

public class ModifySellers extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModifySellers frame = new ModifySellers();
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
	public ModifySellers() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("SELLER");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel.setBounds(382, 34, 121, 44);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("ENTER SELLER'S ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_1.setBounds(344, 107, 228, 31);
		contentPane.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("SELLER ID");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(180, 169, 121, 38);
		contentPane.add(lblNewLabel_2);
		
		textField = new JTextField();
		textField.setBounds(344, 169, 186, 38);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_3 = new JLabel("INVALID SELLER'S ID");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_3.setBounds(344, 217, 204, 31);
		contentPane.add(lblNewLabel_3);
		lblNewLabel_3.setVisible(false);
		
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Select * From Sellers where SellerID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					pstmst.setString(1,textField.getText());
					ResultSet rs= pstmst.executeQuery();
					if(rs.next())
					{
					  textField_1.setText(rs.getString("SellerName"));
					  textField_2.setText(rs.getString("SellerCompanyName"));
					  textField_3.setText(rs.getString("SellerProduct"));
					  textField_4.setText(rs.getString("SellerAddress"));
					  textField_5.setText(rs.getString("SellerPhone"));
					  
					 	  	
					}
					else {
						lblNewLabel_3.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.setBounds(586, 171, 112, 38);
		contentPane.add(btnNewButton);
		
		
		
		JLabel lblNewLabel_4 = new JLabel("SELLER'S NAME");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_4.setBounds(128, 258, 243, 38);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("SELLER'S COMPANY NAME");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_5.setBounds(128, 306, 243, 38);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("SELLER'S PRODUCT");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_6.setBounds(128, 354, 240, 38);
		contentPane.add(lblNewLabel_6);
		
		JLabel lblNewLabel_7 = new JLabel("SELLER'S ADDRESS");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_7.setBounds(123, 402, 248, 38);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("SELLER'S PHONE NUMBER");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_8.setBounds(128, 450, 243, 38);
		contentPane.add(lblNewLabel_8);
		
		textField_1 = new JTextField();
		textField_1.setBounds(425, 258, 315, 38);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(425, 306, 315, 38);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(425, 354, 315, 38);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(425, 402, 315, 38);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(425, 450, 315, 38);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_1 = new JButton("UPDATE");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Update Sellers set SellerName=?,SellerCompanyName=?,SellerProduct=?,SellerAddress=?,SellerPhone=? Where SellerID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					
					pstmst.setString(1, textField_1.getText());
					pstmst.setString(2, textField_2.getText());
					pstmst.setString(3, textField_3.getText());
					pstmst.setString(4, textField_4.getText());
					pstmst.setString(5, textField_5.getText());
					pstmst.setString(6,textField.getText());
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
		btnNewButton_1.setBounds(229, 536, 121, 38);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("DELETE");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Delete From Sellers Where SellerID=?";
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
		btnNewButton_2.setBounds(398, 536, 121, 38);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("CLOSE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int a=JOptionPane.showConfirmDialog(null,"Do You Want To Go Back","Select",JOptionPane.YES_NO_OPTION);
		        if(a==0)
		        {
		            setVisible(false);
		           new Seller().setVisible(true);
		            
		        }
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(562, 536, 121, 38);
		contentPane.add(btnNewButton_3);
	}

}
