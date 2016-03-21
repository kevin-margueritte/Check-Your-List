package model.person.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
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
