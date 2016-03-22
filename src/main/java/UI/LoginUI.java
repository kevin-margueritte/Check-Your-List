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
	private JButton btnSignInSeller;
	private JButton btnSignInUser;
	private JButton btnConnect;
	
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
		setResizable(false);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.login = new LoginFacade();
		getContentPane().setLayout(null);
		
		textPassword = new JPasswordField();
		textPassword.setBounds(73, 152, 127, 20);
		textPassword.setColumns(10);
		getContentPane().add(textPassword);
		
		this.btnConnect = new JButton("Connect");
		this.btnConnect.setBounds(73, 183, 127, 23);
		this.btnConnect.addActionListener(this);
		this.btnConnect.setBackground(SystemColor.activeCaption);
		this.btnConnect.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		getContentPane().add(this.btnConnect);
		
		labelTitle = new JLabel("Check Your List");
		labelTitle.setBounds(73, 11, 127, 26);
		labelTitle.setHorizontalAlignment(SwingConstants.CENTER);
		labelTitle.setFont(new Font("Palatino Linotype", Font.PLAIN, 18));
		getContentPane().add(labelTitle);
		
		labelLogin = new JLabel("Username");
		labelLogin.setBounds(114, 66, 48, 14);
		labelLogin.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelLogin);
		
		textLogin = new JTextField();
		textLogin.setBounds(73, 86, 127, 20);
		getContentPane().add(textLogin);
		textLogin.setColumns(10);
		
		labelPassword = new JLabel("Password");
		labelPassword.setBounds(115, 129, 47, 14);
		labelPassword.setFont(new Font("Times New Roman", Font.PLAIN, 12));
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);
		getContentPane().add(labelPassword);
		
		btnSignInSeller = new JButton("Sign in (seller)");
		btnSignInSeller.setBounds(73, 251, 127, 23);
		btnSignInSeller.addActionListener(this);
		getContentPane().add(btnSignInSeller);
		
		btnSignInUser = new JButton("Sign in (user)");
		btnSignInUser.addActionListener(this);
		btnSignInUser.setBounds(73, 217, 127, 23);
		getContentPane().add(btnSignInUser);
		
		setSize(285,343);
		setMinimumSize(new Dimension(294, 270));
		setTitle("Login");
	}
	
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnConnect) {
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
		else if (e.getSource() == this.btnSignInSeller) {
			InscriptionSellerUI frame = new InscriptionSellerUI();
			frame.setVisible(true);
			this.dispose();
		}
		else if (e.getSource() == this.btnSignInUser) {
			InscriptionUserUI frame = new InscriptionUserUI();
			frame.setVisible(true);
			this.dispose();
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
