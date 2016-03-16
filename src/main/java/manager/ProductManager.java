package manager;
import factory.product.AbstractProductFactory;
import factory.product.ProductFactory;
import model.product.Product;
import model.product.JDBC.ProductJDBC;

public class ProductManager {

	private AbstractProductFactory fact;
	
	
	public ProductManager() {
		this.fact = new ProductFactory();
	}
	
	public boolean createProduct(String name, int quantity, double price, String id){
		Product prod = this.fact.createProduct(name, quantity, price, id);
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
