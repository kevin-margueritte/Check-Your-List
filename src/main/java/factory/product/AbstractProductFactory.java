package factory.product;

import model.category.Subcategory;
import model.person.Seller;
import model.product.Product;

/**
 * Use for create instance of product
 *
 */
public abstract class AbstractProductFactory {

	//public abstract Product createProduct(String name, Seller seller,Subcategory subCategory);

	/**
	 * create a product
	 * @param name of the product
	 * @param seller of the product
	 * @param price of the product
	 * @param quantity of the product
	 * @param subCategory of the product
	 * @return product
	 */
	public abstract Product createProduct(String name, Seller seller, float price, int quantity, Subcategory subCategory);
	
	
}
