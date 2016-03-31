package junit;

import static org.junit.Assert.assertEquals;

import java.util.List;
import java.util.Random;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import model.activity.Activity;
import model.person.User;
import model.person.JDBC.UserJDBC;

public class TestUserJDBC {
	
	private UserJDBC user;

	@Before
	public void setUp() throws Exception {
		this.user = new UserJDBC();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void readByPseudoTest() {
		this.user.setPseudo("TESTUser");
		User userReturn = this.user.readByPseudo();
		assertEquals(userReturn.getPseudo(),"TESTUser");
		assertEquals(userReturn.getCity(),"TESTCity");
		assertEquals(userReturn.getPostCode(),"TESTPostcode");
		assertEquals(userReturn.getStreet(),"TESTStreet");
		assertEquals(userReturn.getHouseNumber(),"TESTHousenumber");
	}
	
	@Test
	public void pseudoExist() {
		this.user.setPseudo("TESTUser");
		assertEquals(true, this.user.pseudoExist());
		
		Random rand = new Random();
		this.user.setPseudo(rand.nextInt((10000 - 0) + 1) + 0+ "");
		assertEquals(false, this.user.pseudoExist());
	}

	@Test
	public void saveTest() {
		Random rand = new Random();
		this.user = new UserJDBC(rand.nextInt((100000 - 0) + 1) + 0+"", "", "", "", "", "", "", "", "", "");
		assertEquals(true, this.user.save());
	}
	
	@Test
	public void readAllActivitiesTest() {
		this.user.setPseudo("TESTUser");
		List<Activity> list = this.user.readAllActivities();
		assertEquals(2, list.size());
	}
}
