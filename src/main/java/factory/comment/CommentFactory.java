package factory.comment;

import model.activity.Activity;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;
import model.person.User;

public class CommentFactory extends AbstractCommentFactory{
	
	public Comment createComment() {
		return new CommentJDBC();
	}
	
	public Comment createComment(String content, String postingDate){
		return new CommentJDBC(content,postingDate);
	}
	
	public Comment createComment(String content, String postingDate, Activity activity) {
		return new CommentJDBC(content,postingDate,activity);
	}
	
	public Comment createComment(String content, String postingDate, User user) {
		return new CommentJDBC(content,postingDate,user);
	}
	
	public Comment createComment(String content, String postingDate, Activity activity, User user) {
		return new CommentJDBC(content,postingDate,activity,user);
	}

}
