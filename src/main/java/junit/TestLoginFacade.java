package junit;

import static org.junit.Assert.assertEquals;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import facade.LoginFacade;

/**
 * Test of LoginFacade
 *
 */
public class TestLoginFacade {
	
	protected LoginFacade l;
	
	@Before
	public void setUp() {
		this.l = new LoginFacade();
	}
	 
	@After
	public void tearDown() {
	}

	@Test
	public void test() {
		assertEquals(this.l.connect("titi", "toto"), true);
	}

}
