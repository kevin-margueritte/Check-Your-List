package factory.product;

import model.category.Subcategory;
import model.person.Seller;
import model.product.Product;

public abstract class AbstractProductFactory {

	public abstract Product createProduct(String name, Seller seller,Subcategory subCategory);
	
	
}
