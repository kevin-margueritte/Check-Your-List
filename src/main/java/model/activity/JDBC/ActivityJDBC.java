package model.activity.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.category.JDBC.SubcategoryJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;

public class ActivityJDBC extends Activity {
	
	public ActivityJDBC() {
		super();
	}
	
	public ActivityJDBC(String title, String description, boolean visible, String creationDate, 
			Subcategory subcategory, User user) {
		super(title, description, visible, creationDate, subcategory, user);
	}
	
	public ActivityJDBC(int id, String title, String description, boolean visible, String creationDate,
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
					this.creationDate = (String) rs.getObject("creationdate");
					SubcategoryJDBC subcat = new SubcategoryJDBC(((Subcategory) rs.getObject("name_subcategory")).getName());
					this.subcategory = subcat.readByName();
					UserJDBC user = (UserJDBC) new UserJDBC(((User) rs.getObject("pseudo_user")).getPseudo());
					this.user = user.readByPseudo();
					c = new ActivityJDBC(title, description, visible, creationDate, subcategory, user);
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
		Category cat =(Category) new CategoryJDBC("cat1", "bla", "blabla");
		Subcategory sucat = new SubcategoryJDBC("sscat1", "bla", "blabla", cat);
		User user=(User) new UserJDBC("titi", "lastName", "firstName", "description", "password", "city", "postCode", "street", "houseNumber", "mail");
		Date date = new Date();
		SimpleDateFormat ft = new SimpleDateFormat ("yyyy-MM-dd");
		
		ActivityJDBC act1= new ActivityJDBC(1,"gio", "bla", true, ft.format(date) ,sucat, user);
		act1.save();
		System.out.println(ft.format(date)+" "+act1.title+" "+act1.description+" "+act1.visible+" "+act1.creationDate+" "+act1.subcategory.getName()+" "+act1.user.getPseudo());
	}

}
