package gui;

import java.awt.BorderLayout;
import java.sql.*;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

import com.mysql.cj.xdevapi.Result;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class searchEmployee extends JFrame {
public int flag=0;
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
					searchEmployee frame = new searchEmployee();
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
	public searchEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("EMPLOYEE ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(149, 138, 131, 34);
		contentPane.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Invalid Employee ID");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(318, 185, 194, 32);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(338, 138, 174, 34);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JButton btnNewButton = new JButton("SEARCH");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Select * From Employee where EmpID=?";
				PreparedStatement pstmst;
				try {
					pstmst = con.prepareStatement(sql);
					pstmst.setString(1,textField.getText());
					ResultSet rs= pstmst.executeQuery();
					if(rs.next())
					{
					  textField_1.setText(rs.getString("EmpName"));
					  textField_2.setText(rs.getString("EmpAge"));
					  textField_3.setText(rs.getString("EmpGender"));
					  textField_4.setText(rs.getString("EmpPhone"));
					  textField_5.setText(rs.getString("EmpAddress"));
					 	  	
					}
					else {
						lblNewLabel_1.setVisible(true);
					}
				} catch (SQLException e1) {
					// TODO Auto-generated catch block
					JOptionPane.showMessageDialog(null, "Connection Error");
				}
				
			}
		});
		btnNewButton.setBounds(571, 138, 123, 34);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("CANCEL");
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
		btnNewButton_1.setBounds(571, 494, 144, 35);
		contentPane.add(btnNewButton_1);
		
		JLabel lblNewLabel_2 = new JLabel("NAME\r\n");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(195, 224, 118, 32);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("AGE\r\n");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_3.setBounds(195, 271, 118, 32);
		contentPane.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("GENDER\r\n");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_4.setBounds(190, 313, 118, 32);
		contentPane.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("PHONE NUMBER");
		lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_5.setBounds(190, 360, 123, 32);
		contentPane.add(lblNewLabel_5);
		
		JLabel lblNewLabel_6 = new JLabel("ADDRESS");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel_6.setBounds(195, 414, 123, 32);
		contentPane.add(lblNewLabel_6);
		
		textField_1 = new JTextField();
		textField_1.setBounds(460, 227, 205, 32);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setBounds(460, 268, 205, 32);
		contentPane.add(textField_2);
		textField_2.setColumns(10);
		
		textField_3 = new JTextField();
		textField_3.setBounds(460, 316, 205, 32);
		contentPane.add(textField_3);
		textField_3.setColumns(10);
		
		textField_4 = new JTextField();
		textField_4.setBounds(460, 363, 205, 32);
		contentPane.add(textField_4);
		textField_4.setColumns(10);
		
		textField_5 = new JTextField();
		textField_5.setBounds(460, 417, 205, 32);
		contentPane.add(textField_5);
		textField_5.setColumns(10);
		
		JButton btnNewButton_2 = new JButton("UPDATE\r\n");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Update Employee set EmpName=?,EmpAge=?,EmpGender=?,EmpPhone=?,EmpAddress=? Where EmpID=?";
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
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(170, 494, 138, 35);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("DELETE");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con = ConnectionProvider.getCon();
				String sql="Delete From Employee Where EmpID=?";
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
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(360, 494, 136, 35);
		contentPane.add(btnNewButton_3);
		
		JLabel lblNewLabel_7 = new JLabel("Enter Employee ID ");
		lblNewLabel_7.setFont(new Font("Tahoma", Font.PLAIN, 25));
		lblNewLabel_7.setBounds(306, 90, 212, 27);
		contentPane.add(lblNewLabel_7);
		
		JLabel lblNewLabel_8 = new JLabel("EMPLOYEE\r\n");
		lblNewLabel_8.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblNewLabel_8.setBounds(327, 28, 169, 52);
		contentPane.add(lblNewLabel_8);
		
		
	}
}
