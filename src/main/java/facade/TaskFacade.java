package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CategoryManager;
import manager.CommentManager;
import manager.ProductManager;
import manager.TaskManager;
import model.product.Product;
import model.task.Task;

/**
 *  to be the intermediary between TaskManager and UI task class
 *
 */
public class TaskFacade {
	/**
	 * Description of the property taskUIs.
	 */
	private TaskManager tm;
	
	/**
	 * constructor of taskFacade
	 */
	public TaskFacade() {
		this.tm = new TaskManager();
	}

	/**
	 * get all products of task
	 * @param t task
	 * @return list of products
	 */
	public List<Product> getAllProductFromTask(Task t) {
		return tm.getAllProductFromTask(t);
	}
	
}
