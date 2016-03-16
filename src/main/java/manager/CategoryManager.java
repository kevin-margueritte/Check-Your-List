package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import factory.category.AbstractCategoryFactory;
import factory.category.CategoryFactory;
import model.category.Category;
import model.category.JDBC.CategoryJDBC;

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

}
