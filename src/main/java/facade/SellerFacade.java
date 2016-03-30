package facade;
import java.util.List;

import manager.CategoryManager;
import manager.ProductManager;
import model.category.Category;
import model.category.Subcategory;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;


public class SellerFacade {

	// manager des Produits
	private ProductManager manProd;
	private CategoryManager cm;
	//initialisation du manager
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
	
	public List<Subcategory> getAllSubcategories(Category c) {
		return this.cm.getAllSubcategories(c);
	}
	
	public List<Category> getAllCategories() {
		return this.cm.getAllCategories();
	}

	public boolean createProduct(String name, Seller seller, float price, int quantity,
			Subcategory subCategory) {
			return this.manProd.createProduct(name, seller, price, quantity, subCategory);
	}
}
