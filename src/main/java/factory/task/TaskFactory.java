package factory.task;

import model.activity.Activity;
import model.task.Task;
import model.task.JDBC.TaskJDBC;

public class TaskFactory extends AbstractTaskFactory{
	@Override
	public Task createTask() {
		return new TaskJDBC();
	}

	@Override
	public Task createTask(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility){
		return new TaskJDBC(name, description, frequency, checked, startDate, endDate, activity,visibility);
	}
	
	@Override
	public Task createTask(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility){
		return new TaskJDBC(id, name, description, frequency, checked, startDate, endDate, activity,visibility);
	}

	@Override
	public Task createTask(int id, String name){
		return new TaskJDBC(id, name);
	}

	@Override
	public Task createTask(String name, Activity act) {
		return new TaskJDBC(name, act);
	}
}
