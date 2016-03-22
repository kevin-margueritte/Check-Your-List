package factory.category;

import model.category.Category;
import model.category.Subcategory;

public abstract class AbstractCategoryFactory {
	
	public abstract Category createCategory(String pseudo, String shortDescription, String detailedDescription);
	
	public abstract Category createCategory(String pseudo);
	
	public abstract Subcategory createSubcategory(String pseudo, String shortDescription, String detailedDescription, Category category);
	
	public abstract Subcategory createSubcategory(String pseudo);
	
	public abstract Category createCategory();

	public abstract Subcategory createSubcategory();
	
	public abstract Subcategory createSubcategory(Category c);
	
}