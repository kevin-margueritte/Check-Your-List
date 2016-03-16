package factory.person;

import model.person.Administrator;
import model.person.Seller;
import model.person.User;
import model.person.JDBC.AdministratorJDBC;
import model.person.JDBC.SellerJDBC;
import model.person.JDBC.UserJDBC;

public class PersonFactory extends AbstractPersonFactory {

	@Override
	public Seller createSeller(String pseudo, String lastName, String firstName, String description, String password,
			String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
		return new SellerJDBC(pseudo, lastName, firstName, description, password,
				siret, phoneNumber, houseNumber, street, postCode, mail,
				city);
	}

	@Override
	public Administrator createAdministrator(String pseudo, String lastName, String firstName, String description,
			String password) {
		// TODO Auto-generated method stub
		return new AdministratorJDBC(pseudo, lastName, firstName, description,
				password);
	}

	@Override
	public User createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		// TODO Auto-generated method stub
		return new UserJDBC(pseudo, lastName, firstName, description, password,
				city, postCode, street, houseNumber, mail);
	}
	
	public static byte[] encrypt(String x) throws Exception {
	    java.security.MessageDigest d = null;
	    d = java.security.MessageDigest.getInstance("SHA-1");
	    d.reset();
	    d.update(x.getBytes());
	    return d.digest();
	 }

	@Override
	public User createUser(String pseudo) {
		return new UserJDBC(pseudo);
	}

	@Override
	public Seller createSeller(String pseudo) {
		return new SellerJDBC(pseudo);
	}

	@Override
	public Administrator createAdministrator(String pseudo) {
		return new AdministratorJDBC(pseudo);
	}

}
