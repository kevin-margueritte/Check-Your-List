/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package model.person;

// Start of user code (user defined imports)

// End of user code

/**
 *business class of person 
 *
 */
public abstract class Person {
	/**
	 * Description of the property photo.
	 */
	protected String photo;

	/**
	 * Description of the property pseudo.
	 */
	protected String pseudo;

	/**
	 * Description of the property lastName.
	 */
	protected String lastName;

	/**
	 * Description of the property firstName.
	 */
	protected String firstName;

	/**
	 * Description of the property description.
	 */
	protected String description;

	/**
	 * Description of the property password.
	 */
	protected String password = "";

	// Start of user code (user defined attributes for Person)

	// End of user code

	/**
	 * The constructor of person
	 */
	public Person() {
		// Start of user code constructor for Person)
		super();
		// End of user code
	}
	
	
	/**
	 * The constructor of person
	 * @param pseudo
	 * @param lastName
	 * @param firstName
	 * @param description
	 * @param password
	 */
	public Person(String pseudo, String lastName, String firstName, String description, String password) {
		super();
		this.pseudo = pseudo;
		this.lastName = lastName;
		this.firstName = firstName;
		this.description = description;
		this.password = password;
	}

	/**
	 * The constructor of person
	 * @param pseudo
	 */
	public Person(String pseudo) {
		this.pseudo = pseudo;
	}


	// Start of user code (user defined methods for Person)

	// End of user code
	/**
	 * get photo of person
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
	 * get pseudo of person
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
	 * get last name of person
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
	 * get firstName of person
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
	 * get description of person
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
	 * get password of person
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
	
	/**
	 * get person with its pseudo
	 * @return person
	 */
	public abstract Person readByPseudo();
	
	/**
	 * save a person
	 * @return true if the person is saved
	 */
	public abstract boolean save();
	
	/**
	 * find if the pseudo exist
	 * @return true if the pseudo exist else false
	 */
	public abstract boolean pseudoExist();
}
