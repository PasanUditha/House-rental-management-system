
import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;

import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import java.awt.Color;

public class houseowners {

	private JFrame frame;
	private JTextField txtoname;
	private JTextField txtaddress;
	private JTextField txtnic;
	private JTextField txtphoneno;
	private JTable table;
	private JTextField txtoid;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					houseowners window = new houseowners();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//connection method to connection screen//
	public static void HouseOwnerScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					houseowners window = new houseowners();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public houseowners() {
		initialize();
		Connect();
		table_load();
	}

	Connection con;
	PreparedStatement pst ;
	ResultSet rs;
	
	public void Connect()
	{
		try {
			Class.forName("com.mysql.jdbc.Driver");
			con = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
		}
		catch (ClassNotFoundException ex)
		{
			
		}
		catch (SQLException ex)
		{
			
		}
	}
	
	public void table_load()
	{
		try
		{
			pst = con.prepareStatement("select * from houseowner");
			rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		}
		catch (SQLException e)
		{
			e.printStackTrace();
		}
	}
	
	
	
	
	
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 857, 548);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Owners");
		lblNewLabel.setForeground(Color.CYAN);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 28));
		lblNewLabel.setBounds(296, 10, 270, 48);
		frame.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Details", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(10, 68, 398, 265);
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_1 = new JLabel("Name");
		lblNewLabel_1_1.setForeground(Color.BLUE);
		lblNewLabel_1_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_1.setBounds(25, 27, 84, 29);
		panel.add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Address");
		lblNewLabel_1_2.setForeground(Color.BLUE);
		lblNewLabel_1_2.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_2.setBounds(25, 83, 84, 29);
		panel.add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("NIC");
		lblNewLabel_1_3.setForeground(Color.BLUE);
		lblNewLabel_1_3.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3.setBounds(25, 148, 84, 29);
		panel.add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Phone No");
		lblNewLabel_1_4.setForeground(Color.BLUE);
		lblNewLabel_1_4.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_4.setBounds(25, 200, 113, 29);
		panel.add(lblNewLabel_1_4);
		
		txtoname = new JTextField();
		txtoname.setColumns(10);
		txtoname.setBounds(119, 30, 247, 29);
		panel.add(txtoname);
		
		txtaddress = new JTextField();
		txtaddress.setColumns(10);
		txtaddress.setBounds(119, 86, 247, 29);
		panel.add(txtaddress);
		
		txtnic = new JTextField();
		txtnic.setColumns(10);
		txtnic.setBounds(119, 148, 247, 29);
		panel.add(txtnic);
		
		txtphoneno = new JTextField();
		txtphoneno.setColumns(10);
		txtphoneno.setBounds(119, 203, 247, 29);
		panel.add(txtphoneno);
		
		
		//save to data
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(Color.BLACK);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oname,address,nic,phoneno;
				
				oname = txtoname.getText();
				address = txtaddress.getText();
				nic = txtnic.getText();
			    phoneno = txtphoneno.getText();
			    
			    try {
			    	 Class.forName("com.mysql.jdbc.Driver");
					 con = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
			    	 pst = con.prepareStatement("insert into houseowner(Name,Address,NIC,PhoneNo)values(?,?,?,?)");
			    	 pst.setString(1, oname);
			    	 pst.setString(2, address);
			    	 pst.setString(3, nic);
			    	 pst.setString(4, phoneno);
			    	 pst.executeUpdate();
			    	 JOptionPane.showMessageDialog(null, "Record Added!!!!!!");
			    	 table_load();
			    	 
			    	 txtoname.setText("");
			    	 txtaddress.setText("");
			    	 txtnic.setText("");
			    	 txtphoneno.setText("");
			    	 txtoname.requestFocus();
			    }
			    
			    catch (Exception e1) {
			    	
			    	e1.printStackTrace();
			    }
				
				
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnNewButton.setBounds(24, 356, 105, 56);
		frame.getContentPane().add(btnNewButton);
		
		//exit from database
		JButton btnExit = new JButton("Exit");
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				System.exit(0);
				
				
				}
		});
		btnExit.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnExit.setBounds(199, 356, 105, 56);
		frame.getContentPane().add(btnExit);
		
		//clear the entire database
		JButton btnClear = new JButton("Clear");
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				 txtoname.setText("");
		    	 txtaddress.setText("");
		    	 txtnic.setText("");
		    	 txtphoneno.setText("");
		    	 txtoname.requestFocus();
				
			}
		});
		btnClear.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnClear.setBounds(314, 356, 105, 56);
		frame.getContentPane().add(btnClear);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(450, 68, 370, 334);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Search", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setBounds(14, 437, 394, 60);
		frame.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		txtoid = new JTextField();
		txtoid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
			
				         try {
				        	 
				         
				        	 String id = txtoid.getText();
				        	 
				        	 pst = con.prepareStatement("select name,address,nic,phoneno from houseowner where id = ?");
				        	 pst.setString(1, id);
				        	 ResultSet rs = pst.executeQuery();
				        	 
				        	 if(rs.next()==true)
				        	 {
				        		 String name = rs.getString(1);
				        		 String address = rs.getString(2);
				        		 String nic = rs.getString(3);
				        		 String phoneno = rs.getString(4);
				        		 
				        		 txtoname.setText(name);
				        		 txtaddress.setText(address);
				        		 txtnic.setText(nic);
				        		 txtphoneno.setText(phoneno);
				        		 
				        	 }
				        	 else
				        	 {
				        		 txtoname.setText("");
				        		 txtaddress.setText("");
				        		 txtnic.setText("");
				        		 txtphoneno.setText("");
				        	 }
				        	 
				        	 
				         }
				         catch (SQLException ex) {
			             
				         }
				         
			}
				         
				        
		
				
				
				
				
				
		
	    });
		txtoid.setColumns(10);
		txtoid.setBounds(114, 21, 247, 29);
		panel_1.add(txtoid);
		
		JLabel lblNewLabel_1_3_1 = new JLabel("Owner Id");
		lblNewLabel_1_3_1.setForeground(Color.RED);
		lblNewLabel_1_3_1.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNewLabel_1_3_1.setBounds(10, 21, 117, 29);
		panel_1.add(lblNewLabel_1_3_1);
		
		
		//update the database
		JButton btnUpdate = new JButton("Update");
		btnUpdate.setForeground(Color.BLACK);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				String oname,address,nic,phoneno,oid;
				
				oname = txtoname.getText();
				address = txtaddress.getText();
				nic = txtnic.getText();
				phoneno = txtphoneno.getText();
				oid = txtoid.getText();
				
				try {
					
					pst = con.prepareStatement("update houseowner set name=?,address=?,nic=?,phoneno=? where id=?");
					pst.setString(1, oname);
					pst.setString(2, address);
					pst.setString(3, nic);
					pst.setString(4, phoneno);
					pst.setString(5, oid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record update!!!!");
					table_load();
					
					txtoname.setText("");
					txtaddress.setText("");
					txtnic.setText("");
					txtphoneno.setText("");
					txtoname.requestFocus();
				}
				
				catch (SQLException e1) {
					
					  e1.printStackTrace();
				}
				
			
				
				
				
				
				
			}
		});
		btnUpdate.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnUpdate.setBounds(504, 412, 105, 56);
		frame.getContentPane().add(btnUpdate);
		
		
		//deleting entered data
		JButton btnDelete = new JButton("Delete");
		btnDelete.setForeground(Color.RED);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                  String oid;
                  
				    oid = txtoid.getText();
				
				try {
					
					pst = con.prepareStatement("delete from houseowner where id=?");
					
					pst.setString(1, oid);
					pst.executeUpdate();
					JOptionPane.showMessageDialog(null, "Record Delete!!!!");
					table_load();
					
					txtoname.setText("");
					txtaddress.setText("");
					txtnic.setText("");
					txtphoneno.setText("");
					txtoname.requestFocus();
				}
				
				catch (SQLException e1) {
					
					  e1.printStackTrace();
				}
				
			
				
				
				
				
				
				
				
				
			}
		});
		btnDelete.setFont(new Font("Tahoma", Font.BOLD, 14));
		btnDelete.setBounds(644, 412, 105, 56);
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pasan\\Downloads\\80526.jpeg"));
		lblNewLabel_1.setBounds(0, 0, 843, 511);
		frame.getContentPane().add(lblNewLabel_1);
	}
}

