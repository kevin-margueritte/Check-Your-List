package facade;
import java.util.List;

import manager.CategoryManager;
import manager.ProductManager;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;

/**
 * to be the intermediary between personManager and UI seller class
 *
 */
public class SellerFacade {

	/**
	 * Description of the property sellerUIs.
	 */
	private ProductManager manProd;
	private CategoryManager cm;

	/**
	 * constructor of SellerFacade
	 */
	public SellerFacade() {
		this.manProd = new ProductManager();
		this.cm = new CategoryManager();
	}
	
	
	/* obsolète
	public boolean createProduct(String name, String nomSeller ,String nomSubCategory) {
		return this.manProd.createProduct(name,  nomSeller, nomSubCategory);
	}
	*/
	
	/*
	public boolean deleteProduct(String name, String nomSeller ,String nomSubCategory) {
		return this.manProd.deleteProduct(name,  nomSeller, nomSubCategory);
	}
	*/
	
	/**
	 * get all sub-categories of a category
	 * @param category
	 * @return list of sub-categories
	 */
	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	/**
	 * get all categories
	 * @return list of categories
	 */
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}

	/**
	 * create a product
	 * @param name of product
	 * @param seller of product
	 * @param price of product
	 * @param quantity of product
	 * @param subCategory of product
	 * @return true if the product is created else false
	 */
	public boolean createProduct(String name, Seller seller, float price, int quantity,
			Subcategory subCategory) {
			return this.manProd.createProduct(name, seller, price, quantity, subCategory);
	}
}
