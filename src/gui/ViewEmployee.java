package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.sql.*;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;

public class ViewEmployee extends JFrame {

	private JPanel contentPane;
	private JTable table;
	private JButton btnNewButton_1;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ViewEmployee frame = new ViewEmployee();
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
	public ViewEmployee() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 900, 651);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		table = new JTable();
		table.setFont(new Font("Tahoma", Font.PLAIN, 15));
		table.setModel(new DefaultTableModel(
			new Object[][] {
				{"EmpID", "EmpName", "EmpAge", "EmpGender", "EmpPhone", "EmpAddress"},
			},
			new String[] {
				"New column", "New column", "New column", "New column", "New column", "New column"
			}
		));
		table.getColumnModel().getColumn(0).setPreferredWidth(92);
		table.getColumnModel().getColumn(1).setPreferredWidth(92);
		table.getColumnModel().getColumn(2).setPreferredWidth(92);
		table.getColumnModel().getColumn(3).setPreferredWidth(92);
		table.getColumnModel().getColumn(4).setPreferredWidth(92);
		table.getColumnModel().getColumn(5).setPreferredWidth(92);
		table.setBounds(76, 161, 740, 281);
		contentPane.add(table);
		
		JButton btnNewButton = new JButton("VIEW EMPLOYEES");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 25));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Connection con=ConnectionProvider.getCon();
				Statement st;
				try {
					st = con.createStatement();
					String sql=" Select * from Employee";
					ResultSet rs=st.executeQuery(sql);
					while(rs.next())
					{
						String EmpID=rs.getString("EmpID");
						String EmpName=rs.getString("EmpName");
						String EmpAge=rs.getString("EmpAge");
					    String EmpGender=rs.getString("EmpGender");
					    String EmpPhone=rs.getString("EmpPhone");
					    String EmpAddress=rs.getString("EmpAddress");
					    
					    String tbData[]= { EmpID,EmpName,EmpAge,EmpGender,EmpPhone,EmpAddress};
					    DefaultTableModel tblModel=(DefaultTableModel)table.getModel();
					    tblModel.addRow(tbData);
					
				} }
					catch (SQLException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				
			}
		});
		btnNewButton.setBounds(321, 38, 244, 69);
		contentPane.add(btnNewButton);
		
		btnNewButton_1 = new JButton("CLOSE");
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
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(390, 494, 122, 39);
		contentPane.add(btnNewButton_1);
	}
}
