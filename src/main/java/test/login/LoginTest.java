package test.login;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import UI.LoginUI;

public class LoginTest {
	
	protected LoginUI l;
	
	@Before
	public void setUp() {
		l = new LoginUI();
	}
	 
	@After
	public void tearDown() {
	}

	@Test
	public void test() {
		assertEquals(1, 1);
	}

}
