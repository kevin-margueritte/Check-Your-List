package facade;

import java.util.List;

import manager.CategoryManager;
import model.category.Category;
import model.category.Subcategory;


public class CategoryFacade {
	
	private CategoryManager cm;

	// Start of user code (user defined attributes for Connection)

	// End of user code

	/**
	 * The constructor.
	 */
	public CategoryFacade() {
		this.cm = new CategoryManager();
	}
	
	public boolean createCategory(String name, String shortDescription, String detailedDescription) {
		return this.cm.createCategory(name, shortDescription, detailedDescription);
	}
	
	public Category getCategory(String name) {
		return this.cm.getCategory(name);
	}
	
	public boolean createSubcategory(String name, String shortDescription, String detailedDescription, Category category) {
		return this.cm.createCategory(name, shortDescription, detailedDescription, category);
	}
	
	public Category getSubcategory(String name) {
		return this.cm.getCategory(name);
	}
	
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}
	
	public boolean categoryExist(String catName) {
		return this.cm.categoryExist(catName);
	}
	
	public List<Subcategory> getAllSubcategories() {
		return this.cm.getAllSubcategories();
	}
	
	public boolean subcategoryExist(String subcatName) {
		return this.cm.subcategoryExist(subcatName);
	}
}
