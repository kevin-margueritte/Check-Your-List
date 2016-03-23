package model.product;

import model.category.Subcategory;
import model.person.Seller;

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

	public Product(int id,String name, Seller seller, Subcategory subCategory) {
		// Start of user code constructor for User)
		this.idProd =id;
		this.name=name;
		this.seller=seller;
		this.subCategory=subCategory;
		
		// End of user code
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
}
