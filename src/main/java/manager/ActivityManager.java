package manager;

import java.util.Calendar;
import java.util.List;

import factory.activity.AbstractActivityFactory;
import factory.activity.ActivityFactory;
import model.activity.Activity;
import model.category.Subcategory;
import model.person.User;
import model.task.Task;

/**
 * to be the intermediary between AbstractActivityFactory and  ActivityFacade
 *
 */
public class ActivityManager {
	
	private AbstractActivityFactory fact;
	
	/**
	 * constructor of ActivityManager
	 */
	public ActivityManager() {
		this.fact = new ActivityFactory();
	}
	
	/**
	 * create an activity 
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param creationDate of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 * @return true if the activty is created else false
	 */
	public boolean createActivity(String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user) {
		Activity act = this.fact.createActivity(title, description, visible, creationDate, subcategory, user);
		return act.save();
	}
	
	/**
	 * create an activity
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 * @return true if the activty if on the DB else false
	 */
	public boolean createActivity(String title, String description, boolean visible, Subcategory subcategory,
			User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Activity act = this.fact.createActivity(title, description, visible, date.toString(), subcategory, user);
		return act.save();
	}
	
	/**
	 * get all activities of an user
	 * @param user
	 * @return list of activities
	 */
	public List<Activity> getAllActivities(User u) {
		return u.readAllActivities();
	}
	
	/**
	 * delete an activity 
	 * @param activity
	 * @return true if the activity is deleted else false
	 */
	public boolean deleteByPseudoUserAndName(Activity act) {
		return act.deleteByPseudoUserAndName();
	}
	
	/**
	 * get all activities
	 * @param activity
	 * @return list of activities
	 */
	public static List<Activity> readAllActivities(Activity act) {
		return act.readAllPrivate();
	}

	/**
	 * get all tasks of an activity
	 * @param activity
	 * @return list of tasks
	 */
	public List<Task> getAllTasks(Activity act) {
		return act.readAllTask();
	}
	
	/**
	 * find if the activity exist
	 * @param act activity
	 * @param title of activity
	 * @return true if the activity exist else false
	 */
	public boolean activityExist(Activity act,String title) {
		return act.activityExist(title);
	}
}
