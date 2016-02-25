/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package connectionUI;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import person.facade.Login;
import person.model.User;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of LoginUI.
 * 
 * @author kevine2710
 */
@SuppressWarnings("serial")
public class LoginUI extends JFrame implements Observer, ActionListener  {
	/**
	 * Description of the property Logins.
	 */
	private Login login;

	//private JPanel contentPane;
	private JTextField textLogin;
	private JPasswordField textPassword;
	
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
	 * Create the frame.
	 */
	public LoginUI() {
		this.login = new Login();
		this.login.addObserver(this);
		Container contentPane = this.getContentPane();
		
		contentPane.setLayout(new BorderLayout());
		
		JLabel labelLogin = new JLabel("Login :      ");
		labelLogin.setHorizontalAlignment(SwingConstants.CENTER);
		JLabel labelPassword = new JLabel("Password : ");
		labelPassword.setHorizontalAlignment(SwingConstants.CENTER);

		this.textLogin = new JTextField();
	    textLogin.setPreferredSize(new Dimension(150,24));

		this.textPassword = new JPasswordField();
		textPassword.setPreferredSize(new Dimension(150,24));
		JButton buttonConnect = new JButton("Connect");
		
		JPanel formLogin = new JPanel();
		JPanel formPassword = new JPanel();
		formLogin.add(labelLogin);
		formLogin.add(textLogin);	
		contentPane.add(formLogin, BorderLayout.NORTH);
		formPassword.add(labelPassword);
		formPassword.add(textPassword);	
		contentPane.add(formPassword, BorderLayout.CENTER);
		
		JPanel buttonValidate = new JPanel();
		buttonValidate.add(buttonConnect);
		buttonConnect.addActionListener(this);
		
		contentPane.add(buttonValidate, BorderLayout.SOUTH);			
		
		setTitle("Login");
		setSize(300,200);
		setVisible(true);
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);	
		
	}
	
	public void actionPerformed(ActionEvent e) {
		this.login.setUsername(textLogin.getText());
		this.login.setPassword(new String(textPassword.getPassword()));
		this.login.connect();
	}

	@Override
	public void update(Observable arg0, Object arg1) {
		// TODO Auto-generated method stub
		if ( arg1 instanceof String) {
			JOptionPane.showMessageDialog(this,
					(String)arg1,
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
		}
		else if (arg1 instanceof User) {
			User u = (User) arg1;
			JOptionPane.showMessageDialog(this,
				    "Welcome, " + u.getFirstName()+" "+u.getLastName()+" !");
		}
	}
}
