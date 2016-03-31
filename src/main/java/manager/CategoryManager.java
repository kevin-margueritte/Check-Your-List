package manager;

import java.util.List;

import factory.category.AbstractCategoryFactory;
import factory.category.CategoryFactory;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.category.JDBC.SubcategoryJDBC;

/**
 * to be the intermediary between AbstractCategoryFactory and  CategoryFacade
 *
 */
public class CategoryManager {
	
	private AbstractCategoryFactory fact;
	
	/**
	 * constructor of CategoryManager
	 */
	public CategoryManager() {
		this.fact = new CategoryFactory();
	}
	
	/**
	 * get category
	 * @param name of the category
	 * @return category
	 */
	public Category getCategory(String name) {
		Category c = this.fact.createCategory(name);
		((CategoryJDBC)c).readByName();
		return c;
	}
	
	/**
	 * create a category
	 * @param name of the category
	 * @param shortDescription of the category
	 * @param detailedDescription of the category
	 * @return true if the category is created else false
	 */
	public boolean createCategory(String name, String shortDescription, String detailedDescription) {
		boolean res = false;
		Category c = this.fact.createCategory(name, shortDescription, detailedDescription);
		res = ((CategoryJDBC)c).save();
		return res;
	}
	
	/**
	 * get sub-category
	 * @param name of the sub-category
	 * @return sub-category
	 */
	public Subcategory getSubcategory(String name) {
		Subcategory c = this.fact.createSubcategory(name);
		((SubcategoryJDBC)c).readByName();
		return c;
	}
	
	/**
	 * create a sub-category
	 * @param name of the sub-category
	 * @param shortDescription of the sub-category
	 * @param detailedDescription of the sub-category
	 * @param category of the sub-category
	 * @return true if sub-category is created else false
	 */
	public boolean createSubcategory(String name, String shortDescription, String detailedDescription, Category category) {
		boolean res = false;
		Subcategory c = this.fact.createSubcategory(name, shortDescription, detailedDescription, category);
		res = ((SubcategoryJDBC)c).save();
		return res;
	}
	
	/**
	 * get all categories
	 * @return list of categories
	 */
	public List<Category> getAllCategories() {
		Category cat = this.fact.createCategory();
		return cat.getAllCategories();
	}
	
	/**
	 * find if the category exist
	 * @param name of category
	 * @return true if the category exist else false
	 */
	public boolean categoryExist(String catName) {
		Category cat = this.fact.createCategory();
		return cat.categoryExist(catName);
	}
	
	/**
	 * get all sub-categories of a category
	 * @param category
	 * @return list of sub-category
	 */
	public List<Subcategory> getAllSubcategories(Category category) {
		return category.getAllSubcategories();
	}
	
	/**
	 * find if the sub-category exist
	 * @param name of the sub-category
	 * @return true if the sub-category exist
	 */
	public boolean subcategoryExist(String subcatName) {
		Subcategory subcat = this.fact.createSubcategory();
		return subcat.subcategoryExist(subcatName);
	}

}
