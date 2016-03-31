package factory.task;

import model.activity.Activity;
import model.task.Task;

/**
 * Use for create instance of task
 *
 */
public abstract class AbstractTaskFactory {
	
	/**
	 * create a task
	 * @return task
	 */
	public abstract Task createTask();
	
	/**
	 * create a task
	 * @param name of the task
	 * @param description of the task
	 * @param frequency of the task
	 * @param checked of the task
	 * @param startDate of the task
	 * @param endDate of the task
	 * @param activity of the task
	 * @param visibility of the task
	 * @return task
	 */
	public abstract Task createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility);
	
	/**
	 * create a task
	 * @param id of the task
	 * @param name of the task
	 * @param description of the task
	 * @param frequency of the task
	 * @param checked of the task
	 * @param startDate of the task
	 * @param enDate of the task
	 * @param activity of the task
	 * @param visibility of the task
	 * @return task
	 */
	public abstract Task createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String enDate, Activity activity, boolean visibility); 
	
	/**
	 * create a task
	 * @param id of the task
	 * @param name of the task
	 * @return task
	 */
	public abstract Task createTask(int id, String name);
	
	/**
	 * create a task
	 * @param name of the task
	 * @param act of the task
	 * @return task
	 */
	public abstract Task createTask(String name, Activity act);
	
}
