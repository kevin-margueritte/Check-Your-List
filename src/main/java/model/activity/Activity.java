package model.activity;

import java.util.Date;
import java.util.List;

import model.category.Subcategory;
import model.comment.Comment;
import model.person.User;
import model.task.Task;

public abstract class Activity {

	protected int id;
	protected String title;
	protected String description;
	protected boolean visible;
	protected String creationDate;
	protected List<Task> listTask;
	protected Subcategory subcategory;
	protected User user;
	
	public Activity() {
		super();
	}
	
	public Activity(User u) {
		this.user = u;
	}

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

	public Activity(int id2, String title2) {
		this.id = id2;
		this.title = title2;

	}

	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public boolean isVisible() {
		return visible;
	}
	public void setVisible(boolean visible) {
		this.visible = visible;
	}
	public String getCreationDate() {
		return creationDate;
	}
	public void setCreationDate(String creationDate) {
		this.creationDate = creationDate;
	}
	public Subcategory getSubcategory() {
		return subcategory;
	}
	public void setSubcategory(Subcategory subcategory) {
		this.subcategory = subcategory;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	public abstract boolean save();
	public abstract Activity readByTitle();
	public abstract List<Activity> readAll();
	public abstract boolean delete();
	public abstract boolean addTask();
	public abstract boolean deleteTask();
	public abstract boolean deleteByPseudoUserAndName();
	public abstract List<Task> readTaskByActivity();

	
}
