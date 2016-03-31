package facade;

import manager.PersonManager;
/**
 * to be the intermediary between PersonManager and UI person class
 *
 */
public class PersonFacade {
	/**
	 * Description of the property personUIs.
	 */
	private PersonManager pm;
	
	/**
	 * constructor of PersonFacade
	 */
	public PersonFacade() {
		this.pm = new PersonManager();
	}
	
	/**
	 * create a new user
	 * @param pseudo of the user
	 * @param lastName of the user
	 * @param firstName of the user
	 * @param description of the user
	 * @param password of the user
	 * @param city of the user
	 * @param postCode of the user
	 * @param street of the user
	 * @param houseNumber of the user
	 * @param mail of the user
	 * @return true if the user is created else false
	 */
	public boolean createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		return this.pm.createUser(pseudo, lastName, firstName, description, password, city, postCode, street, houseNumber, mail);
	}
	
	/**
	 * create a new seller
	 * @param pseudo of the seller
	 * @param lastName of the seller
	 * @param firstName of the seller
	 * @param description of the seller
	 * @param password of the seller
	 * @param siret of the seller
	 * @param phoneNumber of the seller
	 * @param houseNumber of the seller
	 * @param street of the seller
	 * @param postCode of the seller
	 * @param mail of the seller
	 * @param city of the seller
	 * @return true if the seller is created else false
	 */
	public boolean createSeller(String pseudo, String lastName, String firstName, String description, String password,
			String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
		return this.pm.createSeller(pseudo, lastName, firstName, description, password,
				siret, phoneNumber, houseNumber, street, postCode, mail,
				city);
	}

}
