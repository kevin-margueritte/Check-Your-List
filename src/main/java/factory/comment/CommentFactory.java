package factory.comment;

import model.activity.Activity;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;
import model.person.User;

/**
 * to be the intermediary between CommentJDBC and AbstractCommentFactory 
 *
 */
public class CommentFactory extends AbstractCommentFactory{
	
	@Override
	public Comment createComment() {
		return new CommentJDBC();
	}
	
	@Override
	public Comment createComment(String content, String postingDate){
		return new CommentJDBC(content,postingDate);
	}
	
	@Override
	public Comment createComment(String content, String postingDate, Activity activity) {
		return new CommentJDBC(content,postingDate,activity);
	}
	
	@Override
	public Comment createComment(String content, String postingDate, User user) {
		return new CommentJDBC(content,postingDate,user);
	}
	
	@Override
	public Comment createComment(String content, String postingDate, Activity activity, User user) {
		return new CommentJDBC(content,postingDate,activity,user);
	}

}
