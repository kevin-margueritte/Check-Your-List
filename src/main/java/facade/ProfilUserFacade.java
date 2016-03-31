package facade;

import java.util.List;

import manager.ActivityManager;
import manager.CommentManager;
import manager.PersonManager;
import model.activity.Activity;
import model.comment.Comment;
import model.person.User;

/**
 * to be the intermediary between ProfilUserManager and UI user class
 *
 */
public class ProfilUserFacade {
	/**
	 * Description of the property userUIs.
	 */
	private ActivityManager am;
	private PersonManager pm;
	private CommentManager ctm;

	/**
	 * constructor of ProfilUserFacade
	 */
	public ProfilUserFacade() {
		this.am = new ActivityManager();
		this.pm = new PersonManager();
	}
	
	/**
	 * get all activities of a user
	 * @param uset
	 * @return list of activities
	 */
	public List<Activity> getAllActivities(User u) {
		return this.pm.getAllActivities(u);
	}
	
	/**
	 * delete an activity
	 * @param activity
	 * @return true if the activity is deleted else false
	 */
	public boolean deleteActivity(Activity act) {
		return this.pm.deleteByPseudoUserAndName(act);
	}
	
	/**
	 * create a new user comment
	 * @param content of the comment
	 * @param user
	 * @return true if the comment is created else false
	 */
	public boolean createComment(String content, User user) {
		return this.ctm.createCommentProfil(content, user);
	}
	
	/**
	 * get all comments of a user
	 * @param user
	 * @return list of comments
	 */
	public List<Comment> getAllComments(User u) {
		return this.ctm.getAllCommentsUser(u);
	}

}
