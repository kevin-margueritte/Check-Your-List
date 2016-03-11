package person.persistance.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.person.User;

public class UserJDBC extends User {
	
	public UserJDBC(String pseudo, String lastName, String firstName, String description, String password, String city, String postCode, String street, String houseNumber, String mail){
		super(pseudo, lastName, firstName, description, password, city, postCode, street, houseNumber, mail);	
	}
	
	public UserJDBC(String pseudo) {
		super(pseudo);
	}

	@Override
	public User readByPseudo() {
		String sql = ("SELECT * FROM customer WHERE pseudo = '" +  this.pseudo + "'");
		User u = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("customer")) {
					this.lastName = (String) rs.getObject("lastName");
					this.firstName = (String) rs.getObject("firstName");
					this.description = (String) rs.getObject("description");
					this.password = (String) rs.getObject("pass");
					this.city = (String) rs.getObject("city");
					this.postCode = (String) rs.getObject("postCode");
					this.street = (String) rs.getObject("street");
					this.houseNumber = (String) rs.getObject("houseNumber");
					this.mail = (String) rs.getObject("mail");
					u = new UserJDBC(pseudo, lastName, firstName, description, password, city, postCode, street, houseNumber, mail);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (User)u;
	}

	@Override
	public boolean save() {
		String sql = ("INSERT INTO customer VALUES ( '" +  this.firstName + "','" + this.lastName + "','" + 
				this.pseudo + "','" + this.password + "','" + this.description + "','" + this.city + "','" + this.postCode + "','" +
				this.street + "','" + this.houseNumber + "','" + this.mail +"')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {}
		return false;
	}

}
