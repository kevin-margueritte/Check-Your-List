package factory.product;

import model.product.Product;

public abstract class AbstractProductFactory {

	public abstract Product createProduct(String name, int quantity, double price, String id);
	

}
