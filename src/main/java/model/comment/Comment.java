package model.comment;

import java.util.List;

import model.activity.Activity;
import model.person.User;

public abstract class Comment {
	protected String content;
	protected String postingDate;
	protected Activity activity;
	protected User user;
	
	public Comment() {}
	
	public Comment(String content, String postingDate) {
		this.content = content;
		this.postingDate = postingDate;
	}
	
	public Comment(String content, String postingDate, Activity activity) {
		this.content = content;
		this.postingDate = postingDate;
		this.activity = activity;
	}
	
	public Comment(String content, String postingDate, User user) {
		this.content = content;
		this.postingDate = postingDate;
		this.user = user;
	}
	
	public Comment(String content, String postingDate, Activity activity,User user) {
		this.content = content;
		this.postingDate = postingDate;
		this.activity = activity;
		this.user = user;
	}
	
	public String getContent() {
		return this.content;
	}
	
	public String getPostingDate() {
		return this.postingDate;
	}
	
	public Activity getActivity() {
		return this.activity;
	}
	
	public User getUser() {
		return this.user;
	}
	
	public void setUser(User user) {
		this.user = user;
	}
	
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	public void setContent(String content) {
		this.content = content;
	}
	
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	public abstract boolean addCommentActivity();
	public abstract boolean addCommentProfil();
	//public abstract List<Comment> getAllCommentsByActivity();
	
}
