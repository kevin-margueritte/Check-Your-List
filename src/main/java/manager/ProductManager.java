package manager;
import java.util.ArrayList;
import java.util.List;

import factory.category.AbstractCategoryFactory;
import factory.category.CategoryFactory;
import factory.person.AbstractPersonFactory;
import factory.person.PersonFactory;
import factory.product.AbstractProductFactory;
import factory.product.ProductFactory;
import model.category.Subcategory;
import model.person.Seller;
import model.product.Product;
import model.product.JDBC.ProductJDBC;

/**
 * to be the intermediary between AbstractProductFactory and  ProductFacade
 *
 */
public class ProductManager {
	private AbstractPersonFactory factPers;
	private AbstractProductFactory factProd;
	private AbstractCategoryFactory factCat;
	
	/**
	 * constructor of ProductManager
	 */
	public ProductManager() {
		this.factProd = new ProductFactory();
		this.factCat = new CategoryFactory();
		this.factPers = new PersonFactory();
	}
	
	/**
	 * get all products of a seller
	 * @param seller
	 * @return list of products
	 */
	public List<Product> getAllProductBySeller(Seller s) {
		return s.readAllProducts();
	}
	
	/* obsolète
	public boolean createProduct(String name, String pseudo, String nomSubCategory){
		Seller seller = recupereSeller(pseudo);
		if (seller==null){
			return false;
		}
			
		//recupere la sub category
		Subcategory subCategoryProd = this.factCat.createSubcategory(nomSubCategory);
		subCategoryProd.readByName();

		// Creation du produit 
		Product prod = this.factProd.createProduct(name, seller,subCategoryProd);
		
		if(prod != null){
			return prod.save();
		}
		return false;
	}
	
	
		public Seller recupereSeller(String pseudo) {
		//recupère le Seller a partir du pseudo
		Seller seller = this.factPers.createSeller(pseudo);
		//verifie que le seller existe
		if (!seller.sellerExist()){
			return null;
		}
		seller.readByPseudo();
		return seller;
	}
	
	*/
	
	/**
	 * create product
	 * @param name of the product
	 * @param seller of the product
	 * @param price of the product
	 * @param quantity of the product
	 * @param subCategory of the product
	 * @return true if the product is created else false
	 */
	public boolean createProduct(String name, Seller seller, float price, int quantity, Subcategory subCategory) {	
		// Creation du produit 
		Product prod = this.factProd.createProduct(name, seller, price, quantity,subCategory);
		if(prod != null){
			return prod.save();
		}
		return false;
	}
	
	/**
	 * delete product
	 * @param product
	 * @return true if the product is deleted
	 */
	public boolean deleteProduct(Product prod){
		return prod.delete();
	}
	
	/**
	 * get all products of a sub-category
	 * @param sub-category
	 * @return list of products
	 */
	public List<Product> getAllProductsFromSubCategory(Subcategory sub) {
		Product prod = new ProductJDBC(sub);
		try {
			return prod.getAllProductFromSubCategory();
		}
		catch (NullPointerException n) {
			return new ArrayList<Product>();
		}
	}
	
	/**
	 * get all products of a sub-category
	 * @param sub-category
	 * @return list of products
	 */
	public List<Product> getAllProductFromSubCategoryAndNoPresentTask(Subcategory sub) {
		Product prod = new ProductJDBC(sub);
		try {
			return prod.getAllProductFromSubCategoryAndNoPresentTask();
		}
		catch (NullPointerException n) {
			return new ArrayList<Product>();
		}
	}

	/**
	 * update quantity of product
	 * @param product
	 * @param qty
	 * @return true if the quantity is updated else false
	 */
	public boolean majQuantity(Product prod, int qty) {
		return prod.majQuantity(qty);
	}
	
	/**
	 * update price of product
	 * @param product
	 * @param price
	 * @return true if the price is updated else false
	 */
	public boolean majPrice(Product prod, float price) {
		return prod.majPrice(price);	
	}
	
	/**
	 * update name of product
	 * @param product
	 * @param name
	 * @return true if the name is updated else false
	 */
	public boolean majName(Product prod, String name) {
		return prod.majName(name);
	}

}
