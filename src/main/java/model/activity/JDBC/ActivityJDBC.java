package model.activity.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.category.Subcategory;
import model.category.JDBC.SubcategoryJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;

public class ActivityJDBC extends Activity {
	
	public ActivityJDBC() {
		super();
	}
	
	public ActivityJDBC(User u) {
		super(u);
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
		String sql = ("SELECT * FROM activity WHERE id = '" +  this.id + "'");
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
					this.creationDate = (String) rs.getObject("creationdate").toString();
					SubcategoryJDBC subcat = new SubcategoryJDBC(rs.getObject("name_subcategory").toString());
					this.subcategory = subcat.readByName();
					UserJDBC user = (UserJDBC) new UserJDBC((rs.getObject("pseudo_user")).toString());
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
	public List<Activity> readAll() {
		String sql = ("select * from activity ");
		Activity act = null;
		List<Activity> listAct= new ArrayList<Activity>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				act = new ActivityJDBC((Integer.parseInt(rs.getString(1)))," ");
				listAct.add(act.readByID());
			}
			rs.close();
			return listAct;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public List<Activity> readAllByUser() {
		String sql = ("select * from activity where pseudo_user='"+this.user.getPseudo()+"' ");
		Activity act = null;
		List<Activity> listAct= new ArrayList<Activity>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				act = new ActivityJDBC((Integer.parseInt(rs.getString(1)))," ");
				listAct.add(act.readByID());
			}
			rs.close();
			return listAct;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
	public boolean deleteByPseudoUserAndName() {
		String sql = ("delete from activity where pseudo_user= '"+ this.getUser().getPseudo() +"' AND"
				+ "title = '" + this.getTitle() + "'");
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

	@Override
	public String toString() {
		return this.title;
	}
	

}
