package model.task.JDBC;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import database.ConnectionDB;
import model.activity.Activity;
import model.product.Product;
import model.task.Task;

public class TaskJDBC extends Task {
	
	public TaskJDBC() {
		super();
	}
	
	public TaskJDBC(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		super(name, description, frequency, checked, startDate, endDate, activity, visibility);
	}
	
	public TaskJDBC(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		super(id, name, description, frequency, checked, startDate, endDate, activity, visibility);
	}
	
	public TaskJDBC(int id, String name) {
		super(id, name);
	}
	
	public TaskJDBC(String name, Activity act) {
		super(name, act);
	}
	
	@Override
	public boolean save() {
		String sql = ("insert into task (name, description, frequency,checked,startdate,enddate, titre_activity, pseudo_customer,visibility) values ( '" + this.getName() + "','" + this.getDescription() + "','" + this.getFrequency() + "','"+this.getChecked() +"','" + this.startDate + "','" + this.endDate 
				+ "','" + this.activity.getTitle() + "','"+ activity.getUser().getPseudo() + "','" + this.getVisibility() + "')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e) {}
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

	@Override
	public boolean addRessource(Product p) {
		String sql = ("insert into lineRessource (quantity, visible, id_product, name_task) values ( '" + p.getQuantity() 
		+ "','" + true + "','" + p.getIdProd() + "','"+this.getName()+"')");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			return stm.execute(sql);
		} catch (SQLException e){
			e.printStackTrace();
		}
		return false;
	}

	@Override
	public Task readByName() {
		String sql = ("select * from task where name='"+ this.getName() +"'");
		try {
			Statement stm = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs = stm.executeQuery(sql);
			if(rs.next()){
				this.setName(rs.getString("name"));
				this.setDescription(rs.getString("description"));
				this.setFrequency(rs.getString("frequency"));
				this.setChecked(rs.getBoolean("checked"));
				this.setStartDate(rs.getString("startdate"));
				this.setEndDate(rs.getString("enddate"));
			}
			rs.close();
			return this;
		} catch (SQLException e) {}
		return new TaskJDBC();
	}

	@Override
	public boolean exist() {
		String sql1 = ("SELECT 1 FROM task WHERE name='"+ this.name + "'");
		try {
			Statement stm1 = ConnectionDB.creetConnectionDB().getConn().createStatement();
			ResultSet rs1 = stm1.executeQuery(sql1);
			if (rs1.next()) {
				return true;
			}
			else {
				return false;
			}
		} catch (SQLException e) {}
		return false;
	}

}
