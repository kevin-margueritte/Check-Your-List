package facade;

import java.util.List;

import manager.ActivityManager;
import manager.PersonManager;
import model.activity.Activity;
import model.person.User;

public class ProfilUserFacade {
	
	private ActivityManager am;
	private PersonManager pm;
	
	public ProfilUserFacade() {
		this.am = new ActivityManager();
	}
	
	public List<Activity> getAllActivities(User u) {
		return this.pm.getAllActivities(u);
	}
	
	public boolean deleteActivity(Activity act) {
		return this.pm.deleteByPseudoUserAndName(act);
	}

}
