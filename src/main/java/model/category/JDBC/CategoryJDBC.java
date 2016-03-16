package model.category.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.category.Category;

public class CategoryJDBC extends Category {
	public CategoryJDBC(String name, String shortDescription, String detailedDescription){
		super(name, shortDescription, detailedDescription);	
	}
	
	public CategoryJDBC(String name) {
		super(name);
	}
	
	public Category readByName() {
		String sql = ("SELECT * FROM category WHERE name = '" +  this.name + "'");
		Category c = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("category")) {
					this.name = (String) rs.getObject("name");
					this.shortDescription = (String) rs.getObject("shortDescription");
					this.detailedDescription = (String) rs.getObject("detailedDescription");
					c = new CategoryJDBC(name, shortDescription, detailedDescription);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Category)c;
	}
	
	public boolean save() {
		String sql = ("INSERT INTO category VALUES ( '" +  this.name + "','" + this.shortDescription + "','" + 
				this.detailedDescription +"')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {}
		return false;
	}
	
	
}
