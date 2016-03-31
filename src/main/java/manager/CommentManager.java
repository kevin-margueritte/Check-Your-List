package manager;

import java.util.Calendar;
import java.util.List;

import factory.comment.AbstractCommentFactory;
import factory.comment.CommentFactory;
import model.activity.Activity;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;
import model.person.User;

/**
 * to be the intermediary between AbstractCommentFactory and  CommentFacade
 *
 */
public class CommentManager {
	
	private AbstractCommentFactory fact;

	/**
	 * constructor of CommentManager
	 */
	public CommentManager() {
		this.fact = new CommentFactory();
	}
	
	/**
	 * create an activity comment 
	 * @param content of the comment
	 * @param activity of the comment
	 * @param user of the comment
	 * @return true if the comment is created else false
	 */
	public boolean createCommentActivity(String content, Activity activity,User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());			
		Comment c = this.fact.createComment(content,date.toString(),activity,user);		
		return c.addCommentActivity();
	}
	
	/**
	 * get all activity comments
	 * @param activity
	 * @return list of comments
	 */
	public List<Comment> getAllCommentsActivity(Activity a) {
		/*
		Comment comment = this.fact.createComment(); // a vérifier !
		return comment.getAllCommentsByActivity();
		*/
		return a.readAllComments();
	}
	
	/**
	 * create profil comment
	 * @param content of comment
	 * @param user
	 * @return true if the comment is created else false
	 */
	public boolean createCommentProfil(String content, User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());			
		Comment c = this.fact.createComment(content,date.toString(),user);		
		return c.addCommentProfil();
	}
	
	/**
	 * get all comments of an user
	 * @param user
	 * @return list of comments
	 */
	public List<Comment> getAllCommentsUser(User u) {
		return u.readAllComments();
	}
	
	
	
}
