package facade;

import java.util.List;

import manager.CategoryManager;
import manager.TaskManager;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;

/**
 * to be the intermediary between TaskManager and UI task class
 *
 */
public class RessourceFacade {
	
	/**
	 * Description of the property taskUIs.
	 */
	private TaskManager fact;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor of RessourceFacade
	 */
	public RessourceFacade() {
		this.fact = new TaskManager();
	}
	
	/**
	 * create a new task
	 * @param name of the new task
	 * @param description of the new task
	 * @param frequency of the new task
	 * @param checked of the new task
	 * @param startDate of the new task
	 * @param endDate of the new task
	 * @param activity of the new task
	 * @param visibility of the new task
	 * @return true if the task is created else false
	 */
	public boolean createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		return this.fact.createTask(name, description, frequency, checked, startDate, endDate, activity,visibility);
	}
	

}
