package manager;

import java.util.Calendar;
import java.util.List;

import factory.comment.AbstractCommentFactory;
import factory.comment.CommentFactory;
import model.activity.Activity;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;
import model.person.User;

public class CommentManager {
	
	private AbstractCommentFactory fact;

	public CommentManager() {
		this.fact = new CommentFactory();
	}
	
	public boolean createCommentActivity(String content, Activity activity,User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());			
		Comment c = this.fact.createComment(content,date.toString(),activity,user);		
		return c.addCommentActivity();
	}
	
	public List<Comment> getAllCommentsActivity(Activity a) {
		/*
		Comment comment = this.fact.createComment(); // a vérifier !
		return comment.getAllCommentsByActivity();
		*/
		return a.readAllComments();
	}
	
	public boolean createCommentProfil(String content, User user) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());			
		Comment c = this.fact.createComment(content,date.toString(),user);		
		return c.addCommentProfil();
	}
	
	public List<Comment> getAllCommentsUser(User u) {
		return u.readAllComments();
	}
	
	
	
}
