package manager;

import java.util.Calendar;

import factory.task.AbstractTaskFactory;
import factory.task.TaskFactory;
import model.activity.Activity;
import model.product.Product;
import model.task.Task;


public class TaskManager {

	private AbstractTaskFactory fact;
	
	public TaskManager() {
		this.fact = new TaskFactory();
	}
	
	public boolean createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		Task task = this.fact.createTask(name, description, frequency, checked, startDate, endDate, activity,visibility);
		if (!task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
		
	public boolean createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Task task = this.fact.createTask(id, name, description, frequency, checked, date.toString(), endDate, activity, visibility);
		if (!task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
	
	public boolean createTask(int id, String name) {
		Task task = this.fact.createTask(id, name);
		if (task.exist()) {
			task.save();
			return true;
		}
		return false;
	}
	
	public boolean updateChecked(Task task, boolean check) {
		task.setChecked(check);
		return task.update();
	}
	
	public boolean deleteTask(Task t) {
		return t.delete();
	}
	
	public boolean addRessource(Product p, Task t, int quantity) {
		p.setQuantity(quantity);
		return t.addRessource(p);
	}

	public Task getTask(String name, Activity act) {
		Task task = this.fact.createTask(name, act);
		return task.readByName();
	}
}
