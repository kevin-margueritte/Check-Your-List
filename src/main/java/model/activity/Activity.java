package model.activity;

import java.util.List;

import model.category.Subcategory;
import model.comment.Comment;
import model.person.User;
import model.task.Task;

/**
 *business class of activity 
 *
 */
public abstract class Activity {

	/**
	 * id of activity
	 */
	protected int id;
	/**
	 * title of activity
	 */
	protected String title;
	/**
	 * description of activity
	 */
	protected String description;
	/**
	 * activity visible or not
	 */
	protected boolean visible;
	/**
	 * creationDate of activity
	 */
	protected String creationDate;
	/**
	 * listTask of activity
	 */
	protected List<Task> listTask;
	/**
	 * subcategory of activity
	 */
	protected Subcategory subcategory;
	/**
	 * user of activity
	 */
	protected User user;
	
	/**
	 * constructor of activity
	 */
	public Activity() {
		super();
	}
	
	/**
	 * constructor of activity
	 * @param u user
	 */
	public Activity(User u) {
		this.user = u;
	}

	/**
	 * constructor of activity
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param creationDate of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 */
	public Activity(String title, String description, boolean visible, String creationDate, Subcategory subcategory,
			User user) {
		super();
		this.title = title;
		this.description = description;
		this.visible = visible;
		this.creationDate = creationDate;
		this.subcategory = subcategory;
		this.user = user;
	}
	
	/**
	 * constructor of activity
	 * @param id of the activity
	 * @param title of the activity
	 * @param description of the activity
	 * @param visible of the activity
	 * @param creationDate of the activity
	 * @param subcategory of the activity
	 * @param user of the activity
	 */
	public Activity(int id, String title, String description, boolean visible, String creationDate,
			Subcategory subcategory, User user) {
		super();
		this.id = id;
		this.title = title;
		this.description = description;
		this.visible = visible;
		this.creationDate = creationDate;
		this.subcategory = subcategory;
		this.user = user;
	}

	/**
	 * constructor of activity
	 * @param title2 title of the activity
	 */
	public Activity(String title2) {
		this.title = title2;

	}
	
	/**
	 * get title of activity
	 * @return title
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * set title of activity
	 * @param title
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/** 
	 * get description of activity
	 * @return description
	 */
	public String getDescription() {
		return description;
	}
	
	/**
	 * set description of activity
	 * @param description
	 */
	public void setDescription(String description) {
		this.description = description;
	}
	
	/**
	 * find if the activity is visible 
	 * @return true if the activity is visible else false
	 */
	public boolean isVisible() {
		return visible;
	}
	
	/**
	 * set visible
	 * @param visible
	 */
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	
	/**
	 * get created activity date  
	 * @return createdDate
	 */
	public String getCreationDate() {
		return creationDate;
	}
	
	/**
	 * set created activity date
	 * @param creationDate
	 */
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	
	/**
	 * get sub-category
	 * @return sub-category
	 */
	public Subcategory getSubcategory() {
		return subcategory;
	}
	
	/**
	 * set sub-category of an activity
	 * @param subcategory
	 */
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
	
	/**
	 * get user of an activity
	 * @return user
	 */
	public User getUser() {
		return user;
	}
	
	/**
	 * set user
	 * @param user
	 */
	public void setUser(User user) {
		this.user = user;
	}
	
	/**
	 * save an activity on the DB
	 * @return true if activity is saved
	 */
	public abstract boolean save();
	
	/**
	 * get an activity by it title
	 * @return activity
	 */
	public abstract Activity readByTitle();
	
	/**
	 * get all the activities
	 * @return list of activities
	 */
	public abstract List<Activity> readAll();
	
	/**
	 * get all the private activities
	 * @return list of activities
	 */
	public abstract List<Activity> readAllPrivate();
	
	/**
	 * delete an activity
	 * @return true if the activity is deleted else false
	 */
	public abstract boolean delete();
	
	/**
	 * add task on an activity
	 * @return true if the task is added else false
	 */
	public abstract boolean addTask();
	
	/**
	 * delete task on an activity
	 * @return true if the task is deleted 
	 */
	public abstract boolean deleteTask();
	
	/**
	 * delete activity of an user with name of activity
	 * @return true if the activity is deleted else false
	 */
	public abstract boolean deleteByPseudoUserAndName();
	
	/**
	 * get all tasks of an activity
	 * @return list of tasks
	 */
	public abstract List<Task> readAllTask();
	
	/**
	 * get all comments of a task
	 * @return list of comments
	 */
	public abstract List<Comment> readAllComments();
	
	/**
	 * find if the activity exist
	 * @param title
	 * @return true if the activity exist else false
	 */
	public abstract boolean activityExist(String title);

	
}
