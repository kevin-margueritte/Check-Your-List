package model.comment;

import java.util.List;

import model.activity.Activity;
import model.person.User;

/**
 *business class of comment 
 *
 */
public abstract class Comment {
	/**
	 * content of comment
	 */
	protected String content;
	/**
	 * postingDate of comment
	 */
	protected String postingDate;
	/**
	 * activity of comment
	 */
	protected Activity activity;
	/**
	 * user of comment
	 */
	protected User user;
	
	/**
	 * constructor of comment
	 */
	public Comment() {}
	
	/**
	 * constructor of comment
	 * @param content
	 * @param postingDate
	 */
	public Comment(String content, String postingDate) {
		this.content = content;
		this.postingDate = postingDate;
	}
	
	/**
	 * constructor of comment
	 * @param content
	 * @param postingDate
	 * @param activity
	 */
	public Comment(String content, String postingDate, Activity activity) {
		this.content = content;
		this.postingDate = postingDate;
		this.activity = activity;
	}
	
	/**
	 * constructor of comment
	 * @param content
	 * @param postingDate
	 * @param user
	 */
	public Comment(String content, String postingDate, User user) {
		this.content = content;
		this.postingDate = postingDate;
		this.user = user;
	}
	
	/**
	 * constructor of comment
	 * @param content
	 * @param postingDate
	 * @param activity
	 * @param user
	 */
	public Comment(String content, String postingDate, Activity activity,User user) {
		this.content = content;
		this.postingDate = postingDate;
		this.activity = activity;
		this.user = user;
	}
	
	/**
	 * get content of a comment 
	 * @return content
	 */
	public String getContent() {
		return this.content;
	}
	
	/**
	 * get posting date of a comment 
	 * @return posting date
	 */
	public String getPostingDate() {
		return this.postingDate;
	}
	
	/**
	 * get activity of a comment
	 * @return activity
	 */
	public Activity getActivity() {
		return this.activity;
	}
	
	/**
	 * get user of a comment
	 * @return user
	 */
	public User getUser() {
		return this.user;
	}
	
	/**
	 * set user of a comment
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * set activity of a comment
	 * @param activity
	 */
	public void setActivity(Activity activity) {
		this.activity = activity;
	}
	
	/**
	 * set content of a comment
	 * @param content
	 */
	public void setContent(String content) {
		this.content = content;
	}
	
	/**
	 * set posting date of a comment
	 * @param postingDate
	 */
	public void setPostingDate(String postingDate) {
		this.postingDate = postingDate;
	}

	/**
	 * add activity comment
	 * @return true if the comment is added else false
	 */
	public abstract boolean addCommentActivity();
	
	/**
	 * add profil comment
	 * @return true if the comment is added else false
	 */
	public abstract boolean addCommentProfil();
	//public abstract List<Comment> getAllCommentsByActivity();
	
}
