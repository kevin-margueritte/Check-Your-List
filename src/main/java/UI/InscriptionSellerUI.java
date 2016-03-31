package UI;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.JTextPane;

import facade.PersonFacade;

@SuppressWarnings("serial")
public class InscriptionSellerUI extends JFrame implements ActionListener {
	
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
	private JTextField phoneNumber;
	private JTextField siret;
	
	public InscriptionSellerUI() {
		this.pf = new PersonFacade();
		setResizable(false);
		getContentPane().setLayout(null);
		
		firstName = new JTextField();
		firstName.setBounds(10, 39, 132, 20);
		getContentPane().add(firstName);
		firstName.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First name");
		lblFirstName.setBounds(10, 19, 132, 14);
		getContentPane().add(lblFirstName);
		
		lastName = new JTextField();
		lastName.setBounds(10, 103, 132, 20);
		lastName.setColumns(10);
		getContentPane().add(lastName);
		
		JLabel lblLastName = new JLabel("Last name");
		lblLastName.setBounds(10, 83, 132, 14);
		getContentPane().add(lblLastName);
		
		pseudo = new JTextField();
		pseudo.setBounds(10, 166, 132, 20);
		getContentPane().add(pseudo);
		pseudo.setColumns(10);
		
		JLabel lblPseudo = new JLabel("Pseudo");
		lblPseudo.setBounds(10, 146, 132, 14);
		getContentPane().add(lblPseudo);
		
		password = new JPasswordField();
		password.setBounds(10, 222, 132, 20);
		getContentPane().add(password);
		password.setColumns(10);
		
		JLabel lblPassword = new JLabel("Password");
		lblPassword.setBounds(10, 202, 132, 14);
		getContentPane().add(lblPassword);
		
		repeatPassword = new JPasswordField();
		repeatPassword.setBounds(10, 281, 132, 20);
		getContentPane().add(repeatPassword);
		repeatPassword.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("Repeat password");
		lblNewLabel.setBounds(10, 261, 132, 14);
		getContentPane().add(lblNewLabel);
		
		email = new JTextField();
		email.setBounds(10, 342, 132, 20);
		email.setColumns(10);
		getContentPane().add(email);
		
		JLabel lblMail = new JLabel("Email");
		lblMail.setBounds(10, 322, 132, 14);
		getContentPane().add(lblMail);
		
		city = new JTextField();
		city.setBounds(254, 166, 141, 20);
		getContentPane().add(city);
		city.setColumns(10);
		
		JLabel lblCity = new JLabel("City");
		lblCity.setBounds(254, 146, 141, 14);
		getContentPane().add(lblCity);
		
		postCode = new JTextField();
		postCode.setBounds(257, 222, 138, 20);
		getContentPane().add(postCode);
		postCode.setColumns(10);
		
		JLabel lblPostcode = new JLabel("Postcode");
		lblPostcode.setBounds(258, 202, 137, 14);
		getContentPane().add(lblPostcode);
		
		street = new JTextField();
		street.setBounds(257, 281, 138, 20);
		getContentPane().add(street);
		street.setColumns(10);
		
		JLabel lblStreet = new JLabel("Street");
		lblStreet.setBounds(257, 261, 138, 14);
		getContentPane().add(lblStreet);
		
		houseNumber = new JTextField();
		houseNumber.setBounds(257, 342, 138, 20);
		getContentPane().add(houseNumber);
		houseNumber.setColumns(10);
		
		JLabel lblHouseNumber = new JLabel("House number");
		lblHouseNumber.setBounds(257, 322, 138, 14);
		getContentPane().add(lblHouseNumber);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 396, 375, 14);
		getContentPane().add(lblDescription);
		
		JButton btnValidate = new JButton("Sign up");
		btnValidate.setBounds(157, 554, 90, 23);
		btnValidate.addActionListener(this);
		getContentPane().add(btnValidate);
		
		this.description = new JTextPane();
		description.setBounds(10, 416, 375, 116);
		getContentPane().add(description);
		
		phoneNumber = new JTextField();
		phoneNumber.setBounds(254, 103, 141, 20);
		getContentPane().add(phoneNumber);
		phoneNumber.setColumns(10);
		
		siret = new JTextField();
		siret.setBounds(254, 39, 141, 20);
		getContentPane().add(siret);
		siret.setColumns(10);
		
		JLabel lblSiret = new JLabel("SIRET");
		lblSiret.setBounds(254, 19, 141, 14);
		getContentPane().add(lblSiret);
		
		JLabel lblPhoneNumber = new JLabel("Phone number");
		lblPhoneNumber.setBounds(254, 83, 141, 14);
		getContentPane().add(lblPhoneNumber);
		this.setSize(410, 616);
		this.setLocationRelativeTo(null);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (this.formComplete()) {
			boolean res = this.pf.createSeller(this.pseudo.getText(), this.lastName.getText(), this.firstName.getText(), this.description.getText(),
					new String(this.password.getPassword()), this.siret.getText(), this.phoneNumber.getText(), this.houseNumber.getText(), this.street.getText(), 
					this.postCode.getText(), this.email.getText(), this.city.getText());
			if (!res) {
				JOptionPane.showMessageDialog(this,
					"Your pseudo already exist",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			}
			else {
				JOptionPane.showMessageDialog(this,
						"Congratulations, you are now a seller of Check Your List ! Please Login");
				this.dispose();
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
		else if (this.siret.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Your house number is empty",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
