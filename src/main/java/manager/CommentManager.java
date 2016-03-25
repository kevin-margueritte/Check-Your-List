package manager;

import java.util.Calendar;
import java.util.List;

import factory.comment.AbstractCommentFactory;
import factory.comment.CommentFactory;
import model.activity.Activity;
import model.comment.Comment;
import model.comment.JDBC.CommentJDBC;

public class CommentManager {
	
	private AbstractCommentFactory fact;

	public CommentManager() {
		this.fact = new CommentFactory();
	}
	
	public boolean createComment(String content, Activity activity) {
		java.sql.Date date = new java.sql.Date(Calendar.getInstance().getTime().getTime());			
		Comment c = this.fact.createComment(content,date.toString(),activity);		
		return c.addComment();
	}
	
	public List<Comment> getAllComments(Activity a) {
		/*
		Comment comment = this.fact.createComment(); // a vérifier !
		return comment.getAllCommentsByActivity();
		*/
		return a.readAllComments();
	}
	
	
	
	
}
