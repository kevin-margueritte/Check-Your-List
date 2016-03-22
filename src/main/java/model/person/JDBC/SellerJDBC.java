package model.person.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.person.Person;
import model.person.Seller;
import model.person.User;

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
	public Seller readByPseudo() {
		String sql = ("SELECT * FROM seller WHERE pseudo = '" +  this.pseudo + "'");
		Seller u = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("seller")) {
					this.siret = (String) rs.getObject("siret");
					this.phoneNumber = (String) rs.getObject("phoneNumber");
					this.lastName = (String) rs.getObject("lastName");
					this.firstName = (String) rs.getObject("firstName");
					this.description = (String) rs.getObject("description");
					this.password = (String) rs.getObject("pass");
					this.city = (String) rs.getObject("city");
					this.postCode = (String) rs.getObject("postCode");
					this.street = (String) rs.getObject("street");
					this.houseNumber = (String) rs.getObject("houseNumber");
					this.mail = (String) rs.getObject("email");
					u = new SellerJDBC(pseudo, lastName, firstName, description, password, siret, phoneNumber,houseNumber, street, postCode, mail, city);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Seller)u;
	}

	@Override
	public boolean save() {
		if (this.pseudoExist() == false) {
			String sql = ("INSERT INTO seller VALUES ( '" +  this.firstName + "','" + this.lastName + "','" + 
					this.pseudo + "','" + this.password + "','" + this.description + "','" + this.siret + "','" + this.phoneNumber + "','" +
					this.houseNumber + "','" + this.street + "','" + this.postCode + "','" + this.mail + "','" + this.city + "')");
			try {
				Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
				stm.execute(sql);
				return true;
			} catch (SQLException e) {
				return true;
			}
		}
		return false;
	}
	
	public boolean pseudoExist() {
		String sql1 = ("SELECT pseudo FROM customer WHERE pseudo='"+ this.pseudo + "'");
		String sql2 = ("SELECT pseudo FROM seller WHERE pseudo='"+ this.pseudo + "'");
		try {
			Statement stm1 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			Statement stm2 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs1 = stm1.executeQuery(sql1);
			ResultSet rs2 = stm2.executeQuery(sql2);
			return (rs1.next() || rs2.next()); 
		} catch (SQLException e) {}
		return true;
	}
}
