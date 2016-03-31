/*******************************************************************************
 * 2016, All rights reserved.
 *******************************************************************************/
package model.person;

import java.util.List;

import model.product.Product;

// Start of user code (user defined imports)

// End of user code

/**
 *business class of seller 
 *
 */
public abstract class Seller extends Person {

	/**
	 * siret of seller
	 */
	protected String siret;
	/**
	 * phoneNumber of seller
	 */
	protected String phoneNumber;
	/**
	 * houseNumber of seller
	 */
	protected String houseNumber;
	/**
	 * street of seller
	 */
	protected String street;
	/**
	 * postCode of seller
	 */
	protected String postCode;
	/**
	 * mail of seller
	 */
	protected String mail;
	/**
	 * city of seller
	 */
	protected String city;
	
	// Start of user code (user defined attributes for Seller)
	
	// End of user code
	
	/**
	 * The constructor of seller
	 */
	public Seller() {
		// Start of user code constructor for Seller)
		super();
		// End of user code
	}
	
	// Start of user code (user defined methods for Seller)
	/**
	 * The constructor of seller
	 * @param pseudo
	 * @param lastName
	 * @param firstName
	 * @param description
	 * @param password
	 * @param siret
	 * @param phoneNumber
	 * @param houseNumber
	 * @param street
	 * @param postCode
	 * @param mail
	 * @param city
	 */
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
	
	/**
	 * The constructor of seller
	 * @param pseudo
	 */
	public Seller(String pseudo) {
		super(pseudo);
	}

	// End of user code
	/**
	 * get siret of seller
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
	 * get phoneNumber of seller.
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
	 * get houseNumber of seller.
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
	 * get street of seller.
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
	 * get postCode of seller.
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
	 * get mail of seller.
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
	 * get city of seller.
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
	 * find if the seller exist
	 * @return true if the seller exist else false
	 */
	public abstract boolean sellerExist();
	
	/**
	 * get all products of seller
	 * @return list of products
	 */
	public abstract List<Product> readAllProducts();
	
	/**
	 * find if the pseudo exist
	 * @return true if the pseudo exist
	 */
	public abstract boolean pseudoExist();
}
