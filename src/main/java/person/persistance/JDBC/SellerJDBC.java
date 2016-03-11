package person.persistance.JDBC;

import model.person.Person;
import model.person.Seller;

public class SellerJDBC extends Seller {
	
	public SellerJDBC(String pseudo, String lastName, String firstName, String description, String password, String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
		super(pseudo, lastName, firstName, description, password,
				siret, phoneNumber, houseNumber, street, postCode, mail,
				city);
	}
	
	public SellerJDBC(String pseudo) {
		super(pseudo);
	}

	@Override
	public Person readByPseudo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

}
