import java.sql.*;

import java.awt.*;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Login extends JFrame {
	
	private Image img_logo=new ImageIcon(Login.class.getResource("res/1.png")).getImage().getScaledInstance(316,118,Image.SCALE_SMOOTH);
	private JFrame frame;
	private JTextField UserName1;
	private JTextField Password1;

	/**
	 * Launch the application.
	 */
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Login window = new Login();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	
	
	
	
	//For connecting two JFrames together following part should execute//
	public static void LoginScreen() {
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


	
	
	
	
	/**
	 * Create the application.
	 */
	public Login() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */

	
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 128, 128));
		frame.setBounds(100, 100, 707, 488);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("House Rental Management");
		lblNewLabel.setForeground(new Color(244, 164, 96));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setBounds(126, 10, 512, 54);
		frame.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Login");
		lblNewLabel_1.setForeground(new Color(240, 255, 255));
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_1.setBounds(303, 64, 79, 47);
		frame.getContentPane().add(lblNewLabel_1);
		
		UserName1 = new JTextField();
		UserName1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		UserName1.setBounds(249, 276, 333, 41);
		frame.getContentPane().add(UserName1);
		UserName1.setColumns(10);
		
		Password1 = new JTextField();
		Password1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		Password1.setColumns(10);
		Password1.setBounds(249, 327, 333, 41);
		frame.getContentPane().add(Password1);
		
		JLabel lblNewLabel_2 = new JLabel("User Name");
		lblNewLabel_2.setForeground(new Color(245, 255, 250));
		lblNewLabel_2.setBackground(new Color(0, 0, 0));
		lblNewLabel_2.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2.setBounds(90, 272, 175, 41);
		frame.getContentPane().add(lblNewLabel_2);
		
		JLabel lblNewLabel_2_1 = new JLabel("Password");
		lblNewLabel_2_1.setBackground(new Color(0, 0, 0));
		lblNewLabel_2_1.setForeground(new Color(248, 248, 255));
		lblNewLabel_2_1.setFont(new Font("Times New Roman", Font.PLAIN, 30));
		lblNewLabel_2_1.setBounds(90, 323, 175, 41);
		frame.getContentPane().add(lblNewLabel_2_1);
		
		JButton btnNewButton = new JButton("Login");
		btnNewButton.setForeground(new Color(139, 69, 19));
		
		
		
		
		
		
		
		//Log in process coding//
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg1) {
				
				
				String UserName;
				String Password;
				
				 UserName = UserName1.getText();
                 Password = Password1.getText();
                 
				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/houserental?characterEncoding=latin1","root","pasan1@sliit");
					PreparedStatement st = (PreparedStatement) 
					conn.prepareStatement("Select UserName, Password from user where UserName=? and Password=?");
					
					st.setString(1, UserName);
					st.setString(2, Password);
					ResultSet rs=st.executeQuery();
					if(rs.next())
						JOptionPane.showMessageDialog(null, "Login sucessfully");
					else
						JOptionPane.showMessageDialog(null, "Login Feild");
					new ConnectPage();
					ConnectPage.mainScreen();
					
				}catch(Exception e1) 
				{
					System.out.println(e1);
				}
			}
		
			
		});
		
		
		
		
		
		
		
		
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(371, 388, 85, 33);
		frame.getContentPane().add(btnNewButton);
		
		JButton SignIn = new JButton("SignIn");
		SignIn.setBackground(new Color(248, 248, 255));
		SignIn.setForeground(new Color(139, 69, 19));
		
		
		
		
		
		
		
		//for go to sign in process without login//
		SignIn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserRegister();
				UserRegister.SignScreen();
			}
		});
		SignIn.setFont(new Font("Tahoma", Font.PLAIN, 20));
		SignIn.setBounds(249, 389, 94, 31);
		frame.getContentPane().add(SignIn);
		
		JLabel Image1 = new JLabel("");
		Image1.setBounds(191, 121, 316, 118);
		Image1.setIcon(new ImageIcon(img_logo));
		frame.getContentPane().add(Image1);
	}
}
