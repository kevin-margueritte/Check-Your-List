package manager;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import factory.person.AbstractPersonFactory;
import factory.person.PersonFactory;
import model.activity.Activity;
import model.person.Person;
import model.person.Seller;
import model.person.User;

public class PersonManager {
	
	private AbstractPersonFactory fact;
	
	public PersonManager() {
		this.fact = new PersonFactory();
	}
	
	public boolean connect(String username, String password) {
		User u = this.fact.createUser(username);
		Seller l = this.fact.createSeller(username);
		l.readByPseudo();
		u.readByPseudo();
		try {
			if (u.getPassword().equals(sha1(password)) || l.getPassword().equals(sha1(password))) {
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
	
	public boolean createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		boolean res = false;
		try {
			User u = this.fact.createUser(pseudo, lastName, firstName, description, sha1(password), city, postCode, street, houseNumber, mail);
			res = u.save();
		} catch (NoSuchAlgorithmException e) {}
		return res;
	}
	
	public boolean createSeller(String pseudo, String lastName, String firstName, String description, String password,
			String siret, String phoneNumber, String houseNumber, String street, String postCode, String mail,
			String city) {
			boolean res = false;
			try {
				Seller u = this.fact.createSeller(pseudo, lastName, firstName, description, sha1(password),
						siret, phoneNumber, houseNumber, street, postCode, mail,
						city);
				res = u.save();
			} catch (NoSuchAlgorithmException e) {}
		return res;
	}
	
	private static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
	
	public List<Activity> getAllActivities(User u) {
		return u.readAllActivities();
	}
	
	public boolean deleteByPseudoUserAndName(Activity act) {
		return act.deleteByPseudoUserAndName();
	}

}
