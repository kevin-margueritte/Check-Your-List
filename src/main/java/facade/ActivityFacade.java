package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CategoryManager;
import manager.CommentManager;
import manager.TaskManager;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.person.User;
import model.task.Task;

public class ActivityFacade {
	
	private CategoryManager cm;
	private ActivityManager am;
	private CommentManager ctm;
	private TaskManager tm;
	
	public ActivityFacade() {
		this.cm = new CategoryManager();
		this.am = new ActivityManager();
		this.ctm = new CommentManager();
		this.tm = new TaskManager();
	}

	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}
	
	public boolean createActivity(String title, String description, boolean visible, Subcategory subcategory,
			User user) {
		return this.am.createActivity(title, description, visible, subcategory, user);
	}
	
	public boolean createComment(String content, Activity activity) {
		return this.ctm.createComment(content, activity);
	}
	
	public List<Task> getAllTasks(Activity act) {
		return am.getAllTasks(act);
	}
	
	public boolean updateChecked(Task task, boolean check) {
		return tm.updateChecked(task, check);
	}
}
