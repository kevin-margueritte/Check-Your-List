package model.category;

import java.util.ArrayList;
import java.util.List;

/**
 *business class of category 
 *
 */
public abstract class Category {
	/**
	 * name of category
	 */
	protected String name;
	/**
	 * shortDescription of category
	 */
	protected String shortDescription;
	/**
	 * detailedDescription of category
	 */
	protected String detailedDescription;
	
	//protected List subcategories = new ArrayList();
	
	/**
	 * constructor of category
	 */
	public Category() {
	}
	
	/**
	 * constructor of category
	 * @param name
	 */
	public Category(String name) {
		this.name= name;
	}
	
	/**
	 * constructor of category
	 * @param name
	 * @param shortDescription
	 * @param detailedDescription
	 */
	public Category(String name, String shortDescription, String detailedDescription) {
		this.name= name;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
	}
	
	/**
	 * get all categories
	 * @return list of cactegories
	 */
	public abstract List<Category> getAllCategories();
	
	/**
	 * find if the category exist
	 * @param Name of category
	 * @return true if the category exist else false
	 */
	public abstract boolean categoryExist(String catName);
	
	/**
	 * get all sub-categories of a category
	 * @return list of sub-category
	 */
	public abstract List<Subcategory> getAllSubcategories();
	
	/**
	 * get name of category
	 * @return name
	 */
	public String getName() {
		return this.name;
	}
	
	/**
	 * get short description of a category
	 * @return short description
	 */
	public String getShortDescription() {
		return this.shortDescription;
	}
	
	/**
	 * get detailed description of a category
	 * @return detailed description
	 */
	public String getDetailedDescription() {
		return this.detailedDescription;
	}
	
	/**
	 * set name of a category
	 * @param name
	 */
	public void setName(String name) {
	    this.name = name;
	}
	
	/**
	 * set short description of a category
	 * @param shortDescription
	 */
	public void setShortDescription(String shortDescription) {
	    this.shortDescription = shortDescription;
	}
	
	/**
	 * set detailed description of a category
	 * @param detailedDescription
	 */
	public void setDetailedDescription(String detailedDescription) {
	    this.detailedDescription = detailedDescription;
	}
	
}
