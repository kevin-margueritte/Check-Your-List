package factory.category;

import model.category.Category;
import model.category.Subcategory;

/**
 * Use for create instance of category
 *
 */
public abstract class AbstractCategoryFactory {
	
	/**
	 * create a category
	 * @param name of the category
	 * @param shortDescription of the category
	 * @param detailedDescription of the category
	 * @return category
	 */
	public abstract Category createCategory(String pseudo, String shortDescription, String detailedDescription);
	
	/**
	 * create a category
	 * @param name of the category
	 * @return category
	 */
	public abstract Category createCategory(String pseudo);
	
	/**
	 * create a sub-category
	 * @param name of the sub-category
	 * @param shortDescription of the sub-category
	 * @param detailedDescription of the sub-category
	 * @param category 
	 * @return sub-category
	 */
	public abstract Subcategory createSubcategory(String pseudo, String shortDescription, String detailedDescription, Category category);
	
	/**
	 * create a sub-category
	 * @param nom of the sub-category
	 * @return sub-category
	 */
	public abstract Subcategory createSubcategory(String pseudo);
	
	/**
	 * create a category
	 * @return category
	 */
	public abstract Category createCategory();

	/**
	 * create a sub-category
	 * @return sub-category
	 */
	public abstract Subcategory createSubcategory();
	
	/**
	 * create a sub-category
	 * @param category
	 * @return sub-category
	 */
	public abstract Subcategory createSubcategory(Category c);
	
}