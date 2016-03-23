package model.category.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import database.ConnectionDB;
import model.category.Category;
import model.category.Subcategory;

public class CategoryJDBC extends Category {
	
	public CategoryJDBC() {
		super();
	}
	
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

	@Override
	public List<Category> getAllCategories() {
		String sql = ("SELECT * FROM category");
		List<Category> list = new ArrayList<Category>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while ( rs.next() ) {
				Category cat = new CategoryJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("category")) {
					cat.setName((String) rs.getObject("name"));
					cat.setDetailedDescription((String) rs.getObject("detailleddescription"));
					cat.setShortDescription((String) rs.getObject("shortdescription"));
					list.add(cat);
				}
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	public boolean categoryExist(String catName) {
			List<Category> list = getAllCategories();
			Iterator<Category> iterator = list.iterator();
			while (iterator.hasNext()) {
				if(iterator.next().toString().equals(catName)) {
					return true;
				}
			}	
			return false;
	}
	
	@Override
	public List<Subcategory> getAllSubcategories() {
		String sql = ("SELECT * FROM subcategory WHERE name_category = '" + this.getName() + "'");
		List<Subcategory> list = new ArrayList<Subcategory>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while ( rs.next() ) {
				Subcategory subcat = new SubcategoryJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("subcategory")) {
					subcat.setName((String) rs.getObject("name"));
					subcat.setDetailedDescription((String) rs.getObject("detailleddescription"));
					subcat.setShortDescription((String) rs.getObject("shortdescription"));
					list.add(subcat);
				}
			}
			rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}
	
	@Override
	public String toString() {
		return this.name;
	}
	
	
	
}
