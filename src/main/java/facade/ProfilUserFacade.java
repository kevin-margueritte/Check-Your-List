package facade;

import java.util.List;

import manager.ActivityManager;
import model.activity.Activity;
import model.person.User;

public class ProfilUserFacade {
	
	private ActivityManager am;
	
	public ProfilUserFacade() {
		this.am = new ActivityManager();
	}
	
	public List<Activity> getAllActivities(User u) {
		return this.am.getAllActivities(u);
	}
	
	public boolean deleteActivity(Activity act) {
		return this.am.deleteByPseudoUserAndName(act);
	}

}
