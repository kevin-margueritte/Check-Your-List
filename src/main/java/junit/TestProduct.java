package junit;



import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.product.Product;
import model.product.JDBC.ProductJDBC;

public class TestProduct {

	private Product product;
	
	@Before
	public void setUp() throws Exception {
		this.product = (Product) new ProductJDBC();
	}

	@After
	public void tearDown() throws Exception {
	}


	@Test
	public void setPrice() {
		float i = 10;
		this.product.setPrice(i);
		assertEquals(10.0, this.product.getPrice(), 0.0f);	
	}

	@Test
	public void getPrice(){
		this.product.setPrice((float)20.5);	
		float price = this.product.getPrice();
		assertEquals(20.5, price,  0.0f);	
		
	}
	
	@Test
	public void getQuantity() {
		int i = 10;
		this.product.setQuantity(i);
		assertEquals(10, this.product.getPrice(), 0f);	
	}

	@Test
	public void setQuantity(){
		this.product.setQuantity(20);	
		float qty = this.product.getQuantity();
		assertEquals(20, qty,  0f);	
		
	}
	

}
