package facade;

import java.util.List;

import manager.CategoryManager;
import manager.TaskManager;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;

public class RessourceFacade {
	
	private TaskManager fact;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor.
	 */
	public RessourceFacade() {
		this.fact = new TaskManager();
	}
	
	public boolean createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity) {
		return this.fact.createTask(name, description, frequency, checked, startDate, endDate, activity);
	}
	

}
