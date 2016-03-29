package model.activity.JDBC;

import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.category.JDBC.SubcategoryJDBC;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;
import model.task.Task;
import model.task.JDBC.TaskJDBC;

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
	
	public ActivityJDBC(String title) {
		super(title);
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
	public Activity readByTitle() {
		String sql = ("SELECT * FROM activity WHERE titre = '" +  this.title + "'");
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
				act = new ActivityJDBC(rs.getString(2));
				listAct.add(act.readByTitle());
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
		String sql = ("delete from activity where pseudo_user= '"+ this.getUser().getPseudo() +"' AND titre = '" + this.getTitle() + "'");
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
	
	@Override
	public List<Task> readTaskByActivity() {
		String sql = ("SELECT * FROM task WHERE titre_activity = '" +  this.title + "'");
		Task c = null;
		int i=0;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			
			ResultSet rs = stm.executeQuery(sql);
			
			while(rs.next()){
					this.listTask.get(i).setName((String) rs.getObject("name"));
					this.listTask.get(i).setDescription((String) rs.getObject("description"));
					this.listTask.get(i).setFrequency((String) rs.getObject("frequency"));
					this.listTask.get(i).setChecked((Boolean) rs.getObject("checked"));
					this.listTask.get(i).setStartDate((String) rs.getObject("startdate").toString());		
					this.listTask.get(i).setActivity(this);
					i++;
			}
				rs.close();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return this.listTask;
	}
	
	
	@Override
	public List<Comment> readAllComments() {
		String sql = ("SELECT * FROM commentActivity WHERE titre_activity = '" + this.getTitle() + "'");
		List<Comment> list = new ArrayList<Comment>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while ( rs.next() ) {
				Comment comment = new CommentJDBC();
				ResultSetMetaData resultMeta = rs.getMetaData();
				if (resultMeta.getTableName(1).equals("commentactivity")) {
					comment.setContent((String) rs.getObject("content"));
					comment.setPostingDate((String) rs.getObject("postingdate").toString());
					User u = (User) new UserJDBC((String) rs.getObject("pseudo_sender"));
					comment.setUser(u);
					list.add(comment);
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
	public List<Activity> readAllActivities() {
		String sql = ("select * from activity");
		Activity act = null;
		List<Activity> listAct= new ArrayList<Activity>();
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()){
				act = new ActivityJDBC(rs.getString(2));
				listAct.add(act.readByTitle());
			}
			rs.close();
			return listAct;

		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
}
