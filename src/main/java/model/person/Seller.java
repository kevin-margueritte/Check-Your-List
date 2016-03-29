/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package model.person;

import java.util.List;

import model.product.Product;

// Start of user code (user defined imports)

// End of user code

/**
 * Description of Seller.
 * 
 * @author kevine2710
 */
public abstract class Seller extends Person {

	protected String siret;
	protected String phoneNumber;
	protected String houseNumber;
	protected String street;
	protected String postCode;
	protected String mail;
	protected String city;
	
	// Start of user code (user defined attributes for Seller)
	
	// End of user code
	
	/**
	 * The constructor.
	 */
	public Seller() {
		// Start of user code constructor for Seller)
		super();
		// End of user code
	}
	
	// Start of user code (user defined methods for Seller)
	
	public Seller(String pseudo, String lastName, String firstName, String description, String password, String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
		super(pseudo, lastName, firstName, description, password);
		this.siret = siret;
		this.phoneNumber = phoneNumber;
		this.houseNumber = houseNumber;
		this.street = street;
		this.postCode = postCode;
		this.mail = mail;
		this.city = city;
	}
	
	public Seller(String pseudo) {
		super(pseudo);
	}

	// End of user code
	/**
	 * Returns siret.
	 * @return siret 
	 */
	public String getSiret() {
		return this.siret;
	}
	
	/**
	 * Sets a value to attribute siret. 
	 * @param newSiret 
	 */
	public void setSiret(String newSiret) {
	    this.siret = newSiret;
	}

	/**
	 * Returns phoneNumber.
	 * @return phoneNumber 
	 */
	public String getPhoneNumber() {
		return this.phoneNumber;
	}
	
	/**
	 * Sets a value to attribute phoneNumber. 
	 * @param newPhoneNumber 
	 */
	public void setPhoneNumber(String newPhoneNumber) {
	    this.phoneNumber = newPhoneNumber;
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

	public abstract boolean sellerExist();
	public abstract List<Product> readAllProducts();
	public abstract boolean pseudoExist();
}
