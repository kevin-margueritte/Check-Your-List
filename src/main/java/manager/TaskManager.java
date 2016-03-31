package manager;

import java.util.Calendar;
import java.util.List;

import factory.task.AbstractTaskFactory;
import factory.task.TaskFactory;
import model.activity.Activity;
import model.product.Product;
import model.task.Task;

/**
 * to be the intermediary between AbstractTaskFactory and  TaskFacade
 *
 */
public class TaskManager {

	private AbstractTaskFactory fact;
	
	/**
	 * constructor of TaskManager
	 */
	public TaskManager() {
		this.fact = new TaskFactory();
	}
	
	/**
	 * create task
	 * @param name of the task
	 * @param description of the task
	 * @param frequency of the task
	 * @param checked of the task
	 * @param startDate of the task
	 * @param endDate of the task
	 * @param activity of the task
	 * @param visibility of the task
	 * @return true if the task is created else false
	 */
	public boolean createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		Task task = this.fact.createTask(name, description, frequency, checked, startDate, endDate, activity,visibility);
		if (!task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
	
	/**
	 * create task
	 * @param id of the task
	 * @param name of the task
	 * @param description of the task
	 * @param frequency of the task
	 * @param checked of the task
	 * @param startDate of the task
	 * @param endDate of the task
	 * @param activity of the task
	 * @param visibility of the task
	 * @return true if the task is created else false
	 */
	public boolean createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Task task = this.fact.createTask(id, name, description, frequency, checked, date.toString(), endDate, activity, visibility);
		if (!task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
	
	/**
	 * create task
	 * @param id of the task
	 * @param name of the task
	 * @return true if the task is created else false
	 */
	public boolean createTask(int id, String name) {
		Task task = this.fact.createTask(id, name);
		if (task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
	
	/**
	 * update checked of task
	 * @param task
	 * @param check
	 * @return true if checked is updated else false
	 */
	public boolean updateChecked(Task task, boolean check) {
		task.setChecked(check);
		return task.update();
	}
	
	/**
	 * delete task
	 * @param task
	 * @return true if the task is deleted
	 */
	public boolean deleteTask(Task t) {
		return t.delete();
	}
	
	/**
	 * add a product on task
	 * @param product
	 * @param task
	 * @param quantity
	 * @return true if the product is added else false
	 */
	public boolean addRessource(Product p, Task t, int quantity) {
		p.setQuantity(quantity);
		return t.addRessource(p);
	}

	/**
	 * get task
	 * @param name of task
	 * @param activity 
	 * @return task
	 */
	public Task getTask(String name, Activity act) {
		Task task = this.fact.createTask(name, act);
		return task.readByName();
	}
	
	/**
	 * get all products of a task
	 * @param task
	 * @return list of products
	 */
	public List<Product> getAllProductFromTask(Task t) {
		return t.getAllRessourceTask();
	}
}
