/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package person.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Administrator.
 * 
 * @author kevine2710
 */
public abstract class Administrator extends Person {
	// Start of user code (user defined attributes for Administrator)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Administrator() {
		// Start of user code constructor for Administrator)
		super();
		// End of user code
	}
	
	public Administrator(String pseudo) {
		super(pseudo);
	}
	
	public Administrator(String pseudo, String lastName, String firstName, String description, String password) {
		super(pseudo, lastName, firstName, description, password);	}
	
	// Start of user code (user defined methods for Administrator)
	
	// End of user code
}
