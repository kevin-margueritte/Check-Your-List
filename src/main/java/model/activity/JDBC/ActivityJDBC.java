package model.activity.JDBC;

import java.util.Date;
import java.util.List;

import model.activity.Activity;
import model.category.Subcategory;
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

	@Override
	public boolean save() {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public Activity readByID() {
		// TODO Auto-generated method stub
		return null;
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
		// TODO Auto-generated method stub
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

}
