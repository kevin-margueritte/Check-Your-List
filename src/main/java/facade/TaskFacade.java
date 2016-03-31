package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CategoryManager;
import manager.CommentManager;
import manager.ProductManager;
import manager.TaskManager;
import model.product.Product;
import model.task.Task;

public class TaskFacade {
	
	private TaskManager tm;
	
	public TaskFacade() {
		this.tm = new TaskManager();
	}

	public List<Product> getAllProductFromTask(Task t) {
		return tm.getAllProductFromTask(t);
	}
	
}
