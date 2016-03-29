package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CategoryManager;
import manager.CommentManager;
import model.activity.Activity;
import model.category.Category;
import model.category.Subcategory;
import model.comment.Comment;
import model.person.User;

/**
 * 
 * @author JHJJJJJJJJ
 *
 */
public class ActivityFacade {
	
	private CategoryManager cm;
	private ActivityManager am;
	private CommentManager ctm;
	
	public ActivityFacade() {
		this.cm = new CategoryManager();
		this.am = new ActivityManager();
		this.ctm = new CommentManager();
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
	
	public boolean createComment(String content, Activity activity, User user) {
		return this.ctm.createCommentActivity(content, activity, user);
	}
	
	public List<Comment> getAllComments(Activity a) {
		return this.ctm.getAllCommentsActivity(a);
	}
	
	public List<Activity> getAllActivities(Activity act) {
		return this.am.readAllActivities(act);
	}
	
}
