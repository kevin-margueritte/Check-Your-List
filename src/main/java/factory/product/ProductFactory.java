package factory.product;

import factory.person.PersonFactory;
import model.category.Subcategory;
import model.person.Seller;
import model.product.Product;
import model.product.JDBC.ProductJDBC;

/**
 * to be the intermediary between ProductJDBC and AbstractProductFactory 
 *
 */
public class ProductFactory extends AbstractProductFactory{
	
/*	
	@Override
	public Product createProduct(String name, Seller seller, Subcategory subCategory) {
		return new ProductJDBC(name,seller,subCategory);
	}
*/
	@Override
	public Product createProduct(String name, Seller seller, float price, int quantity, Subcategory subCategory) {
		return new ProductJDBC(name,seller,price,quantity,subCategory);
	}
	

	
	
}
