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
		String sql = ("insert into task (name, description, frequency,checked,startdate,enddate, titre_activity, pseudo_customer) values ( '" + this.name + "','" + this.description + "','" + this.frequency + "','"+this.checked+"','" + this.startDate + "','" + this.endDate 
				+ "','" + this.activity.getTitle() + "','"+ activity.getUser().getPseudo() + "')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) 
		{e.printStackTrace();}
		return false;
	}
	
	@Override
	public boolean delete() {
		String sql = ("delete from task where name='"+ this.name +"' and pseudo_customer='"+ activity.getUser().getPseudo() +"'");
		Activity c = null;
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			
			return stm.execute(sql);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public String toString() {
		return this.name;
	}

	@Override
	public boolean update() {
		System.out.println(this.activity.getTitle());
		String sql = ("update task "
				+ "set name ='" + this.getName() + "', description ='" +this.getDescription()+"', frequency = '" + this.getFrequency()
				+ "', checked = '" + this.isChecked() + "', startdate ='" + this.getStartDate() + "', enddate ='" + this.getEndDate() 
				+ "', titre_activity = '" + this.activity.getTitle() + "', pseudo_customer = '" + this.getActivity().getUser().getPseudo() 
				+ "' where name='"+ this.name +"' and pseudo_customer='"+ activity.getUser().getPseudo() +"'");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
	
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return false;
	}
	
}
