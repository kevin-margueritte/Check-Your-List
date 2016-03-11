package model.product;

public abstract class Product {

	/***
	 * name of product
	 */
	protected String name;
	
	
	/***
	 * quantity offered by the seller
	 */
	protected int quantity;
	
	
	/***
	 * price of one product
	 */
	protected double price;
	
	
	/***
	 * id of the product
	 */
	protected String id;
	
	
	
	//protected SubCategory subCategoryProduct;
	
	//protected Category categoryProduct;
	
	
	
	/**
	 * The constructor.
	 */
	public Product(String name, int quantity, double price, String id) {
		// Start of user code constructor for User)
		this.name=name;
		this.quantity= quantity;
		this.price=price;
		this.id=id;
		// End of user code
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}
	
	
	
}
