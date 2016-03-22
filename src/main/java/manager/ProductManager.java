package manager;
import factory.category.AbstractCategoryFactory;
import factory.person.AbstractPersonFactory;
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
	}
	
	public boolean createProduct(String name, String pseudo, String nomSubCategory){
		//recupère le Seller
		Seller seller = factPers.createSeller(pseudo);
		seller.readByPseudo();
		//recupere la sub category
		Subcategory subCategory = factCat.createSubcategory(nomSubCategory);
		subCategory.readByName();
		// Creation du produit 
		Product prod = this.factProd.createProduct(name, seller,subCategory);
		if(prod != null){
			return true;
		}
		return false;
	}
	
	
	public boolean deleteProduct(){
		return false;
		
	}
	
	
	public boolean setQuantity(int nbreajout){
		return false;	
	}

}
