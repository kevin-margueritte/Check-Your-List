package factory.task;

import model.activity.Activity;
import model.task.Task;

public abstract class AbstractTaskFactory {
	public abstract Task createTask();
	public abstract Task createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity);
	public abstract Task createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String enDate, Activity activity); 
	public abstract Task createTask(int id, String name);
	
}
