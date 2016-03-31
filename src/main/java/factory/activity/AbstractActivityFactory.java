package factory.activity;

import java.util.Date;

import model.activity.Activity;
import model.category.Subcategory;
import model.person.User;

/**
 * Use for create instance of activity
 *
 */
public abstract class AbstractActivityFactory {

	/**
	 * create an activity
	 * @return activity
	 */
	public abstract Activity createActivity();
	
	/**
	 * create an activity
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param creationDate of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 * @return activity
	 */
	public abstract Activity createActivity(String title, String description, boolean visible, String creationDate, 
			Subcategory subcategory, User user);
	
	/**
	 * create an activity
	 * @param id of the activity
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param creationDate of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 * @return activity
	 */
	public abstract Activity createActivity(int id, String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user);
	
	/**
	 * create an activity
	 * @param user of the activity
	 * @return activity
	 */
	public abstract Activity createActivity(User u);
	
}
