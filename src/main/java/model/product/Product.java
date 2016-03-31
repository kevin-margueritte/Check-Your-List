package model.product;

import java.util.List;

import model.category.Subcategory;
import model.person.Seller;

/**
 * 
 *
 */
public abstract class Product {

	
	protected int idProd;
	/***
	 * name of product
	 */
	protected String name;
	/***
	 * id of the product
	 */
	protected Seller seller;
	
	protected Subcategory subCategory;
	
	protected float price;
	
	protected int quantity;
	
	
	/**
	 * The constructor.
	 */
	public Product(String name, Seller seller, Subcategory subCategory) {
		// Start of user code constructor for User)
		this.name=name;
		this.seller=seller;
		this.subCategory=subCategory;
		
		// End of user code
	}
	
	public Product(){
		super();
	}
	
	public Product(Subcategory sub){
		super();
		this.subCategory = sub;
	}

	public Product(int id,String name, Seller seller, Subcategory subCategory) {
		// Start of user code constructor for User)
		this.idProd =id;
		this.name=name;
		this.seller=seller;
		this.subCategory=subCategory;
		
		// End of user code
	}


	public Product(String name, Seller seller, float price, int quantity, Subcategory subCategory) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.seller=seller;
		this.price=price;
		this.quantity=quantity;
		this.subCategory=subCategory;
	}

	public int getIdProd() {
		return idProd;
	}

	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}


	public Seller getSeller() {
		return seller;
	}


	public void setSeller(Seller seller) {
		this.seller = seller;
	}


	public Subcategory getSubCategory() {
		return subCategory;
	}


	public void setSubCategory(Subcategory subCategory) {
		this.subCategory = subCategory;
	}

	public abstract boolean save();
	public abstract boolean delete();
	public abstract Product readByNameAndSeller();
	public abstract List<Product> getAllProductFromSubCategory();
	public abstract boolean majQuantity(int qty);
	public abstract List<Product> getAllProductFromSubCategoryAndNoPresentTask();
	public abstract boolean majPrice(float price);
	public abstract boolean majName(String name);

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
