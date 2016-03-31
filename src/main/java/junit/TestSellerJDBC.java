package junit;

import static org.junit.Assert.assertEquals;

import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.person.Seller;
import model.person.JDBC.SellerJDBC;

public class TestSellerJDBC {
	
	private SellerJDBC seller;

	@Before
	public void setUp() throws Exception {
		this.seller = new SellerJDBC();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readByPseudoTest() {
		this.seller.setPseudo("TESTSeller");
		Seller sellerReturn = this.seller.readByPseudo();
		assertEquals(sellerReturn.getFirstname(),"TESTFirstname");
		assertEquals(sellerReturn.getLastname(),"TESTLastname");
		assertEquals(sellerReturn.getPseudo(),"TESTSeller");
		assertEquals(sellerReturn.getDescription(),"TESTDescription");
		assertEquals(sellerReturn.getSiret(),"TESTSiret");
		assertEquals(sellerReturn.getPhoneNumber(),"TESTPhonenumber");
		assertEquals(sellerReturn.getHouseNumber(),"TESTHousenumber");
		assertEquals(sellerReturn.getStreet(),"TESTStreet");
		assertEquals(sellerReturn.getPostCode(),"TESTPostcode");
		assertEquals(sellerReturn.getMail(),"TESTEmail");
		assertEquals(sellerReturn.getCity(),"TESTCity");
	}
	
	
	@Test
	public void pseudoExist() {
		this.seller.setPseudo("TESTSeller");
		assertEquals(true, this.seller.pseudoExist());
		
		Random rand = new Random();
		this.seller.setPseudo(rand.nextInt((10000 - 0) + 1) + 0+ "");
		assertEquals(false, this.seller.pseudoExist());
	}
	
}
