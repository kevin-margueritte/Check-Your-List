package factory.activity;

import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.category.Subcategory;
import model.person.User;

/**
 * to be the intermediary between ActivityJDBC and AbstractActivityFactory 
 *
 */
public class ActivityFactory extends AbstractActivityFactory{

	@Override
	public Activity createActivity() {
		// TODO Auto-generated method stub
		return new ActivityJDBC();
	}

	@Override
	public Activity createActivity(String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user) {
		// TODO Auto-generated method stub
		return new ActivityJDBC(title, description, visible, creationDate, subcategory, user);
	}

	@Override
	public Activity createActivity(int id, String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user) {
		// TODO Auto-generated method stub
		return new ActivityJDBC(id, title, description, visible, creationDate, subcategory, user);
	}

	@Override
	public Activity createActivity(User u) {
		return new ActivityJDBC(u);
	}

}
