package model.product.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.product.Product;


public class ProductJDBC extends Product{

	
	public ProductJDBC(String name, int quantity, double price, String id){
		super(name,quantity,price,id);
	}
	
	public Product readByName(){
		String sql = ("INSERT INTO Product VALUES ('" +  this.name + "," + this.quantity + ","+ this.price + "," + this.id +"'");
		Product prod = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("customer")) {
					this.name = (String) rs.getObject("lastName");
					this.quantity = (int) rs.getObject("firstName");
					this.price = (double) rs.getObject("description");
					this.id = (String) rs.getObject("pass");	
					prod = new ProductJDBC(name, quantity, price, id);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Product)prod;
	}
		
		
		
	

	
}
