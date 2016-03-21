package facade;
import manager.ProductManager;


public class SellerFacade {

	// manager des Produits
	private ProductManager manProd;
	
	//initialisation du manager
	public SellerFacade() {
		this.manProd = new ProductManager();
	}
	
	public boolean createProduct(String name, String nomSeller ,String nomSubCategory) {
		return this.manProd.createProduct(name,  nomSeller, nomSubCategory);
	}
	
}
