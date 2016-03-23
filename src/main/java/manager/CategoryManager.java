package manager;

import java.util.List;

import factory.category.AbstractCategoryFactory;
import factory.category.CategoryFactory;
import model.category.Category;
import model.category.Subcategory;
import model.category.JDBC.CategoryJDBC;
import model.category.JDBC.SubcategoryJDBC;

public class CategoryManager {
	
	private AbstractCategoryFactory fact;
	
	public CategoryManager() {
		this.fact = new CategoryFactory();
	}
	
	public Category getCategory(String name) {
		Category c = this.fact.createCategory(name);
		((CategoryJDBC)c).readByName();
		return c;
	}
	
	public boolean createCategory(String name, String shortDescription, String detailedDescription) {
		boolean res = false;
		Category c = this.fact.createCategory(name, shortDescription, detailedDescription);
		res = ((CategoryJDBC)c).save();
		return res;
	}
	
	public Subcategory getSubcategory(String name) {
		Subcategory c = this.fact.createSubcategory(name);
		((SubcategoryJDBC)c).readByName();
		return c;
	}
	
	public boolean createCategory(String name, String shortDescription, String detailedDescription, Category category) {
		boolean res = false;
		Subcategory c = this.fact.createSubcategory(name, shortDescription, detailedDescription, category);
		res = ((SubcategoryJDBC)c).save();
		return res;
	}
	
	public List<Category> getAllCategories() {
		Category cat = this.fact.createCategory();
		return cat.getAllCategories();
	}
	
	public boolean categoryExist(String catName) {
		Category cat = this.fact.createCategory();
		return cat.categoryExist(catName);
	}
	
	public List<Subcategory> getAllSubcategories(Category category) {
		Subcategory subcat = this.fact.createSubcategory(category);
		return subcat.getAllSubcategories();
	}
	
	public boolean subcategoryExist(String subcatName) {
		Subcategory subcat = this.fact.createSubcategory();
		return subcat.subcategoryExist(subcatName);
	}

}
