package manager;

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
	
	public boolean createComment(String content, String postingDate, Activity activity) {
		boolean res = false;
		Comment c = this.fact.createComment(content,postingDate,activity);
		res = ((CommentJDBC)c).addComment();
		return res;
	}
	
	public List<Comment> getAllComments(Activity a) {
		/*
		Comment comment = this.fact.createComment(); // a vérifier !
		return comment.getAllCommentsByActivity();
		*/
		return a.readAllComments();
	}
	
	
	
	
}
