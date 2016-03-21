package facade;
import manager.ProductManager;
import model.person.Seller;
import model.person.JDBC.SellerJDBC;


public class SellerFacade {

	// manager des Produits
	private ProductManager manProd;
	
	//initialisation du manager
	public SellerFacade() {
		this.manProd = new ProductManager();
	}
	
	public boolean createProduct(String name, int quantity, double price, String id) {
		return this.manProd.createProduct(name, quantity, price, id);
	}
	
}
