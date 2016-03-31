package UI;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import database.ConnectionDB;
import facade.LoginFacade;
import model.person.Person;
import model.person.Seller;
import model.person.User;

// TODO: Auto-generated Javadoc
/**
 * The Class LoginUI.
 */
@SuppressWarnings("serial")
public class LoginUI extends JFrame implements ActionListener{
	
	/** The login. */
	private LoginFacade login;
	
	/** The text login. */
	private JTextField textLogin;
	
	/** The text password. */
	private JPasswordField textPassword;
	
	/** The label title. */
	private JLabel labelTitle;
	
	/** The label login. */
	private JLabel labelLogin;
	
	/** The label password. */
	private JLabel labelPassword;
	
	/** The btn sign in seller. */
	private JButton btnSignInSeller;
	
	/** The btn sign in user. */
	private JButton btnSignInUser;
	
	/** The btn connect. */
	private JButton btnConnect;
	
	/**
	 * The main method.
	 *
	 * @param args the arguments
	 */
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
	
	/**
	 * Instantiates a new login ui.
	 */
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
		
		setSize(227,343);
		setMinimumSize(new Dimension(294, 270));
		setTitle("Login");
		this.setLocationRelativeTo(null);
		try {
			ConnectionDB.creetConnectionDB().getConn().createStatement();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == this.btnConnect) {
			if (!this.checkLoginIsEmpty()) {
				if (!this.checkPasswordIsEmpty()) {
					if (this.login.connect(textLogin.getText(),new String(textPassword.getPassword())) ) {
						Person p = (Person) this.login.getPerson(textLogin.getText());
						System.out.println("co");
						if (p instanceof User) {
							MenuUserUI frame = new MenuUserUI((User) p);
							frame.setVisible(true);
							this.dispose();
						}
						else if (p instanceof Seller) {
							MenuSellerUI frame = new MenuSellerUI((Seller) p);
							frame.setVisible(true);
							this.dispose();
						}
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
			//this.dispose();
		}
		else if (e.getSource() == this.btnSignInUser) {
			InscriptionUserUI frame = new InscriptionUserUI();
			frame.setVisible(true);
			//this.dispose();
		}
	}
	
	/**
	 * Check login is empty.
	 *
	 * @return true, if successful
	 */
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
	
	/**
	 * Check password is empty.
	 *
	 * @return true, if successful
	 */
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
