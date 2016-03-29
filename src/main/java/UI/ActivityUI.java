package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
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
import model.person.User;
import model.person.JDBC.UserJDBC;
import model.product.Product;
import model.task.Task;

@SuppressWarnings("serial")
public class ActivityUI extends JFrame implements ActionListener {
	
	private Activity activity;
	private User user;
	private ActivityFacade af;
	private JTextPane textPaneCommentContent;
	private JButton btnAddTask;
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
		
		JTextPane textPane = new JTextPane();
		textPane.setText(this.activity.getDescription());
		textPane.setBounds(10, 58, 513, 89);
		getContentPane().add(textPane);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setBounds(10, 38, 118, 14);
		getContentPane().add(lblDescription);
		
		JLabel lblTaskToDo = new JLabel("Task to do today");
		lblTaskToDo.setBounds(10, 171, 153, 14);
		getContentPane().add(lblTaskToDo);
		
		JLabel lblTaskList = new JLabel("Task list");
		lblTaskList.setBounds(10, 331, 46, 14);
		getContentPane().add(lblTaskList);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 359, 513, 46);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblTaskName = new JLabel("task name");
		lblTaskName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTaskName.setBounds(10, 11, 143, 24);
		panel.add(lblTaskName);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.setBounds(414, 14, 89, 23);
		panel.add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("start date / end date");
		lblNewLabel.setBounds(154, 18, 112, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("See");
		btnNewButton_1.setBounds(315, 14, 89, 23);
		panel.add(btnNewButton_1);
		
		btnAddTask = new JButton("Add task");
		btnAddTask.addActionListener(this);
		btnAddTask.setBounds(218, 301, 89, 23);
		getContentPane().add(btnAddTask);
		
		textPaneCommentContent = new JTextPane();
		textPaneCommentContent.setBounds(10, 494, 500, 103);
		getContentPane().add(textPaneCommentContent);
		
		lblAddComment = new JLabel("Add comment ");
		lblAddComment.setBounds(10, 458, 105, 20);
		getContentPane().add(lblAddComment);
		
		JButton btnAddComment = new JButton("Add comment");
		btnAddComment.addActionListener(this);
		btnAddComment.setBounds(178, 630, 162, 29);
		getContentPane().add(btnAddComment);
		setSize(547,731);
		
		this.initActivities();
	}
	
	public void initActivities() {
		List<Task> list = this.af.getAllTasks(this.activity);
		int idx = 1;
		for (Task t : list) {
			this.addCheckBox(t, idx);
			idx ++;
		}
	}
	
	public void addCheckBox(Task t, int idx) {
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

	@Override
	public void actionPerformed(ActionEvent e) {	
		if ( e.getSource() == this.lblAddComment ) {
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
