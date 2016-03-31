package model.product;

import java.util.List;

import model.category.Subcategory;
import model.person.Seller;

/**
 *business class of activity 
 *
 */
public abstract class Product {

	/**
	 * id of product
	 */
	protected int idProd;
	/***
	 * name of product
	 */
	protected String name;
	/***
	 * seller of the product
	 */
	protected Seller seller;
	/***
	 * sub-category of the product
	 */
	protected Subcategory subCategory;
	/***
	 * price of the product
	 */
	protected float price;
	/***
	 * quantity of the product
	 */
	protected int quantity;
	
	
	/**
	 *constructor of product.
	 */
	public Product(String name, Seller seller, Subcategory subCategory) {
		// Start of user code constructor for User)
		this.name=name;
		this.seller=seller;
		this.subCategory=subCategory;
		
		// End of user code
	}
	
	/**
	 * constructor of product
	 */
	public Product(){
		super();
	}
	
	/**
	 * constructor of product
	 * @param sub
	 */
	public Product(Subcategory sub){
		super();
		this.subCategory = sub;
	}

	/**
	 * constructor of product
	 * @param id
	 * @param name
	 * @param seller
	 * @param subCategory
	 */
	public Product(int id,String name, Seller seller, Subcategory subCategory) {
		// Start of user code constructor for User)
		this.idProd =id;
		this.name=name;
		this.seller=seller;
		this.subCategory=subCategory;
		
		// End of user code
	}

	/**
	 * constructor of product
	 * @param name
	 * @param seller
	 * @param price
	 * @param quantity
	 * @param subCategory
	 */
	public Product(String name, Seller seller, float price, int quantity, Subcategory subCategory) {
		// TODO Auto-generated constructor stub
		this.name=name;
		this.seller=seller;
		this.price=price;
		this.quantity=quantity;
		this.subCategory=subCategory;
	}

	/**
	 * get id of product
	 * @return id
	 */
	public int getIdProd() {
		return idProd;
	}

	/**
	 * set id of product
	 * @param id
	 */
	public void setIdProd(int idProd) {
		this.idProd = idProd;
	}

	/**
	 * get name of product
	 * @return name
	 */
	public String getName() {
		return name;
	}

	/**
	 * set name of product
	 * @param name
	 */
	public void setName(String name) {
		this.name = name;
	}


	/**
	 * get seller of product
	 * @return seller
	 */
	public Seller getSeller() {
		return seller;
	}

	/**
	 * set seller of product
	 * @param seller
	 */
	public void setSeller(Seller seller) {
		this.seller = seller;
	}

	/**
	 * get sub-category of product
	 * @return sub-category
	 */
	public Subcategory getSubCategory() {
		return subCategory;
	}

	/**
	 * set sub-category of product
	 * @param subCategory
	 */
	public void setSubCategory(Subcategory subCategory) {
		this.subCategory = subCategory;
	}

	/**
	 * save product on the DB
	 * @return true if the product is saved
	 */
	public abstract boolean save();
	
	/**
	 * delete a product
	 * @return true if the product is deleted
	 */
	public abstract boolean delete();
	
	/**
	 * get product of seller
	 * @return product
	 */
	public abstract Product readByNameAndSeller();

	/**
	 * get all products of sub-category
	 * @return
	 */
	public abstract List<Product> getAllProductFromSubCategory();
	
	/**
	 * update quantity of product
	 * @param qty
	 * @return true if the quantity is updated else false
	 */
	public abstract boolean majQuantity(int qty);
	
	/**
	 * get all products of a sub-category
	 * @return list of products
	 */
	public abstract List<Product> getAllProductFromSubCategoryAndNoPresentTask();
	
	/**
	 * update price of a product
	 * @param price
	 * @return true if the price is updated else false
	 */
	public abstract boolean majPrice(float price);
	
	/**
	 * update name of product
	 * @param name
	 * @return true if the name is updated else false
	 */
	public abstract boolean majName(String name);

	/**
	 * get price of product
	 * @return
	 */
	public float getPrice() {
		return price;
	}

	/**
	 * set price of product
	 * @param price
	 */
	public void setPrice(float price) {
		this.price = price;
	}

	/**
	 * get quantity of product
	 * @return quantity
	 */
	public int getQuantity() {
		return quantity;
	}

	/**
	 * set quantity of product
	 * @param quantity
	 */
	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}
	
}
