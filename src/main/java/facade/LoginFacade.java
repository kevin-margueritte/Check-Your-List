/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package facade;

import manager.PersonManager;
import model.person.Person;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Connection.
 * 
 * @author kevine2710
 */
public class LoginFacade {

	/**
	 * Description of the property loginUIs.
	 */
	private PersonManager mu;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor.
	 */
	public LoginFacade() {
		this.mu = new PersonManager();
	}

	public boolean connect(String username, String password) {
		return this.mu.connect(username, password);
	}
	
	public Person getPerson(String username) {
		return this.mu.getPerson(username);
	}
	
	

}