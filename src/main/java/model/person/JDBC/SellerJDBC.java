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
import model.person.Seller;
import model.product.Product;
import model.product.JDBC.ProductJDBC;

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
		String sql2 = ("SELECT pseudo FROM seller WHERE pseudo='"+ this.pseudo + "'");
		try {
			Statement stm2 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs2 = stm2.executeQuery(sql2);
			if (rs2.next()) {
				return true;
			}
			else {
				return false;
			} 
		} catch (SQLException e) {}
		return false;
	}
	
	public boolean sellerExist() {
			String sql1 = ("SELECT pseudo FROM seller WHERE pseudo='"+ this.pseudo + "'");
		try {
			Statement stm1 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs1 = stm1.executeQuery(sql1);

			return (rs1.next()); 
		} catch (SQLException e) {}
		return true;
	}
	
	@Override
	public List<Product> readAllProducts() {
		String sql = ("select * from product where pseudo='"+this.getPseudo()+"' ");
		Product prod = new ProductJDBC();
		List<Product> listProd= new ArrayList<Product>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			SubcategoryJDBC subCategory;
			//ResultSetMetaData resultMeta;
			String nameSubcategory;
			while(rs.next()){
				//resultMeta = rs.getMetaData();
				prod.setName((String) rs.getObject("name"));
				prod.setIdProd((int) rs.getObject("id"));
				prod.setSeller(this);
				prod.setPrice(rs.getFloat("price"));
				prod.setQuantity((int) rs.getObject("quantity"));
				nameSubcategory  = (String) rs.getObject("name_subcategory");
				subCategory = new SubcategoryJDBC(nameSubcategory);
				subCategory.readByName();
				prod.setSubCategory(subCategory);
				prod = new ProductJDBC();
				listProd.add(prod);
			}
			rs.close();
			return listProd;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
