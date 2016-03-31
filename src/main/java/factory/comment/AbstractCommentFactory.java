package factory.comment;

import model.activity.Activity;
import model.comment.Comment;
import model.person.User;

/**
 * Use for create instance of comment
 *
 */
public abstract class AbstractCommentFactory {
	
	/**
	 * create a comment
	 * @return comment
	 */
	public abstract Comment createComment();
	
	/**
	 * create a comment
	 * @param content of the comment 
	 * @param postingDate of the comment 
	 * @return comment
	 */
	public abstract Comment createComment(String content, String postingDate);
	
	/**
	 * create a activity comment
	 * @param content of the comment 
	 * @param postingDate of the comment 
	 * @param activity of the comment 
	 * @return comment
	 */
	public abstract Comment createComment(String content, String postingDate, Activity activity);
	
	/**
	 * create a user comment
	 * @param content of the comment 
	 * @param postingDate of the comment 
	 * @param user of the comment 
	 * @return comment of the comment 
	 */
	public abstract Comment createComment(String content, String postingDate, User user);
	
	/**
	 * create an activity comment
	 * @param content of the comment 
	 * @param postingDate of the comment 
	 * @param activity of the comment 
	 * @param user of the comment 
	 * @return comment
	 */
	public abstract Comment createComment(String content, String postingDate, Activity activity, User user);

}
