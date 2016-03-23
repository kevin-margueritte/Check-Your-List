package factory.activity;

import java.util.Date;

import model.activity.Activity;
import model.category.Subcategory;
import model.person.User;

public abstract class AbstractActivityFactory {

	public abstract Activity createActivity();
	
	public abstract Activity createActivity(String title, String description, boolean visible, String creationDate, 
			Subcategory subcategory, User user);
	
	public abstract Activity createActivity(int id, String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user);
	
}
