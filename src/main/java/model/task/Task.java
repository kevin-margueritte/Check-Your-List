package model.task;
import java.util.List;

import model.activity.Activity;
import model.product.Product;

/**
 *business class of activity 
 *
 */
public abstract class Task {
		
		/**
		 * id of task
		 */
		protected int id;
		/**
		 * name of task
		 */
		protected String name;
		/**
		 * description of task
		 */
		protected String description;
		/**
		 * frequency of task
		 */
		protected String frequency;
		/**
		 * task checked 
		 */
		protected boolean checked;
		/**
		 * startDate of task
		 */
		protected String startDate;
		/**
		 * endDate of task
		 */
		protected String endDate;
		/**
		 * activity of task
		 */
		protected Activity activity;
		/**
		 * visibility of task
		 */
		protected boolean visibility;

		/**
		 * construtor of task
		 */
		public Task() {
			super();
		}
		
		/**
		 * construtor of task
		 * @param name
		 * @param act
		 */
		public Task(String name, Activity act) {
			this.name = name;
			this.activity = act;
		}

		/**
		 * construtor of task
		 * @param name
		 * @param description
		 * @param frequency
		 * @param checked
		 * @param startDate
		 * @param endDate
		 * @param activity
		 * @param visibility
		 */
		public Task(String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
			super();
			this.name = name;
			this.description = description;
			this.frequency =frequency;
			this.checked = checked;
			this.startDate = startDate;
			this.endDate = endDate;
			this.activity = activity;
			this.visibility = visibility;
	
		}
		
		/**
		 * construtor of task
		 * @param id
		 * @param name
		 * @param description
		 * @param frequency
		 * @param checked
		 * @param startDate
		 * @param endDate
		 * @param activity
		 * @param visibility
		 */
		public Task(int id, String name, String description, String frequency, boolean checked, String startDate, String endDate, Activity activity, boolean visibility) {
			super();
			this.id=id;
			this.name = name;
			this.description = description;
			this.frequency =frequency;
			this.checked = checked;
			this.startDate = startDate;
			this.endDate = endDate;
			this.activity = activity;	
			this.visibility = visibility;
		}
		
		/**
		 * construtor of task
		 * @param id
		 * @param name
		 */
		public Task(int id, String name) {
			this.id = id;
			this.name = name;

		}

		/**
		 * get name of task
		 * @return name
		 */
		public String getName() {
			return name;
		}
		
		/**
		 * set name of task
		 * @param name
		 */
		public void setName(String name) {
			this.name = name;
		}
		
		/**
		 * get description of task
		 * @return description
		 */
		public String getDescription() {
			return description;
		}
		
		/**
		 * set description of task
		 * @param description
		 */
		public void setDescription(String description) {
			this.description = description;
		}
		
		/**
		 * get frequency of task
		 * @return frequency
		 */
		public String getFrequency() {
			return frequency;
		}
		
		/**
		 * set frequency of task
		 * @param frequency
		 */
		public void setFrequency(String frequency) {
			this.frequency = frequency;
		}
		
		/**
		 * find if the task is checked
		 * @return true if the task is checked else false
		 */
		public boolean isChecked() {
			return checked;
		}
		
		/**
		 * set checked of task
		 * @param checked
		 */
		public void setChecked(boolean checked) {
			this.checked = checked;
		}
		
		/**
		 * get start date of task 
		 * @return start date
		 */
		public String getStartDate() {
			return startDate;
		}
		
		/**
		 * set start date of task
		 * @param startDate
		 */
		public void setStartDate(String startDate) {
			this.startDate = startDate;
		}
		
		/**
		 * get end date of task
		 * @return end date
		 */
		public String getEndDate() {
			return endDate;
		}
		
		/**
		 * set end date of task
		 * @param endDate
		 */
		public void setEndDate(String endDate) {
			this.endDate = endDate;
		}
		
		/**
		 * get activity of task
		 * @return activity
		 */
		public Activity getActivity() {
			return activity;
		}
		
		/**
		 * set activity of task
		 * @param activity
		 */
		public void setActivity(Activity activity) {
			this.activity = activity;
		}
		
		/**
		 * get visibility of task
		 * @return visibility
		 */
		public boolean getVisibility() {
			return this.visibility;
		}
		
		/**
		 * get checked of task
		 * @return checked
		 */
		public boolean getChecked() {
			return this.checked;
		}
		
		/**
		 * set visibility of task
		 * @param visibility
		 */
		public void setVisibility(boolean visibility) {
			this.visibility = visibility;
		}
		
		/**
		 * get task with its name
		 * @return task
		 */
		public abstract Task readByName();
		
		/**
		 * save a task
		 * @return true if the task is saved else false
		 */
		public abstract boolean save();
		
		/**
		 * delete a task
		 * @return if the task is deleted else false
		 */
		public abstract boolean delete();
		
		/**
		 * update a task
		 * @return if the task is updated else false
		 */
		public abstract boolean update();
		
		/**
		 * add product on a task
		 * @param product
		 * @return if the product is added else false
		 */
		public abstract boolean addRessource(Product p);
		
		/**
		 * find if the task exist
		 * @return true if the task exist else false
		 */
		public abstract boolean exist();
		
		/**
		 * get all product of a task
		 * @return list of products
		 */
		public abstract List<Product> getAllRessourceTask();
}
