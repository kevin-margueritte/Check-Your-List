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
 * 
 * @author JHJJJJJJJJ
 *
 */
public class ShopFacade {
	
	private CategoryManager cm;
	private ActivityManager am;
	private CommentManager ctm;
	private TaskManager tm;
	private ProductManager pm;
	
	public ShopFacade() {
		this.cm = new CategoryManager();
		this.pm = new ProductManager();
	}

	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}

	
	public List<Product> getAllProductsFromSubCategory(Subcategory sub) {
		return this.pm.getAllProductsFromSubCategory(sub);
	}
}
