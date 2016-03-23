package manager;
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
		return null;
	}
	
	/* obsol�te
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
		//recup�re le Seller a partir du pseudo
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
	
	
	/*
	public boolean deleteProduct(String name, String pseudo, String nomSubCategory){
				Seller seller = recupereSeller(pseudo);
		if (seller==null){
			return false;
		}
			
		//recupere la sub category
		Subcategory subCategoryProd = this.factCat.createSubcategory(nomSubCategory);
		subCategoryProd.readByName();

		// Creation du produit 
		Product prod = this.factProd.createProduct(name, seller,subCategoryProd);
		prod.readByNameAndSeller();
		if(prod != null){
			return prod.delete();
		}
		return false;
	}*/
	
	



}
