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

@SuppressWarnings("serial")
public class ActivityUI extends JFrame implements ActionListener {
	
	private Activity activity;
	private User user;
	private ActivityFacade af;
	private JTextPane textPaneCommentContent;
	
	
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
					User u = new UserJDBC("titi"); // a modifier non ?
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
		this.initFrame();
		
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
		
		JCheckBox chckbxNewCheckBox = new JCheckBox("New check box");
		chckbxNewCheckBox.setBounds(31, 201, 97, 23);
		getContentPane().add(chckbxNewCheckBox);
		
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
		
		JButton btnAddTask = new JButton("Add task");
		btnAddTask.setBounds(218, 301, 89, 23);
		getContentPane().add(btnAddTask);
		
		textPaneCommentContent = new JTextPane();
		textPaneCommentContent.setBounds(10, 494, 500, 103);
		getContentPane().add(textPaneCommentContent);
		
		JLabel lblAddComment = new JLabel("Add comment ");
		lblAddComment.setBounds(10, 458, 105, 20);
		getContentPane().add(lblAddComment);
		
		JButton btnAddComment = new JButton("Add comment");
		btnAddComment.addActionListener(this);
		btnAddComment.setBounds(178, 630, 162, 29);
		getContentPane().add(btnAddComment);
		
		//setSize(547,848);
	}
	
	public void initFrame() {
		List<Comment> list = this.af.getAllComments(this.activity);			
		int idx = 19; // ??
		boolean firstComment = true;
		for (Comment comment : list) {
			if (firstComment) {
				JLabel lblComments = new JLabel("Comments");
				lblComments.setBounds(10, 690, 105, 20);
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
		panel.setBounds(10, idx * 38, 414, 40);
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
		JButton button = (JButton) e.getSource();		
		if ( button.getText().equals("Add comment") ) {
			if (this.formComplete()) {
				this.af.createComment(this.textPaneCommentContent.getText(), activity, user);
				JOptionPane.showMessageDialog(this,
						"Your comment has been added, it will appears the next time you'll see this activity.");
			}
			
			//this.cf.createCategory(this.categoryName.getText(), this.textShortDescription.getText(),this.textDetailedDescription.getText());
			//ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
		 	//frame.setVisible(true);
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
