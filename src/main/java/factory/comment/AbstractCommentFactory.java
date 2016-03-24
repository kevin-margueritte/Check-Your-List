package factory.comment;

import model.activity.Activity;
import model.comment.Comment;

public abstract class AbstractCommentFactory {
	
	public abstract Comment createComment();
	
	public abstract Comment createComment(String content, String postingDate);
	
	public abstract Comment createComment(String content, String postingDate, Activity activity);

}
