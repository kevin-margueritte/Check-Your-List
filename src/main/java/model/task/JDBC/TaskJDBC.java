package model.task.JDBC;
import java.awt.List;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;
import java.text.ParseException;
import java.util.ArrayList;

import database.ConnectionDB;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
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
			String sql = ("INSERT INTO task (id, name, description, frequency, checked, startDate, endDate, titre_activity) VALUES ( '" +
					this.name + "','" + this.description + "','" + this.frequency + "','" + this.startDate + "','" + this.endDate 
					+ "','" + this.activity.getTitle() + "')");
			try {
				Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
				return stm.execute(sql);
			} catch (SQLException e) {}
			return false;
		}

		@Override
		public Task readByName() {
			String sql = ("SELECT * FROM task WHERE name = '" +  this.name + "'");
			Task c = null;
			try {
				Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
				
				ResultSet rs = stm.executeQuery(sql);
				
				if ( rs.next() ) {
					ResultSetMetaData resultMeta = rs.getMetaData();
					if (resultMeta.getTableName(1).equals("task")) {
						this.name = (String) rs.getObject("name");
						this.description = (String) rs.getObject("description");
						this.frequency = (String) rs.getObject("frequency");
						this.checked = (Boolean) rs.getObject("checked");
						this.startDate = (String) rs.getObject("startdate").toString();		
						ActivityJDBC act = new ActivityJDBC(1, rs.getObject("titre_activity").toString());
						this.activity = act.readByTitle();
						c = new TaskJDBC(name, description, frequency, checked, startDate, endDate, activity);
					}
					rs.close();
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return (Task)c;
		}



		@Override
		public java.util.List<Task> readAll() {
			String sql = ("select * from task ");
			Task task = null;
			java.util.List<Task> listAct= new ArrayList<Task>();
			try {
				Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
				ResultSet rs = stm.executeQuery(sql);
				while(rs.next()){
					task = new TaskJDBC(1,rs.getString(2));
					listAct.add(task.readByName());
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





}
