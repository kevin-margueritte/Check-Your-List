package model.product.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import UI.LoginUI;
import database.ConnectionDB;
import model.category.Subcategory;
import model.person.Seller;
import model.product.Product;


public class ProductJDBC extends Product{
	
	public ProductJDBC(String name, Seller seller, Subcategory subCategory){
		super(name,seller,subCategory);
	}
	
	/*CREATE TABLE product
	(
	  id serial NOT NULL,
	  name character,
	  id_sell serial NOT NULL,
	  name_subcategory character,
	  [...]
	 */
	public boolean save(){
		//Recupère le Seller 
		
		//Recupère la Sub Category
		
		String sql = ("INSERT INTO product VALUES ("
				+ "'" +  this.name + ","
				//+ this.id + "," 
				+ this.subCategory + "')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {e.printStackTrace();}
		return false;
	}
	
	
	public static void main(String args[]) {
		//ProductJDBC prod = new ProductJDBC("whisky","jack","boisson");
		//prod.save();
	}

	
}


