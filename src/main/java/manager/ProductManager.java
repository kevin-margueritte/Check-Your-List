package manager;
import factory.category.AbstractCategoryFactory;
import factory.category.CategoryFactory;
import factory.person.AbstractPersonFactory;
import factory.person.PersonFactory;
import factory.product.AbstractProductFactory;
import factory.product.ProductFactory;
import model.category.Subcategory;
import model.person.Seller;
import model.person.User;
import model.product.Product;
import model.category.JDBC.SubcategoryJDBC;


public class ProductManager {
	private AbstractPersonFactory factPers;
	private AbstractProductFactory factProd;
	private AbstractCategoryFactory factCat;
	
	
	public ProductManager() {
		this.factProd = new ProductFactory();
		this.factCat = new CategoryFactory();
		this.factPers = new PersonFactory();
	}
	
	public boolean createProduct(String name, String pseudo, String nomSubCategory){
		//recupère le Seller a partir du pseudo
		Seller seller = this.factPers.createSeller(pseudo);
		seller.readByPseudo();
		
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
	
	
	public boolean deleteProduct(Product prod){
		return prod.delete();
		
		
	}
	
	
	public boolean setQuantity(int nbreajout){
		return false;	
	}
	
	public static void main(String args[]) {
		ProductManager p = new ProductManager();
		//p.createProduct("Whisky","aezr","cat2");
	}

}
