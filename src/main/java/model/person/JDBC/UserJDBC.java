package model.person.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.JDBC.SubcategoryJDBC;
import model.comment.Comment;
import model.person.User;
import model.product.Product;
import model.product.JDBC.ProductJDBC;

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
			stm.executeQuery(sql);
		} catch (SQLException e) {}
		return true;
	}
	
	@Override
	public List<Activity> readAllActivities() {
		String sql = ("select * from activity where pseudo_user='"+this.getPseudo()+"' ");
		List<Activity> listAct= new ArrayList<Activity>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			Activity act = null;
			while(rs.next()){
				act = new ActivityJDBC();
				act.setTitle((String) rs.getObject("titre"));
				act.setDescription((String) rs.getObject("description"));
				act.setVisible((Boolean) rs.getObject("visible"));
				act.setCreationDate((String) rs.getObject("creationdate").toString());
				SubcategoryJDBC subcat = new SubcategoryJDBC(rs.getObject("name_subcategory").toString());
				act.setSubcategory(subcat.readByName());
				act.setUser(this);
				listAct.add(act);
			}
			rs.close();
			return listAct;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	public boolean pseudoExist() {
		String sql1 = ("SELECT pseudo FROM customer WHERE pseudo='"+ this.pseudo + "'");
		try {
			Statement stm1 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs1 = stm1.executeQuery(sql1);
			if (rs1.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {}
		return false;
	}

	@Override
	public List<Comment> readAllComments() {
		// TODO Auto-generated method stub
		return null;
	}
	
//	public boolean pseudoExist() {
//		String sql1 = ("SELECT pseudo FROM customer WHERE pseudo='"+ this.pseudo + "'");
//		String sql2 = ("SELECT pseudo FROM seller WHERE pseudo='"+ this.pseudo + "'");
//		try {
//			Statement stm1 = ConnectionDB.creetConnectionDB().getConn().createStatement();
//			Statement stm2 = ConnectionDB.creetConnectionDB().getConn().createStatement();
//			ResultSet rs1 = stm1.executeQuery(sql1);
//			ResultSet rs2 = stm2.executeQuery(sql2);
//			return (rs1.next() || rs2.next()); 
//		} catch (SQLException e) {}
//		return true;
//	}
}
