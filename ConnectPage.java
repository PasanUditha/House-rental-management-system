import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.Color;

public class ConnectPage {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectPage window = new ConnectPage();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	//connect methods to others//
	public static void mainScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ConnectPage window = new ConnectPage();
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
	public ConnectPage() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.getContentPane().setBackground(new Color(0, 139, 139));
		frame.setBounds(100, 100, 801, 473);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Available Tables");
		lblNewLabel.setForeground(new Color(248, 248, 255));
		lblNewLabel.setBackground(new Color(248, 248, 255));
		lblNewLabel.setFont(new Font("Times New Roman", Font.PLAIN, 40));
		lblNewLabel.setBounds(242, 29, 301, 53);
		frame.getContentPane().add(lblNewLabel);
		
		//connecting to userdetails//
		JButton btnNewButton = new JButton("User Detail");
		btnNewButton.setBackground(new Color(0, 0, 0));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new UserRegister();
				UserRegister.SignScreen();
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnNewButton.setBounds(92, 104, 609, 53);
		frame.getContentPane().add(btnNewButton);
		
		//connecting to house details//
		JButton btnHouseDetailTable = new JButton("House Detail ");
		btnHouseDetailTable.setBackground(new Color(0, 0, 0));
		btnHouseDetailTable.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new House();
				House.HouseScreen();
			}
		});
		btnHouseDetailTable.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHouseDetailTable.setBounds(92, 186, 609, 53);
		frame.getContentPane().add(btnHouseDetailTable);
		
		//connecting to house owners details//
		JButton btnHouseOwnerDetail = new JButton("House Owner Detail ");
		btnHouseOwnerDetail.setBackground(new Color(0, 0, 0));
		btnHouseOwnerDetail.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new houseowners();
				houseowners.HouseOwnerScreen();
			}
		});
		btnHouseOwnerDetail.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnHouseOwnerDetail.setBounds(92, 261, 609, 53);
		frame.getContentPane().add(btnHouseOwnerDetail);
		
		//connecting to payment details//
		JButton btnPaymentDetails = new JButton("Payment Details");
		btnPaymentDetails.setBackground(new Color(0, 0, 0));
		btnPaymentDetails.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				new payment();
				payment.PaymentScreen();
			}
		});
		btnPaymentDetails.setFont(new Font("Tahoma", Font.PLAIN, 30));
		btnPaymentDetails.setBounds(92, 340, 609, 53);
		frame.getContentPane().add(btnPaymentDetails);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setBackground(new Color(72, 61, 139));
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\Pasan\\Downloads\\9.jpg"));
		lblNewLabel_1.setBounds(0, 0, 787, 482);
		frame.getContentPane().add(lblNewLabel_1);
		
	}
}
