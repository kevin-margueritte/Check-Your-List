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

/**
 * to be the intermediary between AbstractPersonFactory and  PersonFacade
 *
 */
public class PersonManager {
	
	private AbstractPersonFactory fact;
	
	/**
	 * constructor of PersonManager
	 */
	public PersonManager() {
		this.fact = new PersonFactory();
	}
	
	/**
	 * connect an user
	 * @param username of the user
	 * @param password of the user
	 * @return true if the user is connected else false
	 */
	public boolean connect(String username, String password) {
		User u = this.fact.createUser(username);
		Seller l = this.fact.createSeller(username);
		l.readByPseudo();
		u.readByPseudo();
		try {
			if ( u.getPassword().equals(sha1(password)) || l.getPassword().equals(sha1(password))) {
				return true;
			}
		} catch (NoSuchAlgorithmException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	/**
	 * get a person
	 * @param username of the person
	 * @return person
	 */
	public Person getPerson(String username) {
		User u = this.fact.createUser(username);
		if (u.pseudoExist()) {
			return u;
		}
		Seller s = this.fact.createSeller(username);
		if (s.pseudoExist()) {
			return s;
		}
		return null;
	}
	
	/**
	 * create an user
	 * @param pseudo of the user
	 * @param lastName of the user
	 * @param firstName of the user
	 * @param description of the user
	 * @param password of the user
	 * @param city of the user
	 * @param postCode of the user
	 * @param street of the user
	 * @param houseNumber of the user
	 * @param mail of the user
	 * @return true if the user is created else false
	 */
	public boolean createUser(String pseudo, String lastName, String firstName, String description, String password,
			String city, String postCode, String street, String houseNumber, String mail) {
		boolean res = false;
		try {
			User u = this.fact.createUser(pseudo, lastName, firstName, description, sha1(password), city, postCode, street, houseNumber, mail);
			res = u.save();
		} catch (NoSuchAlgorithmException e) {}
		return res;
	}
	
	/**
	 * create a seller
	 * @param pseudo of the seller
	 * @param lastName of the seller
	 * @param firstName of the seller
	 * @param description of the seller
	 * @param password of the seller
	 * @param siret of the seller
	 * @param phoneNumber of the seller
	 * @param houseNumber of the seller
	 * @param street of the seller
	 * @param postCode of the seller
	 * @param mail of the seller
	 * @param city of the seller
	 * @return true if the seller is created else false
	 */
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
	
	/**
	 * encode password
	 * @param input
	 * @return encoded password
	 * @throws NoSuchAlgorithmException
	 */
	private static String sha1(String input) throws NoSuchAlgorithmException {
		MessageDigest mDigest = MessageDigest.getInstance("SHA1");
		byte[] result = mDigest.digest(input.getBytes());
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < result.length; i++) {
			sb.append(Integer.toString((result[i] & 0xff) + 0x100, 16).substring(1));
		}

		return sb.toString();
	}
	
	/**
	 * get all activities of an user
	 * @param user
	 * @return list of activities
	 */
	public List<Activity> getAllActivities(User u) {
		return u.readAllActivities();
	}
	
	/**
	 * delete activity 
	 * @param activity
	 * @return true if activity is deleted else false
	 */
	public boolean deleteByPseudoUserAndName(Activity act) {
		return act.deleteByPseudoUserAndName();
	}

}
