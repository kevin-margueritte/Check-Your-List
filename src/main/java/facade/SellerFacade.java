package facade;
import manager.ProductManager;


public class SellerFacade {

	// manager des Produits
	private manProd ProductManager;
	
	//initialisation du manager
	public SellerFacade() {
		this.manProd = new ProductManager();
	}
	
	public boolean createProduct(String name, int quantity, double price, String id) {
		return this.manProd.createProduct(name, quantity, price, id);
	}
	
}
