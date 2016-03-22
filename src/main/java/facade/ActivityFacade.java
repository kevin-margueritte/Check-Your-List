package facade;

import java.util.List;

import manager.CategoryManager;
import model.category.Category;
import model.category.Subcategory;

public class ActivityFacade {
	
	private CategoryManager cm;
	
	public ActivityFacade() {
		this.cm = new CategoryManager();
	}

	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}
	
}
