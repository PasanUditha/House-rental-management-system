import java.sql.Connection;


import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.*;

import javax.swing.*;

import net.proteanit.sql.DbUtils;

import java.awt.Color;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;


@SuppressWarnings("serial")
public class UserRegister extends JFrame {

	private JPanel contentPane;
	private JTextField tNIC;
	private JTextField tUserName;
	private JTextField tPassword;
	private JTextField tPhoneNo;
	private JTextField tSearch;
	private JTable table;
	/**
	 * Launch the application.
	 */
	//main method//
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	//connection method to other pages//
	public static void SignScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					UserRegister frame = new UserRegister();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	

	Connection conn=null;
	PreparedStatement ps;
	ResultSet result;
	private JTextField tCity;
	private JTextField tGender;
	
	
	
	//connecting to database
	public void Connect() {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
			
		}catch(ClassNotFoundException e) {
			
		}catch(SQLException e) {
			
		}
		
	}
	
	
	
	
	
	//loading database details to GUI interface//
	public void table_load()
	{
		
		try {
			ps=conn.prepareStatement("select * from user");
			result=ps.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(result));
		}catch(SQLException e){
			
			e.printStackTrace();
		}
	}
	
	
	
	
	
	/**
	 * Create the frame.
	 */
	public UserRegister() {
		setForeground(new Color(46, 139, 87));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 726, 565);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(0, 139, 139));
		contentPane.setForeground(new Color(255, 255, 255));
		contentPane.setLayout(null);
		setContentPane(contentPane);
		
		tNIC = new JTextField();
		tNIC.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tNIC.setBounds(169, 193, 334, 31);
		contentPane.add(tNIC);
		tNIC.setColumns(10);
		
		tUserName = new JTextField();
		tUserName.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tUserName.setColumns(10);
		tUserName.setBounds(169, 70, 334, 31);
		contentPane.add(tUserName);
		
		tPassword = new JTextField();
		tPassword.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tPassword.setColumns(10);
		tPassword.setBounds(169, 111, 334, 31);
		contentPane.add(tPassword);
		
		tPhoneNo = new JTextField();
		tPhoneNo.setFont(new Font("Tahoma", Font.PLAIN, 15));
		tPhoneNo.setColumns(10);
		tPhoneNo.setBounds(169, 152, 334, 31);
		contentPane.add(tPhoneNo);
		
		JLabel UserName1 = new JLabel("User Name");
		UserName1.setForeground(new Color(245, 255, 250));
		UserName1.setBackground(new Color(224, 255, 255));
		UserName1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserName1.setBounds(26, 64, 203, 38);
		contentPane.add(UserName1);
		
		JLabel Password1 = new JLabel("Password");
		Password1.setForeground(new Color(245, 255, 250));
		Password1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password1.setBounds(26, 105, 203, 38);
		contentPane.add(Password1);
		
		JLabel PhoneNo1 = new JLabel("Phone Number");
		PhoneNo1.setForeground(new Color(245, 255, 250));
		PhoneNo1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		PhoneNo1.setBounds(26, 146, 203, 38);
		contentPane.add(PhoneNo1);
		
		JLabel NIC1 = new JLabel("NIC");
		NIC1.setForeground(new Color(245, 255, 250));
		NIC1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		NIC1.setBounds(26, 187, 203, 38);
		contentPane.add(NIC1);
		
		JLabel lblNewLabel_1 = new JLabel("User Details");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBackground(new Color(0, 139, 139));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(253, 10, 360, 47);
		contentPane.add(lblNewLabel_1);
		
		
		
		
		
		
		
		//SAVE FUNTION//
		JButton btnNewButton = new JButton("Save");
		btnNewButton.setForeground(new Color(139, 69, 19));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName,NIC,Password;
				String PhoneNo,Gender,City;
				
				UserName=tUserName.getText();
				NIC=tNIC.getText();
				Password=tPassword.getText();
				PhoneNo=tPhoneNo.getText();
				Gender=tGender.getText();
				City=tCity.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					PreparedStatement ps =conn.prepareStatement("insert into user(UserName,Password,PhoneNo,NIC,City,Gender) values(?,?,?,?,?,?)");
					ps.setString(1,UserName);
					ps.setString(2,Password);
					ps.setString(3,PhoneNo);
					ps.setString(4,NIC);
					ps.setString(5, City);
					ps.setString(6, Gender);
					
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Sign Up sucessfully");
						System.out.println("Sign up done sucessfully");
					}else {
						JOptionPane.showMessageDialog(null, "Sign up faild");
						System.out.println("Sign up faild");
					}
					
					tUserName.setText("");
					tNIC.setText("");
					tPassword.setText("");
					tPhoneNo.setText("");
					tCity.setText("");
					tGender.setText("");
					tUserName.requestFocus();
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(539, 70, 163, 37);
		contentPane.add(btnNewButton);
		
		
		
		
		
		
		
		
		//UPDATE FUNTION//
		JButton btnNewButton_1_1 = new JButton("Update");
		btnNewButton_1_1.setForeground(new Color(139, 69, 19));
		btnNewButton_1_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String UserName,NIC,Password;
				String PhoneNo,Gender,City;
				
				UserName=tUserName.getText();
				NIC=tNIC.getText();
				Password=tPassword.getText();
				PhoneNo=tPhoneNo.getText();
				Gender=tGender.getText();
				City=tCity.getText();
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					PreparedStatement ps =conn.prepareStatement("update user set UserName=?,Password=?,PhoneNo=? where NIC=?");
					ps.setString(1,UserName);
					ps.setString(2,Password);
					ps.setString(3,PhoneNo);
					ps.setString(4,NIC);
					ps.setString(5, City);
					ps.setString(6, Gender);
					int x = ps.executeUpdate();
					
					tUserName.setText("");
					tNIC.setText("");
					tPassword.setText("");
					tPhoneNo.setText("");
					tGender.setText("");
					tCity.setText("");
					tUserName.requestFocus();
					
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Updated");
						System.out.println("Update done sucessfully");
					}else {
						JOptionPane.showMessageDialog(null, "Update Unsucessful");
						System.out.println("Update faild");
					}
					
				
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_1.setBounds(539, 118, 163, 38);
		contentPane.add(btnNewButton_1_1);
		
		
		
		
		
		
		//DELETE FUNTION//
		JButton btnNewButton_1_2 = new JButton("Delete");
		btnNewButton_1_2.setForeground(new Color(139, 69, 19));
		btnNewButton_1_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String NIC;
				
			
				NIC=tNIC.getText();
			
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					PreparedStatement ps =conn.prepareStatement("delete from user where NIC=?");
				
					ps.setString(1,NIC);
					int x = ps.executeUpdate();
					if(x>0) {
						JOptionPane.showMessageDialog(null, "Delete done sucessfully");
						System.out.println("Delete done sucessfully");
					}else {
						JOptionPane.showMessageDialog(null, "Delete is Unsucessfull");
						System.out.println("Delete faild");
					}
					
					tUserName.setText("");
					tNIC.setText("");
					tPassword.setText("");
					tPhoneNo.setText("");
					tGender.setText("");
					tCity.setText("");
					tUserName.requestFocus();
					
				}catch(Exception e1) {
					System.out.println(e1);
				}
			}
		});
		btnNewButton_1_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1_2.setBounds(539, 169, 163, 38);
		contentPane.add(btnNewButton_1_2);
		
		
		
		
		
		
		//EXIT BUTTON CONNECT WITH THE main Interface
		JButton btnNewButton_2 = new JButton("Exit");
		btnNewButton_2.setForeground(new Color(139, 69, 19));
		btnNewButton_2.addActionListener(new ActionListener() {
			@SuppressWarnings("static-access")
			public void actionPerformed(ActionEvent e) {
				ConnectPage n4=new ConnectPage();
				n4.mainScreen();
			}
		});
		
		
		
		
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(617, 220, 85, 38);
		contentPane.add(btnNewButton_2);
		
		JLabel lblNewLabel = new JLabel("Enter NIC");
		lblNewLabel.setForeground(new Color(245, 255, 250));
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(26, 353, 110, 31);
		contentPane.add(lblNewLabel);
		
		
		
		
		
		
		//select function//
		tSearch = new JTextField();
		tSearch.addKeyListener(new KeyAdapter() {
			@Override
			public void keyReleased(KeyEvent e) {
				try {
					String NIC=tSearch.getText();
						Class.forName("com.mysql.jdbc.Driver");
						Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
						ps=conn.prepareStatement("select UserName,Password,NIC,PhoneNo,Gender,City from user where NIC = ?");
						ps.setString(1, NIC);
						ResultSet result=ps.executeQuery();
						
						if(result.next()==true)
						{
							String UserName=result.getString(1);
							String Gender=result.getString(2);
							result.getString(3);
							String City=result.getString(3);
							String PhoneNo=result.getString(4);
							
							tUserName.setText(UserName);
							tPassword.setText("#######");
							tGender.setText(Gender);
							tCity.setText(City);
							tNIC.setText(NIC);
							tPhoneNo.setText(PhoneNo);
							
							
						}else {
							tUserName.setText("");
							tGender.setText("");
							tCity.setText("");
							tPassword.setText("");
							tPhoneNo.setText("");
							tNIC.setText("");

						}
						
				}catch(Exception e1) {
					
				}
			}
		});
		tSearch.setBounds(130, 351, 321, 36);
		contentPane.add(tSearch);
		tSearch.setColumns(10);
		
		
		
		
		JScrollPane Table0 = new JScrollPane();
		Table0.setBounds(26, 394, 676, 124);
		contentPane.add(Table0);
		
		table = new JTable();
		Table0.setViewportView(table);
		
		
		
		
		
		
		//view table to gui//
		JButton btnNewButton_1 = new JButton("Veiw Table");
		btnNewButton_1.setForeground(new Color(139, 69, 19));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					ps=conn.prepareStatement("select * from user");
				
					ResultSet rs=ps.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
				}catch(Exception e2){
					
					e2.printStackTrace();
				}
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(479, 351, 223, 35);
		contentPane.add(btnNewButton_1);
		
		
		
		
		
		
		
		tCity = new JTextField();
		tCity.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tCity.setColumns(10);
		tCity.setBounds(169, 278, 334, 31);
		contentPane.add(tCity);
		
		JLabel Gender1 = new JLabel("Gender");
		Gender1.setForeground(new Color(245, 245, 245));
		Gender1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Gender1.setBounds(26, 235, 85, 31);
		contentPane.add(Gender1);
		
		JLabel City1 = new JLabel("City");
		City1.setForeground(new Color(245, 255, 250));
		City1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		City1.setBounds(26, 278, 110, 31);
		contentPane.add(City1);
		
		
		
		
		
		
		//selecting gender from combo box//
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.addItem("Male");
		comboBox.addItem("Female");
		comboBox.setSelectedItem(null);
		
		comboBox.setFont(new Font("Tahoma", Font.PLAIN, 20));
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String SelectedValue=comboBox.getSelectedItem().toString();
				
				tGender.setText(SelectedValue);
			}
		});
		comboBox.setBounds(169, 234, 140, 31);
		contentPane.add(comboBox);
		
		tGender = new JTextField();
		tGender.setFont(new Font("Tahoma", Font.PLAIN, 20));
		tGender.setBounds(341, 234, 163, 31);
		contentPane.add(tGender);
		tGender.setColumns(10);
		
		JLabel Wallpaper = new JLabel("Wallpaper");
		Wallpaper.setIcon(new ImageIcon("C:\\Users\\Pasan\\Downloads\\9.jpg"));
		Wallpaper.setBounds(0, 0, 712, 528);
		contentPane.add(Wallpaper);
	}
}
