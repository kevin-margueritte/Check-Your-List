package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import factory.Factory;
import factory.PersonFactoryJDBC;
import person.model.Person;
import person.model.User;

public class ManagePerson {
	
	private Factory fact;
	
	public ManagePerson() {
		this.fact = new PersonFactoryJDBC();
	}
	
	public boolean connect(String username, String password) {
		User u = this.fact.createUser(username);
		u.readByPseudo();
		try {
			if (u.getPassword().equals(sha1(password))) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public Person getPerson(String username) {
		User u = this.fact.createUser(username);
		u.readByPseudo();
		return u;
	}
	
//	public boolean connect(String username, String password) {
//		String sql = ("SELECT * FROM customer WHERE pseudo = '" + username + "' AND pass = '"+ password + "'");
//		Statement stm;
//		try {
//			stm = this.connection.createStatement();
//			ResultSet rs = stm.executeQuery(sql);
//			if ( rs.next() ) {
//				System.out.println("toto");
//				return true;
//			}
//		} catch (SQLException e) {}
//		return false;
//	}
	
	private static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}

}
