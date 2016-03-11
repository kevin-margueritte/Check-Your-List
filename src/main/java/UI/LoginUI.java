package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SpringLayout;
import javax.swing.SwingConstants;

import facade.LoginFacade;
import model.person.User;

@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener{
	
	private LoginFacade login;
	private JTextField textLogin;
	private JPasswordField textPassword;
	private JLabel labelTitle;
	private JLabel labelLogin;
	private JLabel labelPassword;
	
	public static void main(String args[]) {
		LoginUI.launch();
	}

	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LoginUI frame = new LoginUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public LoginUI() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.login = new LoginFacade();
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		textLogin = new JTextField();
		springLayout.putConstraint(SpringLayout.WEST, textLogin, 45, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, textLogin, -124, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textLogin, -45, SpringLayout.EAST, getContentPane());
		getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		textPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.WEST, textPassword, 45, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, textPassword, -45, SpringLayout.EAST, getContentPane());
		textPassword.setColumns(10);
		getContentPane().add(textPassword);
		
		JButton buttonConnect = new JButton("Connect");
		buttonConnect.addActionListener(this);
		buttonConnect.setBackground(SystemColor.activeCaption);
		springLayout.putConstraint(SpringLayout.NORTH, textPassword, -42, SpringLayout.NORTH, buttonConnect);
		springLayout.putConstraint(SpringLayout.SOUTH, textPassword, -22, SpringLayout.NORTH, buttonConnect);
		springLayout.putConstraint(SpringLayout.NORTH, buttonConnect, -46, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, buttonConnect, 66, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, buttonConnect, -23, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, buttonConnect, -67, SpringLayout.EAST, getContentPane());
		buttonConnect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(buttonConnect);
		
		labelTitle = new JLabel("Check Your List");
		springLayout.putConstraint(SpringLayout.NORTH, labelTitle, 22, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, labelTitle, 68, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, labelTitle, -68, SpringLayout.EAST, getContentPane());
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(labelTitle);
		
		labelLogin = new JLabel("Username");
		springLayout.putConstraint(SpringLayout.WEST, labelLogin, 73, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, labelLogin, -6, SpringLayout.NORTH, textLogin);
		springLayout.putConstraint(SpringLayout.EAST, labelLogin, -7, SpringLayout.EAST, buttonConnect);
		labelLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelLogin);
		
		labelPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.WEST, labelPassword, 79, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, labelPassword, -6, SpringLayout.NORTH, textPassword);
		springLayout.putConstraint(SpringLayout.EAST, labelPassword, -6, SpringLayout.EAST, labelLogin);
		labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelPassword);
		
		setSize(294,270);
		setMinimumSize(new Dimension(294, 270));
		setTitle("Login");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (!this.checkLoginIsEmpty()) {
			if (!this.checkPasswordIsEmpty()) {
				if (this.login.connect(textLogin.getText(),new String(textPassword.getPassword())) ) {
					User u = (User) this.login.getPerson(textLogin.getText());
					JOptionPane.showMessageDialog(this,
						    "Welcome, " + u.getFirstName()+" "+u.getLastName()+" !");
				}
				else {
					JOptionPane.showMessageDialog(this,
							"Your pseudo or password is incorrect",
						    "Error",
						    JOptionPane.ERROR_MESSAGE);
				}
			}
		}
	}
	
	public boolean checkLoginIsEmpty() {
		if (this.textLogin.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your pseudo is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}
	
	public boolean checkPasswordIsEmpty() {
		if ((new String(textPassword.getPassword())).isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your password is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return true;
		}
		return false;
	}

}
