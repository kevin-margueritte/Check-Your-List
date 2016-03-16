package model.activity;

import java.util.Date;
import java.util.List;

import model.task.Task;

public abstract class Activity {

	private String title;
	private String description;
	private boolean visible;
	private Date creationDate;
	private List<Task> listTask;
	
	
}
