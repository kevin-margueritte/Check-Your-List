package factory.category;

import model.category.Category;

public abstract class AbstractCategoryFactory {
	
	public abstract Category createCategory(String pseudo, String shortDescription, String detailedDescription);
	
	public abstract Category createCategory(String pseudo);
	
}