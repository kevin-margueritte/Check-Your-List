package facade;

import manager.PersonManager;

public class PersonFacade {
	
	private PersonManager pm;
	
	public PersonFacade() {
		this.pm = new PersonManager();
	}
	
	
	public boolean createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		return this.pm.createUser(pseudo, lastName, firstName, description, password, city, postCode, street, houseNumber, mail);
	}

}
