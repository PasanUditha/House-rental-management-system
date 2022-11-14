import java.awt.EventQueue;
import java.sql.*;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

import javax.swing.JTable;
import javax.swing.JScrollPane;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.ImageIcon;



public class House {

	private JFrame frame;
	private JTextField textField1;
	private JTextField textField2;
	private JTextField textField3;
	private JTextField textField4;
	private JTextField textField5;
	private JTable table;
	private JTextField textFieldSearch;

	/**
	 * Launch the application.
	 */
	//Main method
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					House window = new House();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//go to connection page
	public static void HouseScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					House window = new House();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	//Database connection
	public static class databaseConnection{
		
		Connection con = null;
		public static Connection databaseConnector() {
			try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");				
					JOptionPane.showMessageDialog(null,"Successfully Connected to the Database.");
					return con;
			}catch(Exception e) {
				JOptionPane.showMessageDialog(null,"Connection Error!!!!!!");
				return null;
			}
		}
	}

	Connection con = null;
	/**
	 * Create the application.
	 */
	public House() {
		initialize();
		con = databaseConnection.databaseConnector();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 644, 652);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House ID");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(30, 61, 107, 27);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("House Type");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(30, 110, 107, 26);
		frame.getContentPane().add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Size(sq/ft)");
		lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_2.setBounds(30, 162, 107, 30);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("No Of Rooms");
		lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_3.setBounds(30, 203, 107, 30);
		frame.getContentPane().add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("Rent (rs.)");
		lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_4.setBounds(30, 254, 107, 27);
		frame.getContentPane().add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("House Information");
		lblNewLabel_5.setFont(new Font("Arial Black", Font.PLAIN, 22));
		lblNewLabel_5.setBounds(195, 11, 252, 35);
		frame.getContentPane().add(lblNewLabel_5);
		
		//Insert data in to the database
		JButton btnNewButton = new JButton("Save");
		Image img = new ImageIcon(this.getClass().getResource("/Saveicon.png")).getImage();
		btnNewButton.setIcon(new ImageIcon(img));
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String Query = "INSERT INTO house(HID,Type, No_Of_Rooms, Size, Rent) VALUES ('"+textField1.getText()+"','"+textField2.getText()+"','"+textField4.getText()+"','"+textField3.getText()+"','"+textField5.getText()+"')";
					PreparedStatement stat =  con.prepareStatement(Query);
					int rs = stat.executeUpdate();
					
					if(rs > 0 ) {
						JOptionPane.showMessageDialog(null,"Data Saved Successfully");
					}
					
					else {
						JOptionPane.showMessageDialog(null,"Data Not Saved!!!!");
					}
					
					stat.close();
					
				}catch(Exception e1) {JOptionPane.showMessageDialog(null,e1);}
			}
		});
		btnNewButton.setBounds(482, 60, 117, 35);
		frame.getContentPane().add(btnNewButton);
		
		textField1 = new JTextField();
		textField1.setBounds(183, 57, 252, 36);
		frame.getContentPane().add(textField1);
		textField1.setColumns(10);
		
		textField2 = new JTextField();
		textField2.setBounds(183, 108, 252, 36);
		frame.getContentPane().add(textField2);
		textField2.setColumns(10);
		
		textField3 = new JTextField();
		textField3.setBounds(183, 156, 252, 36);
		frame.getContentPane().add(textField3);
		textField3.setColumns(10);
		
		textField4 = new JTextField();
		textField4.setBounds(183, 203, 252, 36);
		frame.getContentPane().add(textField4);
		textField4.setColumns(10);
		
		textField5 = new JTextField();
		textField5.setBounds(183, 252, 252, 36);
		frame.getContentPane().add(textField5);
		textField5.setColumns(10);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(30, 404, 569, 186);
		frame.getContentPane().add(scrollPane);
		
		//Show Table details in text Fields
		table = new JTable();
		table.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try {
					int rownumber = table.getSelectedRow();
					String hidNew = (table.getModel().getValueAt(rownumber, 0).toString());
					
					String query = "Select * from house where HID = '"+hidNew+"'";
					
					PreparedStatement stat = con.prepareStatement(query);
					ResultSet rs = stat.executeQuery();
					
					while(rs.next()) {
						textField1.setText(rs.getString("HID"));
						textField2.setText(rs.getString("Type"));
						textField4.setText(rs.getString("No_Of_Rooms"));
						textField3.setText(rs.getString("Size"));
						textField5.setText(rs.getString("Rent"));
					}
					
					stat.close();
				}
				
				catch(Exception e1){
					JOptionPane.showMessageDialog(null,"!!!!Error Occuerd!!!!");
				}
				
			}
		});
		scrollPane.setViewportView(table);
		
		//Creating Jtable
		JButton btnNewButton_1 = new JButton("Table");
		Image image1 = new ImageIcon(this.getClass().getResource("/Load.png")).getImage();
		btnNewButton_1.setIcon(new ImageIcon(image1));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
						
						String Query = "Select * from house";
						PreparedStatement stat = con.prepareStatement(Query);
						ResultSet rs = stat.executeQuery();
						table.setModel(DbUtils.resultSetToTableModel(rs));
						
						stat.close();
					
				}catch(Exception e2) {
					JOptionPane.showMessageDialog(null,"Table Loading Error!!!");
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_1.setBounds(482, 274, 117, 40);
		frame.getContentPane().add(btnNewButton_1);
		
		
		//Update database
		JButton btnNewButton_2 = new JButton("Update");
		Image image2 = new ImageIcon(this.getClass().getResource("/Update.png")).getImage();
		btnNewButton_2.setIcon(new ImageIcon(image2));
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					
					String query = "Update house set HID = '"+textField1.getText()+"',Type = '"+textField2.getText()+"', No_Of_Rooms = '"+textField4.getText()+"', Size = '"+textField3.getText()+"', Rent = '"+textField5.getText()+"' Where HID = '"+textField1.getText()+"'";
					PreparedStatement stat = con.prepareStatement(query);
					int rs = stat.executeUpdate();	
					
					if(rs > 0) {
						JOptionPane.showMessageDialog(null,"Data Updated Successfully");
					}
					
					else {
						JOptionPane.showMessageDialog(null,"Data Not Updated!!!!");
					}
					stat.close();
				
			}catch(Exception e3) {
				JOptionPane.showMessageDialog(null,e3);
			}
				
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_2.setBounds(482, 107, 117, 35);
		frame.getContentPane().add(btnNewButton_2);
		
		
		//Delete Database
		JButton btnNewButton_3 = new JButton("Delete");
		Image image3 = new ImageIcon(this.getClass().getResource("/Delete.png")).getImage();
		btnNewButton_3.setIcon(new ImageIcon(image3));
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {		
					String query = "Delete From house Where HID = '"+textField1.getText()+"'";
					PreparedStatement stat =  con.prepareStatement(query);
					int rs = stat.executeUpdate();
					if(rs>0) {
						JOptionPane.showMessageDialog(null,"Data Deleted Successfully");
						
					}
					
					else {JOptionPane.showMessageDialog(null,"Data Not Deleted!!!!");}
					
					stat.close();
					
				}catch(Exception e1) {System.out.println(e1);}
				
			}
		});
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_3.setBounds(482, 155, 117, 35);
		frame.getContentPane().add(btnNewButton_3);
		
		
		//clear text fields
		JButton btnNewButton_4 = new JButton("Clear");
		Image image4 = new ImageIcon(this.getClass().getResource("/Clear.png")).getImage();
		btnNewButton_4.setIcon(new ImageIcon(image4));
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField1.setText("");
				textField2.setText("");
				textField3.setText("");
				textField4.setText("");
				textField5.setText("");
				textField1.requestFocus();
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_4.setBounds(482, 197, 117, 36);
		frame.getContentPane().add(btnNewButton_4);
		
		
		//Search Table Details
		textFieldSearch = new JTextField();
		textFieldSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					
					String query = "Select * From house Where HID = '"+textFieldSearch.getText()+"'";
					PreparedStatement stat =  con.prepareStatement(query);
					ResultSet rs = stat.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
					stat.close();
					
				}catch(Exception e1) {System.out.println(e1);}
				
			}
		});
		textFieldSearch.setBounds(183, 333, 252, 35);
		frame.getContentPane().add(textFieldSearch);
		textFieldSearch.setColumns(10);
		
		JLabel lblNewLabel_6 = new JLabel("Search ID :");
		lblNewLabel_6.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel_6.setBounds(63, 335, 131, 25);
		frame.getContentPane().add(lblNewLabel_6);
		
		JButton btnNewButton_5 = new JButton("Exit");
		Image image5 = new ImageIcon(this.getClass().getResource("/Exit.png")).getImage();
		btnNewButton_5.setIcon(new ImageIcon(image5));
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try{
					con.close();
					System.exit(0);
				}catch(Exception e1) {
					JOptionPane.showMessageDialog(null,"Error!!!");
				}
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_5.setBounds(482, 328, 117, 40);
		frame.getContentPane().add(btnNewButton_5);
		
		JLabel lblNewLabel_7 = new JLabel("");
		Image image7 = new ImageIcon(this.getClass().getResource("/backgd.png")).getImage();
		lblNewLabel_7.setIcon(new ImageIcon(image7));
		lblNewLabel_7.setBounds(0, 0, 628, 613);
		frame.getContentPane().add(lblNewLabel_7);
	}
}

