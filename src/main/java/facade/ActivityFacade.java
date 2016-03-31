package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CategoryManager;
import manager.CommentManager;
import manager.ProductManager;
import manager.TaskManager;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.comment.Comment;
import model.person.User;
import model.product.Product;
import model.task.Task;

/**
 * to be the intermediary between ActivityManager and UI activity class
 *
 */
public class ActivityFacade {
	
	/**
	 * Description of the property activityUIs.
	 */
	private CategoryManager cm;
	private ActivityManager am;
	private CommentManager ctm;
	private TaskManager tm;
	private ProductManager pm;
	
	/**
	 * The constructor of activityFacade
	 */
	public ActivityFacade() {
		this.cm = new CategoryManager();
		this.am = new ActivityManager();
		this.ctm = new CommentManager();
		this.tm = new TaskManager();
		this.pm = new ProductManager();
	}

	/**
	 * get all sub-categories
	 * @param category
	 * @return List of sub-categories
	 */
	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	/**
	 * get all categories
	 * @return List of categories
	 */
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}
	
	/**
	 * create a new activity
	 * @param title of the new activity
	 * @param description of the new activity
	 * @param visible of the new activity
	 * @param subcategory of the new activity
	 * @param user of the new activity
	 * @return true if activity is created else false
	 */
	public boolean createActivity(String title, String description, boolean visible, Subcategory subcategory,
			User user) {
		return this.am.createActivity(title, description, visible, subcategory, user);
	}
	
	/**
	 * create a new activity comment 
	 * @param content of the new comment
	 * @param activity of the new comment
	 * @param user of the new comment
	 * @return @return true comment is created else false
	 */
	public boolean createComment(String content, Activity activity, User user) {
		return this.ctm.createCommentActivity(content, activity, user);
	}
	
	/**
	 * get all comments of an activity
	 * @param activity
	 * @return list of comments
	 */
	public List<Comment> getAllComments(Activity a) {
		return this.ctm.getAllCommentsActivity(a);
	}
	
	/**
	 * get all activities
	 * @param activity
	 * @return list of activities
	 */
	public List<Activity> getAllActivities(Activity act) {
		return this.am.readAllActivities(act);
	}
	
	/**
	 * get all task of an activity
	 * @param activity
	 * @return list of tasks
	 */
	public List<Task> getAllTasks(Activity act) {
		return am.getAllTasks(act);
	}
	
	/**
	 * check task
	 * @param task
	 * @param boolean
	 * @return if boolean=true task is checked else not
	 */
	public boolean updateChecked(Task task, boolean check) {
		return tm.updateChecked(task, check);
	}
	
	/**
	 * delete a task
	 * @param task
	 * @return true if the task is deleted else false
	 */
	public boolean deleteTask(Task t) {
		return tm.deleteTask(t);
	}
	
	/**
	 * get all products from sub-category
	 * @param sub-category
	 * @return list of products
	 */
	public List<Product> getAllProductsFromSubCategory(Subcategory sub) {
		return this.pm.getAllProductFromSubCategoryAndNoPresentTask(sub);
	}
	
	/**
	 * add product in a task
	 * @param product
	 * @param task
	 * @param quantity
	 * @return true if the product is added else false
	 */
	public boolean addRessource(Product p, Task t, int quantity) {
		return this.tm.addRessource(p, t, quantity);
	}
	
	/**
	 * get a task
	 * @param name of task
	 * @param activity
	 * @return task
	 */
	public Task getTask(String name, Activity act) {
		return this.tm.getTask(name, act);
	}
	
	/**
	 * find if an activity exist
	 * @param a activity
	 * @param title 
	 * @return true if the activity exist else false
	 */
	public boolean activityExist(Activity a, String title) {
		return this.am.activityExist(a, title);
	}
}
