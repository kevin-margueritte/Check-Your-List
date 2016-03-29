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
 * Description of User.
 * 
 * @author kevine2710
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
	 * The constructor.
	 */
	public User() {
		// Start of user code constructor for User)
		super();
		// End of user code
	}
	
	public User(String pseudo, String lastName, String firstName, String description, String password, String city, String postCode, String street, String houseNumber, String mail) {
		super(pseudo, lastName, firstName, description, password);
		this.city = city;
		this.postCode = postCode;
		this.street = street;
		this.houseNumber = houseNumber;
		this.mail = mail;
	}
	
	public User(String pseudo) {
		super(pseudo);
	}

	// Start of user code (user defined methods for User)
	
	// End of user code
	public String getPseudo() {
		return this.pseudo;
	}
	/**
	 * Returns city.
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
	 * Returns postCode.
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
	 * Returns street.
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
	 * Returns houseNumber.
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
	 * Returns mail.
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

	public abstract boolean save();
	public abstract List<Activity> readAllActivities();
	public abstract List<Comment> readAllComments();
	public abstract boolean pseudoExist();

}
