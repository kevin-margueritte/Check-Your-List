package model.activity.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Date;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.person.User;

public class ActivityJDBC extends Activity {
	
	public ActivityJDBC() {
		super();
	}
	
	public ActivityJDBC(String title, String description, boolean visible, Date creationDate, 
			Subcategory subcategory, User user) {
		super(title, description, visible, creationDate, subcategory, user);
	}
	
	public ActivityJDBC(int id, String title, String description, boolean visible, Date creationDate,
			Subcategory subcategory, User user) {
		super(id, title, description, visible, creationDate, subcategory, user);
	}
	
	public ActivityJDBC(int id, String title) {
		super(id, title);
	}

	@Override
	public boolean save() {
		String sql = ("INSERT INTO activity (titre, description, visible, creationdate, pseudo_user, name_subcategory) VALUES ( '" +
				this.title + "','" + this.description + "','" + this.visible + "','" + this.creationDate + "','" + this.user.getPseudo() 
				+ "','" + this.subcategory.getName() + "')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {}
		return false;
	}

	@Override
	public Activity readByID() {
		String sql = ("SELECT * FROM activity WHERE name = '" +  this.id + "'");
		Activity c = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if ( rs.next() ) {
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("activity")) {
					this.title = (String) rs.getObject("titre");
					this.description = (String) rs.getObject("description");
					this.visible = (Boolean) rs.getObject("visible");
					this.creationDate = (Date) rs.getObject("creationdate");
					this.subcategory = (Subcategory) rs.getObject("crea");
					//, user
					//c = new CategoryJDBC(name, shortDescription, detailedDescription);
				}
				rs.close();
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return (Activity)c;
	}

	@Override
	public boolean modify() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List<Activity> readAll() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean delete() {
		String sql = ("delete from activity where id="+ this.id +"");
		Activity c = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			
			return stm.execute(sql);

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public boolean addTask() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean deleteTask() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public static void main(String args[]){
		ActivityJDBC act= new ActivityJDBC(4, "act2");
		act.delete();
	}

}
