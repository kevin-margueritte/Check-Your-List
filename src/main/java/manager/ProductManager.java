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


public class ProductManager {
	private AbstractPersonFactory factPers;
	private AbstractProductFactory factProd;
	private AbstractCategoryFactory factCat;
	
	
	public ProductManager() {
		this.factProd = new ProductFactory();
		this.factCat = new CategoryFactory();
		this.factPers = new PersonFactory();
	}
	
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
	
	public boolean createProduct(String name, Seller seller, float price, int quantity, Subcategory subCategory) {	
		// Creation du produit 
		Product prod = this.factProd.createProduct(name, seller, price, quantity,subCategory);
		if(prod != null){
			return prod.save();
		}
		return false;
	}
	
	public boolean deleteProduct(Product prod){
		return prod.delete();
	}
	
	public List<Product> getAllProductsFromSubCategory(Subcategory sub) {
		Product prod = new ProductJDBC(sub);
		try {
			return prod.getAllProductFromSubCategory();
		}
		catch (NullPointerException n) {
			return new ArrayList<Product>();
		}
	}

}
