package model.task.JDBC;

import java.sql.SQLException;
import java.sql.Statement;

import database.ConnectionDB;
import model.activity.Activity;
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





}
