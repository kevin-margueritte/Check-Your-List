/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package person.facade;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Observable;

import crud.CrudPerson;
import person.model.User;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Connection.
 * 
 * @author kevine2710
 */
public class Login extends Observable {

	private String username;
	private String password;

	/**
	 * Description of the property loginUIs.
	 */
	private CrudPerson crud;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor.
	 */
	public Login() {
		this.crud = new CrudPerson();
	}

	/**
	 * Description of the method connect.
	 * 
	 * @param username
	 * @param password
	 * @return
	 */
	public void connect() {
		// Start of user code for method connect
		this.setChanged();
		if (this.username.isEmpty()) {
			this.notifyObservers("Your pseudo is empty");
		}
		else if(this.password.isEmpty()) {
			this.notifyObservers("Your password is empty");
		}
		else {
			User u = (User) this.crud.readByPseudo(this.username);
			try {
				if ((sha1(this.password)).equals(u.getPassword())) {
					this.notifyObservers(u);
				}
				else {
					super.notifyObservers("Your password or your username is incorrect");
				}
			} catch (NoSuchAlgorithmException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	private static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

}