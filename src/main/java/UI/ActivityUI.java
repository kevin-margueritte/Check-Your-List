package UI;

import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Iterator;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import facade.ActivityFacade;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.comment.Comment;
import model.person.User;
import model.person.JDBC.UserJDBC;
import model.task.Task;

@SuppressWarnings("serial")
public class ActivityUI extends JFrame implements ActionListener {
	
	private Activity activity;
	private User user;
	private ActivityFacade af;
	private JTextPane textPaneCommentContent;
	private JButton btnAddTask;
	private JButton btnAddComment;
	private JLabel lblAddComment;
	
	
	public static void main(String args[]) {
		ActivityUI.launch();
	}
	
	/**
	 * Launch the application.
	 */
	public static void launch() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User u = new UserJDBC("titi");
					u.readByPseudo();
					Activity a = new ActivityJDBC(u);
					Iterator<Activity> it = a.readAll().iterator();
					ActivityUI frame = new ActivityUI(u,it.next());
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ActivityUI(User u, Activity act) {
		this.activity = act;
		this.user = u;
		this.af = new ActivityFacade();
		
		getContentPane().setLayout(null);
		
		JLabel lblActivityName = new JLabel(this.activity.getTitle());
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblActivityName.setHorizontalAlignment(SwingConstants.CENTER);
		lblActivityName.setBounds(178, 11, 162, 14);
		getContentPane().add(lblActivityName);
		
		JLabel textPane = new JLabel();
		textPane.setText(this.activity.getDescription());
		textPane.setBounds(10, 58, 513, 89);
		getContentPane().add(textPane);
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 38, 118, 14);
		getContentPane().add(lblDescription);
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JLabel lblTaskToDo = new JLabel("Task to do today");
			lblTaskToDo.setBounds(10, 171, 153, 14);
			getContentPane().add(lblTaskToDo);
		}
		
		JLabel lblTaskList = new JLabel("Task list");
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			lblTaskList.setBounds(10, 331, 68, 14);
		}
		else {
			lblTaskList.setBounds(10, 171, 153, 14);
		}
		getContentPane().add(lblTaskList);
		if(user.getPseudo().equals(activity.getUser().getPseudo())) {			
			btnAddTask = new JButton("Add task");
			btnAddTask.addActionListener(this);
			btnAddTask.setBounds(218, 301, 89, 23);
			getContentPane().add(btnAddTask);
		}
		
		List<Task> list = this.af.getAllTasks(this.activity);
		lblAddComment = new JLabel("Add comment ");
		if(user.getPseudo().equals(activity.getUser().getPseudo())) {
			lblAddComment.setBounds(10, 325 +(35*list.size() + 50), 105, 20);
		}
		else {
			lblAddComment.setBounds(10, 150 + (35*list.size() + 50), 105, 20);			
		}
		getContentPane().add(lblAddComment);
		
		this.initActivities(list);
		textPaneCommentContent = new JTextPane();
		if(user.getPseudo().equals(activity.getUser().getPseudo())) {
			textPaneCommentContent.setBounds(10, 325 +(35*list.size() + 100), 500, 103);
		}
		else {
			textPaneCommentContent.setBounds(10, 150 +(35*list.size() + 100), 500, 103);
		}
		getContentPane().add(textPaneCommentContent);
		
		
		btnAddComment = new JButton("Add comment");
		btnAddComment.addActionListener(this);
		if(user.getPseudo().equals(activity.getUser().getPseudo())) {
			btnAddComment.setBounds(178, 325 +(35*list.size() + 220), 162, 29);
		}
		else {
			btnAddComment.setBounds(178, 150 +(35*list.size() + 220), 162, 29);
		}
		getContentPane().add(btnAddComment);
		
		this.initComments();
	}
	
	public void initActivities(List<Task> list) {
		int idx = 1;
		for (Task t : list) {
			this.addCheckBox(t, idx);
			idx ++;
		}
	}
	
	public void addCheckBox(Task t, int idx) {
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JCheckBox chckbxNewCheckBox = new JCheckBox(t.getName());
			chckbxNewCheckBox.putClientProperty("task", t);
			chckbxNewCheckBox.addActionListener(this);
			chckbxNewCheckBox.setSelected(t.isChecked());
			if (idx == 1) {
				chckbxNewCheckBox.setBounds(31, 200, 97, 23);
			}
			else if (idx%2 == 1) {
				chckbxNewCheckBox.setBounds(31, (175 + (25 * ((idx + 1)/2) )), 97, 23);
			}
			else {
				chckbxNewCheckBox.setBounds(370, 175 + (25 * (idx/2) ), 97, 23);
			}
			getContentPane().add(chckbxNewCheckBox);
		}
		this.addPanelTask(t, idx);
	}
	
	public void addPanelTask(Task t, int idx) {
		
		JPanel panel = new JPanel();
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			panel.setBounds(10, 325 +(35 * idx), 513, 46);
		}
		else {
			panel.setBounds(10, 150 +(35 * idx), 513, 46);
		}
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTaskName = new JLabel(t.getName());
		lblTaskName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaskName.setBounds(10, 11, 143, 24);
		panel.add(lblTaskName);
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JButton btnNewButton = new JButton("Delete");
			btnNewButton.addActionListener(this);
			btnNewButton.putClientProperty("task", t);
			btnNewButton.setBounds(414, 14, 89, 23);
			panel.add(btnNewButton);
		}
		
		JLabel lblNewLabel = new JLabel(t.getStartDate() + "/" + t.getEndDate());
		lblNewLabel.setBounds(140, 18, 140, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("See");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.putClientProperty("task", t);
		btnNewButton_1.setBounds(315, 14, 89, 23);
		panel.add(btnNewButton_1);
	}
	
	public void initComments() {
		List<Comment> list = this.af.getAllComments(this.activity);			
		int idx = 19; // ??
		boolean firstComment = true;
		for (Comment comment : list) {
			if (firstComment) {
				JLabel lblComments = new JLabel("Comments");
				if(user.getPseudo().equals(activity.getUser().getPseudo())) {  
					lblComments.setBounds(10, 200 + (35*list.size() + 220), 105, 20);
				}
				else {
					lblComments.setBounds(10, (35*list.size() + 220), 105, 20);
				}
				getContentPane().add(lblComments);	
				firstComment = false;
			}
			this.addPanelComment(comment, idx);
			idx ++;
		}
		setSize(547, (100 * (list.size() + 1)) + 648); // à modifier
	}
	
	public void addPanelComment(Comment comment, int idx) {					
		JPanel panel = new JPanel();
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			panel.setBounds(10, idx * 38, 414, 40);
		}
		else {
			panel.setBounds(10, idx * 28, 414, 40);
		}
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblDateComment = new JLabel(comment.getPostingDate());
		lblDateComment.setBounds(23, 7, 99, 20);
		panel.add(lblDateComment);
		
		JLabel lblPseudoComment = new JLabel(comment.getUser().getPseudo());
		lblPseudoComment.setBounds(175, 7, 99, 20);
		panel.add(lblPseudoComment);
		
		JLabel lblContentComment = new JLabel(comment.getContent());
		lblContentComment.setBounds(294, 7, 99, 20);
		panel.add(lblContentComment);		
		
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if ( e.getSource() == this.btnAddComment ) {
			if (this.formComplete()) {
				this.af.createComment(this.textPaneCommentContent.getText(), activity, user);
				JOptionPane.showMessageDialog(this,
						"Your comment has been added, it will appears the next time you'll see this activity.");
			}
			
			//this.cf.createCategory(this.categoryName.getText(), this.textShortDescription.getText(),this.textDetailedDescription.getText());
			//ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
		 	//frame.setVisible(true);
		}
		else if (e.getSource() == this.btnAddTask) {
			TaskRessourceUI tr = new TaskRessourceUI(this.activity);
			tr.setVisible(true);
		}
		else if (e.getSource() instanceof JCheckBox) {
			JCheckBox check = (JCheckBox) e.getSource();
			Task t = (Task) check.getClientProperty("task");
			this.af.updateChecked(t, check.isSelected());
		}
		else if (e.getSource() instanceof JButton) {
			JButton button = (JButton) e.getSource();
			if ( button.getText().equals("See") ) {
				//ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
				//frame.setVisible(true);
				System.out.println("see");
			}
			else {
				this.af.deleteTask((Task) button.getClientProperty("task"));
				Component[] com = button.getParent().getComponents();
				for (int a = 0; a < com.length; a++) {
				     com[a].setEnabled(false);
				}
			}
		}
		/*
		else {
			this.pf.deleteActivity((Activity) button.getClientProperty("activity"));
			Component[] com = button.getParent().getComponents();
			for (int a = 0; a < com.length; a++) {
			     com[a].setEnabled(false);
			}
		}	
		*/ 		
	}
	
	public boolean formComplete() {
		if (this.textPaneCommentContent.getText().isEmpty()) {
			JOptionPane.showMessageDialog(this,
					"Please enter your comment to add it",
				    "Error",
				    JOptionPane.ERROR_MESSAGE);
			return false;
		}
		return true;
	}
}
