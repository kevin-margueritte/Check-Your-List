package model.comment;

import java.util.List;

import model.activity.Activity;

public abstract class Comment {
	protected String content;
	protected String postingDate;
	protected Activity activity;
	
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
	
	public String getContent() {
		return this.content;
	}
	
	public String getPostingDate() {
		return this.postingDate;
	}
	
	public Activity getActivity() {
		return this.activity;
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

	public abstract boolean addComment();
	public abstract List<Comment> getAllCommentsByActivity();
	
}
