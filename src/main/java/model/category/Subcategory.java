package model.category;

import java.util.List;

import model.person.Person;

public abstract class Subcategory {

	protected String name;
	protected String shortDescription;
	protected String detailedDescription;
	protected Category category;
	
	public Subcategory() {}
	
	public Subcategory(Category c) {
		this.category = c;
	}
	
	public Subcategory(String name) {
		this.name= name;
	}
	
	public Subcategory(String name, String shortDescription, String detailedDescription, Category category) {
		this.name= name;
		this.shortDescription = shortDescription;
		this.detailedDescription = detailedDescription;
		this.category = category;
	}

	public abstract List<Subcategory> getAllSubcategories();
	public abstract boolean subcategoryExist(String subcatName);
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getShortDescription() {
		return shortDescription;
	}
	public void setShortDescription(String shortDescription) {
		this.shortDescription = shortDescription;
	}
	public String getDetailedDescription() {
		return detailedDescription;
	}
	public void setDetailedDescription(String detailedDescription) {
		this.detailedDescription = detailedDescription;
	}
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}

	public abstract Subcategory readByName();
	public abstract boolean save();
}
