package person.persistance;

import person.model.Administrator;
import person.model.Person;

public class AdministratorJDBC extends Administrator {
	
	public AdministratorJDBC(String pseudo, String lastName, String firstName, String description, String password) {
		super(pseudo, lastName, firstName, description,password);	
	}
	
	public AdministratorJDBC(String pseudo) {
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
