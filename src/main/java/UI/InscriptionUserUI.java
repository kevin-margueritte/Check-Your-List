package UI;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.SpringLayout;

import facade.PersonFacade;

@SuppressWarnings("serial")
public class InscriptionUserUI extends JFrame implements ActionListener {
	
	private JTextField firstName;
	private JTextField lastName;
	private JTextField pseudo;
	private JPasswordField password;
	private JPasswordField repeatPassword;
	private JTextField email;
	private JTextField city;
	private JTextField postCode;
	private JTextField street;
	private JTextField houseNumber;
	private JTextPane description;
	private PersonFacade pf;
	
	public static void main(String args[]) {
		InscriptionUserUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InscriptionUserUI frame = new InscriptionUserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public InscriptionUserUI() {
		this.pf = new PersonFacade();
		setResizable(false);
		SpringLayout springLayout = new SpringLayout();
		getContentPane().setLayout(springLayout);
		
		firstName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, firstName, 39, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, firstName, 10, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.EAST, firstName, 142, SpringLayout.WEST, getContentPane());
		getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		springLayout.putConstraint(SpringLayout.WEST, lblFirstName, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblFirstName, -6, SpringLayout.NORTH, firstName);
		getContentPane().add(lblFirstName);
		
		lastName = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, lastName, 103, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lastName, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.EAST, lastName, 0, SpringLayout.EAST, firstName);
		lastName.setColumns(10);
		getContentPane().add(lastName);
		
		JLabel lblLastName = new JLabel("Last name");
		springLayout.putConstraint(SpringLayout.WEST, lblLastName, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblLastName, -6, SpringLayout.NORTH, lastName);
		getContentPane().add(lblLastName);
		
		pseudo = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, pseudo, 43, SpringLayout.SOUTH, lastName);
		springLayout.putConstraint(SpringLayout.WEST, pseudo, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, pseudo, 63, SpringLayout.SOUTH, lastName);
		springLayout.putConstraint(SpringLayout.EAST, pseudo, 0, SpringLayout.EAST, firstName);
		getContentPane().add(pseudo);
		pseudo.setColumns(10);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		springLayout.putConstraint(SpringLayout.WEST, lblPseudo, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPseudo, -6, SpringLayout.NORTH, pseudo);
		getContentPane().add(lblPseudo);
		
		password = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, password, 36, SpringLayout.SOUTH, pseudo);
		springLayout.putConstraint(SpringLayout.WEST, password, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, password, 56, SpringLayout.SOUTH, pseudo);
		springLayout.putConstraint(SpringLayout.EAST, password, 0, SpringLayout.EAST, firstName);
		getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		springLayout.putConstraint(SpringLayout.WEST, lblPassword, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblPassword, -6, SpringLayout.NORTH, password);
		getContentPane().add(lblPassword);
		
		repeatPassword = new JPasswordField();
		springLayout.putConstraint(SpringLayout.NORTH, repeatPassword, 39, SpringLayout.SOUTH, password);
		springLayout.putConstraint(SpringLayout.WEST, repeatPassword, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, repeatPassword, 59, SpringLayout.SOUTH, password);
		springLayout.putConstraint(SpringLayout.EAST, repeatPassword, 0, SpringLayout.EAST, firstName);
		getContentPane().add(repeatPassword);
		repeatPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Repeat password");
		springLayout.putConstraint(SpringLayout.WEST, lblNewLabel, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblNewLabel, -6, SpringLayout.NORTH, repeatPassword);
		getContentPane().add(lblNewLabel);
		
		email = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, email, 41, SpringLayout.SOUTH, repeatPassword);
		springLayout.putConstraint(SpringLayout.WEST, email, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, email, 61, SpringLayout.SOUTH, repeatPassword);
		springLayout.putConstraint(SpringLayout.EAST, email, 0, SpringLayout.EAST, firstName);
		email.setColumns(10);
		getContentPane().add(email);
		
		JLabel lblMail = new JLabel("Email");
		springLayout.putConstraint(SpringLayout.WEST, lblMail, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblMail, -6, SpringLayout.NORTH, email);
		getContentPane().add(lblMail);
		
		city = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, city, 39, SpringLayout.NORTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, city, 115, SpringLayout.EAST, firstName);
		getContentPane().add(city);
		city.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		springLayout.putConstraint(SpringLayout.WEST, lblCity, 197, SpringLayout.EAST, lblFirstName);
		springLayout.putConstraint(SpringLayout.SOUTH, lblCity, 0, SpringLayout.SOUTH, lblFirstName);
		getContentPane().add(lblCity);
		
		postCode = new JTextField();
		springLayout.putConstraint(SpringLayout.EAST, city, 0, SpringLayout.EAST, postCode);
		springLayout.putConstraint(SpringLayout.WEST, postCode, 115, SpringLayout.EAST, lastName);
		springLayout.putConstraint(SpringLayout.EAST, postCode, -9, SpringLayout.EAST, getContentPane());
		getContentPane().add(postCode);
		postCode.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode");
		springLayout.putConstraint(SpringLayout.WEST, lblPostcode, 198, SpringLayout.EAST, lblLastName);
		springLayout.putConstraint(SpringLayout.NORTH, postCode, 6, SpringLayout.SOUTH, lblPostcode);
		springLayout.putConstraint(SpringLayout.NORTH, lblPostcode, 0, SpringLayout.NORTH, lblLastName);
		getContentPane().add(lblPostcode);
		
		street = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, street, 43, SpringLayout.SOUTH, postCode);
		springLayout.putConstraint(SpringLayout.WEST, street, 115, SpringLayout.EAST, pseudo);
		springLayout.putConstraint(SpringLayout.EAST, street, -9, SpringLayout.EAST, getContentPane());
		getContentPane().add(street);
		street.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		springLayout.putConstraint(SpringLayout.WEST, lblStreet, 212, SpringLayout.EAST, lblPseudo);
		springLayout.putConstraint(SpringLayout.SOUTH, lblStreet, 0, SpringLayout.SOUTH, lblPseudo);
		getContentPane().add(lblStreet);
		
		houseNumber = new JTextField();
		springLayout.putConstraint(SpringLayout.NORTH, houseNumber, 36, SpringLayout.SOUTH, street);
		springLayout.putConstraint(SpringLayout.WEST, houseNumber, 115, SpringLayout.EAST, password);
		springLayout.putConstraint(SpringLayout.EAST, houseNumber, -9, SpringLayout.EAST, getContentPane());
		getContentPane().add(houseNumber);
		houseNumber.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House number");
		springLayout.putConstraint(SpringLayout.NORTH, lblHouseNumber, 0, SpringLayout.NORTH, lblPassword);
		springLayout.putConstraint(SpringLayout.WEST, lblHouseNumber, 201, SpringLayout.EAST, lblPassword);
		getContentPane().add(lblHouseNumber);
		
		JLabel lblDescription = new JLabel("Description");
		springLayout.putConstraint(SpringLayout.SOUTH, lblDescription, -177, SpringLayout.SOUTH, getContentPane());
		springLayout.putConstraint(SpringLayout.WEST, lblDescription, 0, SpringLayout.WEST, firstName);
		getContentPane().add(lblDescription);
		
		JButton btnValidate = new JButton("Sign up");
		btnValidate.addActionListener(this);
		springLayout.putConstraint(SpringLayout.WEST, btnValidate, 157, SpringLayout.WEST, getContentPane());
		springLayout.putConstraint(SpringLayout.SOUTH, btnValidate, -10, SpringLayout.SOUTH, getContentPane());
		getContentPane().add(btnValidate);
		
		this.description = new JTextPane();
		springLayout.putConstraint(SpringLayout.NORTH, description, 6, SpringLayout.SOUTH, lblDescription);
		springLayout.putConstraint(SpringLayout.WEST, description, 0, SpringLayout.WEST, firstName);
		springLayout.putConstraint(SpringLayout.SOUTH, description, -22, SpringLayout.NORTH, btnValidate);
		springLayout.putConstraint(SpringLayout.EAST, description, 109, SpringLayout.EAST, lblCity);
		getContentPane().add(description);
		this.setSize(410, 616);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.formComplete()) {
			boolean res = this.pf.createUser(this.pseudo.getText(), this.lastName.getText(), this.firstName.getText(), this.description.getText(),
					new String(this.password.getPassword()), this.city.getText(), this.postCode.getText(), this.street.getText(), 
					this.houseNumber.getText(), this.email.getText());
			if (!res) {
				JOptionPane.showMessageDialog(this,
						"Your pseudo already exist",
					    "Error",
					    JOptionPane.ERROR_MESSAGE);
			}
		}
	}

	private boolean formComplete() {
		if (this.firstName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your first name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.lastName.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your last name is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.pseudo.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your pseudo is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if ((new String(this.password.getPassword())).isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your password is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (!(new String(this.password.getPassword())).equals(new String(this.repeatPassword.getPassword()))) {
			JOptionPane.showMessageDialog(this,
					"Your password is not equal",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.email.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your email is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.city.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your city is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.postCode.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your post code is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.street.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your street is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.houseNumber.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your street number is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.street.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your street is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		else if (this.houseNumber.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your house number is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
