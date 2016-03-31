/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package model.person;

// Start of user code (user defined imports)

// End of user code

/**
 *business class of administrator 
 *
 */
public abstract class Administrator extends Person {
	// Start of user code (user defined attributes for Administrator)
	
	// End of user code
	
	/**
	 * The constructor of administrator
	 */
	public Administrator() {
		// Start of user code constructor for Administrator)
		super();
		// End of user code
	}
	
	/**
	 * The constructor of administrator
	 * @param pseudo
	 */
	public Administrator(String pseudo) {
		super(pseudo);
	}
	
	/**
	 * The constructor of administrator
	 * @param pseudo
	 * @param lastName
	 * @param firstName
	 * @param description
	 * @param password
	 */
	public Administrator(String pseudo, String lastName, String firstName, String description, String password) {
		super(pseudo, lastName, firstName, description, password);	}
	
	// Start of user code (user defined methods for Administrator)
	
	// End of user code
}
