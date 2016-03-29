package model.person.JDBC;

import model.person.Administrator;
import model.person.Person;

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

	@Override
	public boolean pseudoExist() {
		// TODO Auto-generated method stub
		return false;
	}

}
