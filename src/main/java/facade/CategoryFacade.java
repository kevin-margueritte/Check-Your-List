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
	
	public Category getCategory(String name) {
		return this.cm.getCategory(name);
	}
	
}
