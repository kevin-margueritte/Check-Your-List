package model.category;

import java.util.List;

/**
 *business class of sub-category 
 *
 */
public abstract class Subcategory {

	/**
	 * name of Subcategory
	 */
	protected String name;
	/**
	 * shortDescription of Subcategory
	 */
	protected String shortDescription;
	/**
	 * detailedDescription of Subcategory
	 */
	protected String detailedDescription;
	/**
	 * category of Subcategory
	 */
	protected Category category;
	
	/**
	 * constructor of sub-category
	 */
	public Subcategory() {}
	
	/**
	 * constructor of sub-category
	 * @param category
	 */
	public Subcategory(Category c) {
		this.category = c;
	}
	
	/**
	 * constructor of sub-category
	 * @param name
	 */
	public Subcategory(String name) {
		this.name= name;
	}
	
	/**
	 * constructor of sub-category
	 * @param name
	 * @param shortDescription
	 * @param detailedDescription
	 * @param category
	 */
	public Subcategory(String name, String shortDescription, String detailedDescription, Category category) {
		this.name= name;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.category = category;
	}

	/**
	 * get all sub-categories
	 * @return list of sub-categories
	 */
	public abstract List<Subcategory> getAllSubcategories();
	
	/**
	 * find if the sub-category exist
	 * @param Name of the sub-category
	 * @return true if sub-category exist else false
	 */
	public abstract boolean subcategoryExist(String subcatName);
	
	/**
	 * get name of a sub-category
	 * @return name
	 */
	public String getName() {
		return name;
	}
	
	/**
	 * set name of a sub-category
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}
	
	/**
	 * get Short Description of a sub-category
	 * @return
	 */
	public String getShortDescription() {
		return shortDescription;
	}
	
	/**
	 * set Short Description of a sub-category
	 * @param shortDescription
	 */
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	
	/**
	 * get detailed description of a sub-category
	 * @return detailed description
	 */
	public String getDetailedDescription() {
		return detailedDescription;
	}
	
	/**
	 * set detailed description of a sub-category
	 * @param detailedDescription
	 */
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	
	/**
	 * get category of a sub-category
	 * @return category
	 */
	public Category getCategory() {
		return category;
	}
	
	/**
	 * set category of a sub-category
	 * @param category
	 */
	public void setCategory(Category category) {
		this.category = category;
	}

	/**
	 * get sub-category with its name
	 * @return sub-category
	 */
	public abstract Subcategory readByName();
	
	/**
	 * save sub-category on the DB
	 * @return true if the sub-category is saved
	 */
	public abstract boolean save();
}
