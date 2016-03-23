package model.task.JDBC;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import database.ConnectionDB;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.category.JDBC.SubcategoryJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;
import model.task.Task;

public class TaskJDBC extends Task {
	
		public TaskJDBC() {
			super();
		}
		
		public TaskJDBC(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity) {
			super(name, description, frequency, checked, startDate, endDate, activity);
		}
		
		public TaskJDBC(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity) {
			super(id, name, description, frequency, checked, startDate, endDate, activity);
		}
		
		public TaskJDBC(int id, String name) {
			super(id, name);
		}

		@Override
		public boolean save() {
			String sql = ("insert into task (name, description, frequency,checked,startdate,enddate, titre_activity) values ( '" + this.name + "','" + this.description + "','" + this.frequency + "','"+this.checked+"','" + this.startDate + "','" + this.endDate 
					+ "','" + this.activity.getTitle() + "')");
			try {
				Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
				return stm.execute(sql);
			} catch (SQLException e) {}
			return false;
		}


		
		@Override
		public boolean delete() {
			String sql = ("delete from task where name='"+ this.name +"'");
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

		public static void main (String args[]){
			/*public abstract boolean save();
			public abstract Task readByName();
			public abstract List<Task> readAll();
			public abstract boolean delete();*/
			Category cat = new CategoryJDBC("cat1");
			cat= cat.readByName();
			Subcategory sub = new SubcategoryJDBC("sscat1");
			//sub= sub.readByName();
			User user = new UserJDBC("titi");
			user = (UserJDBC) user.readByPseudo();
			ActivityJDBC activity = new ActivityJDBC("a", "a", false, "2016-03-23", sub,(User) user);
			Task task = new TaskJDBC("name", "description", "frequency", false, "1993-10-05", "1993-10-05", activity);
			System.out.println(task.getName()+task.getDescription()+task.getStartDate()+task.getEndDate()+task.getActivity().getTitle()+task.isChecked());
			task.save();
			//task.delete();
			//task.readAll();
		}



}
