/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package model.person;

import java.util.List;

import model.activity.Activity;
import model.comment.Comment;

// Start of user code (user defined imports)

// End of user code

/**
 *business class of activity 
 *
 */
public abstract class User extends Person {
	/**
	 * Description of the property city.
	 */
	protected String city;
	
	/**
	 * Description of the property postCode.
	 */
	protected String postCode;
	
	/**
	 * Description of the property street.
	 */
	protected String street;
	
	/**
	 * Description of the property houseNumber.
	 */
	protected String houseNumber;
	
	/**
	 * Description of the property mail.
	 */
	protected String mail;
	
	// Start of user code (user defined attributes for User)
	
	// End of user code
	
	/**
	 * The constructor of user
	 */
	public User() {
		// Start of user code constructor for User)
		super();
		// End of user code
	}
	
	/**
	 * The constructor of user
	 * @param pseudo
	 * @param lastName
	 * @param firstName
	 * @param description
	 * @param password
	 * @param city
	 * @param postCode
	 * @param street
	 * @param houseNumber
	 * @param mail
	 */
	public User(String pseudo, String lastName, String firstName, String description, String password, String city, String postCode, String street, String houseNumber, String mail) {
		super(pseudo, lastName, firstName, description, password);
		this.city = city;
		this.postCode = postCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.mail = mail;
	}
	
	/**
	 * The constructor of user
	 * @param pseudo
	 */
	public User(String pseudo) {
		super(pseudo);
	}

	// Start of user code (user defined methods for User)
	
	// End of user code
	/**
	 * get pseudo of user
	 * @return pseudo
	 */
	public String getPseudo() {
		return this.pseudo;
	}
	/**
	 * get city of user
	 * @return city 
	 */
	public String getCity() {
		return this.city;
	}
	
	/**
	 * Sets a value to attribute city. 
	 * @param newCity 
	 */
	public void setCity(String newCity) {
	    this.city = newCity;
	}

	/**
	 * get postCode of user.
	 * @return postCode 
	 */
	public String getPostCode() {
		return this.postCode;
	}
	
	/**
	 * Sets a value to attribute postCode. 
	 * @param newPostCode 
	 */
	public void setPostCode(String newPostCode) {
	    this.postCode = newPostCode;
	}

	/**
	 * get street of user.
	 * @return street 
	 */
	public String getStreet() {
		return this.street;
	}
	
	/**
	 * Sets a value to attribute street. 
	 * @param newStreet 
	 */
	public void setStreet(String newStreet) {
	    this.street = newStreet;
	}

	/**
	 * get houseNumber of user.
	 * @return houseNumber 
	 */
	public String getHouseNumber() {
		return this.houseNumber;
	}
	
	/**
	 * Sets a value to attribute houseNumber. 
	 * @param newHouseNumber 
	 */
	public void setHouseNumber(String newHouseNumber) {
	    this.houseNumber = newHouseNumber;
	}

	/**
	 * get mail of user.
	 * @return mail 
	 */
	public String getMail() {
		return this.mail;
	}
	
	/**
	 * Sets a value to attribute mail. 
	 * @param newMail 
	 */
	public void setMail(String newMail) {
	    this.mail = newMail;
	}
	

	public String getDescription() {
		return this.description;
	}
	
	public void setDescription(String description) {
	    this.description = description;
	}
	
	public String getPassword() {
		return this.password;
	}
	
	public void setPassword(String password) {
	    this.password = password;
	}

	public abstract boolean save();
	
	/**
	 * get all activities of an user
	 * @return list of activities
	 */
	public abstract List<Activity> readAllActivities();
	
	/**
	 * get all comment of the user
	 * @return list of comments
	 */
	public abstract List<Comment> readAllComments();
	
	/**
	 * find if the pseudo exist
	 * @return true if the pseudo exist else false 
	 */
	public abstract boolean pseudoExist();

}
