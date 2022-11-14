import java.awt.EventQueue;
import java.sql.Connection;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

import net.proteanit.sql.DbUtils;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import javax.swing.ImageIcon;
import javax.swing.border.MatteBorder;
import java.awt.Color;
import javax.swing.border.EtchedBorder;

public class payment {

	private JFrame frame;
	private JTextField txtname;
	private JTextField txtnid;
	private JTextField txtpm;
	private JTextField txtamo;
	private JTextField txtdpaid;
	private JTextField txtpno;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment window = new payment();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public static void PaymentScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					payment window = new payment();
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
	public payment() {
		initialize();
		Connect();                 //connect to the database
		table_load();              //load the table
	}
	
	
	Connection c;
	PreparedStatement p;
	ResultSet r;
	
	
	
	
	
	
	private JTable table;
	private JTextField txtpid;
	
	
	 public void Connect()
	 
	    {
		 
	        try {
	            Class.forName("com.mysql.jdbc.Driver");
	            
	            c = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit"); //connect to the database of mysql
	        }
	        catch (ClassNotFoundException ex) 
	        {
	          
	        }
	        catch (SQLException ex) 
	        {
	        	   
	        }
	        

	    }
	 
	 void table_load()
	 
	    {
	    	try 
	    	{
		    p = c.prepareStatement("select * from payment");
		    
		    r = p.executeQuery();
		    
		    table.setModel(DbUtils.resultSetToTableModel(r));
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
		frame.setBounds(100, 100, 1027, 547);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Rent Payment");
		lblNewLabel.setBounds(265, 24, 276, 82);
		lblNewLabel.setFont(new Font("Times New Roman", Font.BOLD, 41));
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Name");
		lblNewLabel_1.setBounds(22, 125, 146, 40);
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("National ID");
		lblNewLabel_1_1.setBounds(22, 175, 146, 28);
		lblNewLabel_1_1.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1_1);
		
		JLabel lblNewLabel_1_2 = new JLabel("Payment Method");
		lblNewLabel_1_2.setBounds(22, 213, 146, 28);
		lblNewLabel_1_2.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1_2);
		
		JLabel lblNewLabel_1_3 = new JLabel("Amount");
		lblNewLabel_1_3.setBounds(22, 251, 146, 28);
		lblNewLabel_1_3.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1_3);
		
		JLabel lblNewLabel_1_4 = new JLabel("Date Paid");
		lblNewLabel_1_4.setBounds(22, 289, 146, 28);
		lblNewLabel_1_4.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1_4);
		
		JLabel lblNewLabel_1_5 = new JLabel("Phone Number");
		lblNewLabel_1_5.setBounds(22, 327, 146, 28);
		lblNewLabel_1_5.setFont(new Font("Times New Roman", Font.BOLD, 17));
		frame.getContentPane().add(lblNewLabel_1_5);
		
		txtname = new JTextField();
		txtname.setBounds(163, 132, 184, 31);
		frame.getContentPane().add(txtname);
		txtname.setColumns(10);
		
		txtnid = new JTextField();
		txtnid.setBounds(163, 178, 184, 28);
		frame.getContentPane().add(txtnid);
		txtnid.setColumns(10);
		
		txtpm = new JTextField();
		txtpm.setBounds(163, 216, 184, 28);
		frame.getContentPane().add(txtpm);
		txtpm.setColumns(10);
		
		txtamo = new JTextField();
		txtamo.setBounds(163, 254, 184, 28);
		frame.getContentPane().add(txtamo);
		txtamo.setColumns(10);
		
		txtdpaid = new JTextField();
		txtdpaid.setBounds(163, 293, 184, 25);
		frame.getContentPane().add(txtdpaid);
		txtdpaid.setColumns(10);
		
		txtpno = new JTextField();
		txtpno.setBounds(163, 330, 184, 28);
		frame.getContentPane().add(txtpno);
		txtpno.setColumns(10);
		
		JButton btnNewButton = new JButton("SAVE");
		btnNewButton.setBounds(223, 368, 124, 40);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			
				String Name,National_ID,Payment_method,Amount,Date_paid,Phone_number;
				
				Name = txtname.getText();
				National_ID = txtnid.getText();
				Payment_method = txtpm.getText();
				Amount= txtamo.getText();
				Date_paid = txtdpaid.getText();
				Phone_number = txtpno.getText();
				
				try {
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					p = c.prepareStatement("insert into payment(Name,National_ID,Payment_method,Amount,Date_paid,Phone_number)values(?,?,?,?,?,?)");
					p.setString(1, Name);
					p.setString(2, National_ID);
					p.setString(3, Payment_method);
					p.setString(4, Amount);
					p.setString(5, Date_paid);
					p.setString(6, Phone_number);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null, "All Information Saved Successfully");
					
					table_load();
						           
					txtname.setText("");
					txtnid.setText("");
					txtpm.setText("");
					txtamo.setText("");
					txtdpaid.setText("");
					txtpno.setText("");
					txtname.requestFocus();
				   }
			 
				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}

			
				
			}
		});
		btnNewButton.setFont(new Font("Times New Roman", Font.BOLD, 19));
		frame.getContentPane().add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setViewportBorder(new MatteBorder(5, 5, 5, 5, (Color) new Color(0, 0, 0)));
		scrollPane.setBounds(366, 116, 601, 292);
		frame.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 418, 371, 82);
		panel.setBorder(new TitledBorder(new EtchedBorder(EtchedBorder.LOWERED, new Color(255, 255, 255), new Color(160, 160, 160)), "Search", TitledBorder.LEADING, TitledBorder.TOP, null, new Color(0, 0, 0)));
		frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNewLabel_1_6 = new JLabel("Payment ID");
		lblNewLabel_1_6.setFont(new Font("Times New Roman", Font.BOLD, 17));
		lblNewLabel_1_6.setBounds(10, 24, 86, 38);
		panel.add(lblNewLabel_1_6);
		
		txtpid = new JTextField();
		txtpid.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				
				try {
			          
		            String Payment_ID = txtpid.getText();

		                p = c.prepareStatement("select Name,National_ID,Payment_method,Amount,Date_paid,Phone_number from payment where Payment_ID = ?");
		                p.setString(1, Payment_ID);
		                ResultSet rs = p.executeQuery();

		            if(rs.next()==true)
		            {
		              
		                String Name = rs.getString(1);
		                String National_ID = rs.getString(2);
		                String Payment_method = rs.getString(3);
		                String Amount = rs.getString(4);
		                String Date_paid = rs.getString(5);
		                String Phone_number = rs.getString(6);
		                
		                txtname.setText(Name);
						txtnid.setText(National_ID);
						txtpm.setText(Payment_method);
						txtamo.setText(Amount);
						txtdpaid.setText(Date_paid );
						txtpno.setText(Phone_number);
		                 
		                
		            }   
		            else
		            {
		            	txtname.setText("");
						txtnid.setText("");
						txtpm.setText("");
						txtamo.setText("");
						txtdpaid.setText("");
						txtpno.setText("");
		                 
		            }
		            


		        } 
			
			 catch (SQLException ex) {
		           
		        }
			
			
			
			
		}
				
				
				
			
		});
		txtpid.setColumns(10);
		txtpid.setBounds(150, 27, 187, 37);
		panel.add(txtpid);
		
		JButton btnUpdate = new JButton("UPDATE");
		btnUpdate.setBounds(528, 438, 124, 40);
		btnUpdate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
                String Name,National_ID,Payment_method,Amount,Date_paid,Phone_number,Payment_ID;
				
				Name = txtname.getText();
				National_ID = txtnid.getText();
				Payment_method = txtpm.getText();
				Amount= txtamo.getText();
				Date_paid = txtdpaid.getText();
				Phone_number = txtpno.getText();
				Payment_ID=txtpid.getText();
				
				try {
					c = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					p = c.prepareStatement("update payment set  Name= ?,National_ID= ?,Payment_method= ?,Amount= ?,Date_paid= ?,Phone_number= ? where Payment_ID =?");
					p.setString(1, Name);
					p.setString(2, National_ID);
					p.setString(3, Payment_method);
					p.setString(4, Amount);
					p.setString(5, Date_paid);
					p.setString(6, Phone_number);
					p.setString(7, Payment_ID);
					p.executeUpdate();
					JOptionPane.showMessageDialog(null, "Updated Successfully ");
					
					table_load();
						           
					txtname.setText("");
					txtnid.setText("");
					txtpm.setText("");
					txtamo.setText("");
					txtdpaid.setText("");
					txtpno.setText("");
					txtname.requestFocus();
				   }
			 
				catch (SQLException e1) 
			        {
									
				e1.printStackTrace();
				}

				
				
			}
		});
		btnUpdate.setFont(new Font("Times New Roman", Font.BOLD, 19));
		frame.getContentPane().add(btnUpdate);
		
		JButton btnDelete = new JButton("DELETE");
		btnDelete.setBounds(727, 438, 124, 40);
		btnDelete.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				    String Payment_ID;
					
					
					Payment_ID=txtpid.getText();
					
					try {
						c = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
						p = c.prepareStatement("delete from payment where Payment_ID =?");
						
						p.setString(1, Payment_ID);
						p.executeUpdate();
						JOptionPane.showMessageDialog(null, "Deleted Successfully");
						
						table_load();
							           
						txtname.setText("");
						txtnid.setText("");
						txtpm.setText("");
						txtamo.setText("");
						txtdpaid.setText("");
						txtpno.setText("");
						txtname.requestFocus();
					   }
				 
					catch (SQLException e1) 
				        {
										
					e1.printStackTrace();
					}

					
				
				
			}
		});
		btnDelete.setFont(new Font("Times New Roman", Font.BOLD, 19));
		frame.getContentPane().add(btnDelete);
		
		JLabel lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setIcon(new ImageIcon("C:\\Users\\Pasan\\Downloads\\rent4.jpg"));
		lblNewLabel_2.setBounds(0, 0, 1013, 510);
		frame.getContentPane().add(lblNewLabel_2);
	}
}
