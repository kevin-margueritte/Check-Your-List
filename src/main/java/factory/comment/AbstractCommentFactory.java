package factory.comment;

import model.activity.Activity;
import model.comment.Comment;
import model.person.User;

public abstract class AbstractCommentFactory {
	
	public abstract Comment createComment();
	
	public abstract Comment createComment(String content, String postingDate);
	
	public abstract Comment createComment(String content, String postingDate, Activity activity);
	
	public abstract Comment createComment(String content, String postingDate, User user);
	
	public abstract Comment createComment(String content, String postingDate, Activity activity, User user);

}
