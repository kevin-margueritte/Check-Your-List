package model.category.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDB;
import model.category.Category;
import model.category.Subcategory;

public class SubcategoryJDBC extends Subcategory {
	
	public SubcategoryJDBC(String name, String shortDescription, String detailedDescription, Category category){
		super(name, shortDescription, detailedDescription, category);	
	}
	
	public SubcategoryJDBC(String name) {
		super(name);
	}
	
	public Subcategory readByName() {
		String sql = ("SELECT * FROM subCategory WHERE name = '" +  this.name + "'");
		Subcategory c = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("subCategory")) {
					this.name = (String) rs.getObject("name");
					this.shortDescription = (String) rs.getObject("shortDescription");
					this.detailedDescription = (String) rs.getObject("detailedDescription");
					this.category = (Category) rs.getObject("name_category");
					c = new SubcategoryJDBC(name, shortDescription, detailedDescription, category);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Subcategory)c;
	}
	
	public boolean save() {
		String sql = ("INSERT INTO subCategory VALUES ( '" +  this.name + "','" + this.shortDescription + "','" + 
				this.detailedDescription + "','" + this.category +"')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {}
		return false;
	}
	
	public List<Category> readAllCategories() {
		return new ArrayList<Category>();
	}
}
