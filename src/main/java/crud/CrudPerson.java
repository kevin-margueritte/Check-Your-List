package crud;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import person.model.Person;
import person.model.User;

public class CrudPerson implements Crud<Person, String> {
	
	private Connection connection = new ConnectionDB().getConnectionDB();

	@Override
	public <S extends Person> S save(S entity) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Iterable<Person> read(String primaryKey) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void delete(Person entity) {
		// TODO Auto-generated method stub
		
	}
	
	public Person readByPseudo(String pseudo) {
		String sql = ("SELECT * FROM customer WHERE pseudo = '" + pseudo + "'");
		User u = new User();
		try {
			Statement stm = this.connection.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			ResultSetMetaData resultMeta = rs.getMetaData();
			System.out.println(rs.getRow());
			if ( resultMeta.getColumnCount() >= 1 ) {
				rs.next();
				if (resultMeta.getTableName(1).equals("customer")) {
					String lastName = (String) rs.getObject("lastName");
					String firstName = (String) rs.getObject("firstName");
					String description = (String) rs.getObject("description");
					String password = (String) rs.getObject("pass");
					String city = (String) rs.getObject("city");
					String postCode = (String) rs.getObject("postCode");
					String street = (String) rs.getObject("street");
					String houseNumber = (String) rs.getObject("houseNumber");
					String mail = (String) rs.getObject("mail");
					u = new User(pseudo, lastName, firstName, description, password, city, postCode, street, houseNumber, mail);
				}
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return u;
	}

}
