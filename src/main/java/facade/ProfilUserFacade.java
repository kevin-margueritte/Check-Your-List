package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CommentManager;
import manager.PersonManager;
import model.activity.Activity;
import model.comment.Comment;
import model.person.User;

public class ProfilUserFacade {
	
	private ActivityManager am;
	private PersonManager pm;
	private CommentManager ctm;

	
	public ProfilUserFacade() {
		this.am = new ActivityManager();
		this.pm = new PersonManager();
	}
	
	public List<Activity> getAllActivities(User u) {
		return this.pm.getAllActivities(u);
	}
	
	public boolean deleteActivity(Activity act) {
		return this.pm.deleteByPseudoUserAndName(act);
	}
	
	public boolean createComment(String content, User user) {
		return this.ctm.createCommentProfil(content, user);
	}
	
	public List<Comment> getAllComments(User u) {
		return this.ctm.getAllCommentsUser(u);
	}

}
