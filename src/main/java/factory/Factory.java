package factory;

import person.model.Administrator;
import person.model.Seller;
import person.model.User;

public abstract class Factory {
	
	public abstract Seller createSeller(String pseudo, String lastName, String firstName, String description, String password, String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city);
	
	public abstract Administrator createAdministrator(String pseudo, String lastName, String firstName, String description, String password);

	public abstract User createUser(String pseudo, String lastName, String firstName, String description, String password, String city, String postCode, String street, String houseNumber, String mail);
	
	public abstract User createUser(String pseudo);
	
	public abstract Seller createSeller(String pseudo);
	
	public abstract Administrator createAdministrator(String pseudo);
}
