package factory.product;

import model.product.Product;
import model.product.JDBC.ProductJDBC;

public class ProductFactory extends AbstractProductFactory{

	@Override
	public Product createProduct(String name, int quantity, double price, String id) {
		return new ProductJDBC(name,quantity,price,id);
	}

	
	
}
