package factory;

import person.model.Administrator;
import person.model.Seller;
import person.model.User;

public class PersonFactory extends AbstractFactory {

	@Override
	public Seller createSeller(String pseudo, String lastName, String firstName, String description, String password,
			String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
		return new Seller(pseudo, lastName, firstName, description, password,
				siret, phoneNumber, houseNumber, street, postCode, mail,
				city);
	}

	@Override
	public Administrator createAdministrator(String pseudo, String lastName, String firstName, String description,
			String password) {
		// TODO Auto-generated method stub
		return new Administrator(pseudo, lastName, firstName, description,
				password);
	}

	@Override
	public User createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		// TODO Auto-generated method stub
		return new User(pseudo, lastName, firstName, description, password,
				city, postCode, street, houseNumber, mail);
	}
	
	public static byte[] encrypt(String x) throws Exception {
	    java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(x.getBytes());
	    return d.digest();
	 }

}
