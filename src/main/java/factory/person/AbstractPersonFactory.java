package factory.person;

import model.person.Administrator;
import model.person.Seller;
import model.person.User;

/**
 * Use for create instance of person
 *
 */
public abstract class AbstractPersonFactory {
	
	/**
	 * create a seller
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
	 * @return seller
	 */
	public abstract Seller createSeller(String pseudo, String lastName, String firstName, String description, String password, String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city);
	
	/**
	 * create an administrator
	 * @param pseudo of the administrator
	 * @param lastName of the administrator
	 * @param firstName of the administrator
	 * @param description of the administrator
	 * @param password of the administrator
	 * @return administrator
	 */
	public abstract Administrator createAdministrator(String pseudo, String lastName, String firstName, String description, String password);

	/**
	 * create a user
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
	 * @return user
	 */
	public abstract User createUser(String pseudo, String lastName, String firstName, String description, String password, String city, String postCode, String street, String houseNumber, String mail);
	
	/**
	 * create user
	 * @param pseudo of the user
	 * @return user
	 */
	public abstract User createUser(String pseudo);
	
	/**
	 * create seller
	 * @param pseudo of the seller
	 * @return seller
	 */
	public abstract Seller createSeller(String pseudo);
	
	/**
	 * create administrator
	 * @param pseudo of the administrator
	 * @return administrator 
	 */
	public abstract Administrator createAdministrator(String pseudo);
}
