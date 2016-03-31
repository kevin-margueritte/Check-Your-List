/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package facade;

import manager.PersonManager;
import model.person.Person;

// Start of user code (user defined imports)

// End of user code

/**
 * to be the intermediary between LoginManager and UI login class
 *
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
	
	/**
	 * connect a user 
	 * @param username of the user
	 * @param password of the user 
	 * @return true if the user is connected
	 */
	public boolean connect(String username, String password) {
		return this.mu.connect(username, password);
	}
	
	/**
	 * get a person
	 * @param username of the person
	 * @return person
	 */
	public Person getPerson(String username) {
		return this.mu.getPerson(username);
	}
	
	

}