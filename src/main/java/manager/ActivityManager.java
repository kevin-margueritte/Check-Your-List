package manager;

import java.util.Calendar;
import java.util.Date;

import factory.activity.AbstractActivityFactory;
import factory.activity.ActivityFactory;
import model.activity.Activity;
import model.category.Subcategory;
import model.person.User;

public class ActivityManager {
	
	private AbstractActivityFactory fact;
	
	public ActivityManager() {
		this.fact = new ActivityFactory();
	}
	
	public boolean createActivity(String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user) {
		Activity act = this.fact.createActivity(title, description, visible, creationDate, subcategory, user);
		return act.save();
	}
	
	public boolean createActivity(String title, String description, boolean visible, Subcategory subcategory,
			User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Activity act = this.fact.createActivity(title, description, visible, date.toString(), subcategory, user);
		return act.save();
	}

}
