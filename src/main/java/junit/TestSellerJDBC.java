package junit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.person.Seller;
import model.person.User;
import model.person.JDBC.SellerJDBC;
import model.person.JDBC.UserJDBC;

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
		assertEquals(sellerReturn.getPass(),"TESTPassword");
		assertEquals(sellerReturn.getDescription(),"TESTDescription");
		assertEquals(sellerReturn.getSiret(),"TESTSiret");
		assertEquals(sellerReturn.getPhoneNumber(),"TESTPhonenumber");
		assertEquals(sellerReturn.getHouseNumber(),"TESTHousenumber");
		assertEquals(sellerReturn.getStreet(),"TESTStreet");
		assertEquals(sellerReturn.getPostCode(),"TESTPostcode");
		assertEquals(sellerReturn.getMail(),"TESTEmail");
		assertEquals(sellerReturn.getCity(),"TESTCity");
	}
	
	

}
