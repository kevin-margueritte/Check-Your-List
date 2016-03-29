package manager;

import java.util.Calendar;

import factory.task.AbstractTaskFactory;
import factory.task.TaskFactory;
import model.activity.Activity;
import model.task.Task;


public class TaskManager {

	private AbstractTaskFactory fact;
	
	public TaskManager() {
		this.fact = new TaskFactory();
	}
	
	public boolean createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity) {
		Task task = this.fact.createTask(name, description, frequency, checked, startDate, endDate, activity);
		return task.save();
	}
		
	public boolean createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());
		Task task = this.fact.createTask(id, name, description, frequency, checked, date.toString(), endDate, activity);
		return task.save();
	}
	
	public boolean createTask(int id, String name) {
		Task task = this.fact.createTask(id, name);
		return task.save();
	}
	
	public boolean updateChecked(Task task, boolean check) {
		task.setChecked(check);
		return task.update();
	}

}
