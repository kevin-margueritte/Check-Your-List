package facade;

import manager.CategoryManager;
import model.category.Category;


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
	
}
