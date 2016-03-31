package facade;

import java.util.List;

import manager.CategoryManager;
import model.category.Category;
import model.category.Subcategory;

/**
 * to be the intermediary between CategoryManager and UI category class
 *
 */
public class CategoryFacade {
	
	/**
	 * Description of the property categoryUIs.
	 */
	private CategoryManager cm;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor of CategoryFacade
	 */
	public CategoryFacade() {
		this.cm = new CategoryManager();
	}
	
	/**
	 * create a new category
	 * @param name of the new category
	 * @param shortDescription of the new category
	 * @param detailedDescription of the new category
	 * @return true if the category is created else false
	 */
	public boolean createCategory(String name, String shortDescription, String detailedDescription) {
		return this.cm.createCategory(name, shortDescription, detailedDescription);
	}
	
	/**
	 * get category
	 * @param name of the category
	 * @return category
	 */
	public Category getCategory(String name) {
		return this.cm.getCategory(name);
	}
	
	/**
	 * create a new sub-category
	 * @param name of the new sub-category
	 * @param shortDescription of the new sub-category
	 * @param detailedDescription of the new sub-category
	 * @param category of the new sub-category
	 * @return true if the sub-category is created else false
	 */
	public boolean createSubcategory(String name, String shortDescription, String detailedDescription, Category category) {
		return this.cm.createCategory(name, shortDescription, detailedDescription, category);
	}
	
	/**
	 * get sub-category
	 * @param name of the sub-category
	 * @return sub-category
	 */
	public Category getSubcategory(String name) {
		return this.cm.getCategory(name);
	}
	
	/**
	 * get all categories
	 * @return list of categories
	 */
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}
	
	/**
	 * find if the category exist
	 * @param name of the category
	 * @return true if the category exist else false
	 */
	public boolean categoryExist(String catName) {
		return this.cm.categoryExist(catName);
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
	 * find if the sub-category exist 
	 * @param name of the sub-category
	 * @return true if the sub-category exist else false
	 */
	public boolean subcategoryExist(String subcatName) {
		return this.cm.subcategoryExist(subcatName);
	}
}
