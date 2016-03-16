package manager;

import java.util.Date;

import factory.activity.AbstractActivityFactory;
import factory.activity.ActivityFactory;
import model.category.Subcategory;
import model.person.User;

public class ActivityManager {
	
private AbstractActivityFactory fact;
	
	public ActivityManager() {
		this.fact = new ActivityFactory();
	}
	
	public boolean createActivity(String title, String description, boolean visible, Date creationDate,
			Subcategory subcategory, User user) {
		this.fact.createActivity(title, description, visible, creationDate, subcategory, user);
		return true;
	}

}
