package model.person.JDBC;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;


public class UserJDBCTest {
	protected UserJDBC user;
	
	
	@Before
	public void setUp() throws Exception {
		user = new UserJDBC();
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}

	
	@Test
	public void testReadByPseudo(String pseudo) {
		UserJDBC user = new UserJDBC();
		
	}

}
