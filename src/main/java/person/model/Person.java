/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package person.model;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Person.
 * 
 * @author kevine2710
 */
public class Person {
	/**
	 * Description of the property photo.
	 */
	private String photo;

	/**
	 * Description of the property pseudo.
	 */
	private String pseudo;

	/**
	 * Description of the property lastName.
	 */
	private String lastName;

	/**
	 * Description of the property firstName.
	 */
	private String firstName;

	/**
	 * Description of the property description.
	 */
	private String description;

	/**
	 * Description of the property password.
	 */
	private String password;

	// Start of user code (user defined attributes for Person)

	// End of user code

	/**
	 * The constructor.
	 */
	public Person() {
		// Start of user code constructor for Person)
		super();
		// End of user code
	}
	
	

	public Person(String pseudo, String lastName, String firstName, String description, String password) {
		super();
		this.pseudo = pseudo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.description = description;
		this.password = password;
	}



	// Start of user code (user defined methods for Person)

	// End of user code
	/**
	 * Returns photo.
	 * @return photo 
	 */
	public String getPhoto() {
		return this.photo;
	}

	/**
	 * Sets a value to attribute photo. 
	 * @param newPhoto 
	 */
	public void setPhoto(String newPhoto) {
		this.photo = newPhoto;
	}

	/**
	 * Returns pseudo.
	 * @return pseudo 
	 */
	public String getPseudo() {
		return this.pseudo;
	}

	/**
	 * Sets a value to attribute pseudo. 
	 * @param newPseudo 
	 */
	public void setPseudo(String newPseudo) {
		this.pseudo = newPseudo;
	}

	/**
	 * Returns lastName.
	 * @return lastName 
	 */
	public String getLastName() {
		return this.lastName;
	}

	/**
	 * Sets a value to attribute lastName. 
	 * @param newLastName 
	 */
	public void setLastName(String newLastName) {
		this.lastName = newLastName;
	}

	/**
	 * Returns firstName.
	 * @return firstName 
	 */
	public String getFirstName() {
		return this.firstName;
	}

	/**
	 * Sets a value to attribute firstName. 
	 * @param newFirstName 
	 */
	public void setFirstName(String newFirstName) {
		this.firstName = newFirstName;
	}

	/**
	 * Returns description.
	 * @return description 
	 */
	public String getDescription() {
		return this.description;
	}

	/**
	 * Sets a value to attribute description. 
	 * @param newDescription 
	 */
	public void setDescription(String newDescription) {
		this.description = newDescription;
	}

	/**
	 * Returns password.
	 * @return password 
	 */
	public String getPassword() {
		return this.password;
	}

	/**
	 * Sets a value to attribute password. 
	 * @param newPassword 
	 */
	public void setPassword(String newPassword) {
		this.password = newPassword;
	}

}
