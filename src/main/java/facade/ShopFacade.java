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
 *  to be the intermediary between ProductManager and UI shop class
 *
 */
public class ShopFacade {
	
	/**
	 * Description of the property shopUIs.
	 */
	private CategoryManager cm;
	private ActivityManager am;
	private CommentManager ctm;
	private TaskManager tm;
	private ProductManager pm;
	
	/**
	 * constructor of ShopFacade
	 */
	public ShopFacade() {
		this.cm = new CategoryManager();
		this.pm = new ProductManager();
	}

	/**
	 * get all sub-categories of a category
	 * @param category
	 * @return list of sub-categories
	 */
	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	/**
	 * get all categories
	 * @return list of categories
	 */
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}

	/**
	 * get all products of a sub-category
	 * @param sub-category
	 * @return list of product
	 */
	public List<Product> getAllProductsFromSubCategory(Subcategory sub) {
		return this.pm.getAllProductsFromSubCategory(sub);
	}
}
