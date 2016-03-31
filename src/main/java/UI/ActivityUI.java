package UI;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import facade.ActivityFacade;
import model.activity.Activity;
import model.comment.Comment;
import model.person.User;
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
	private JPanel panelActivity;
	private double heigth;
	private JPanel panelTopDescription;
	private JPanel panelTaskList;
	private JPanel panelTask;
	private JPanel panelComment;
	
	public ActivityUI(User u, Activity act) {
		this.activity = act;
		this.user = u;
		this.af = new ActivityFacade();
		List<Task> list = this.af.getAllTasks(this.activity);
		
		getContentPane().setLayout(null);
		
		/////PANEL PRINCIPAL ---------------------------------------------------------------------------
		panelActivity = new JPanel();
		panelActivity.setLayout(null);
		
		//SCROLL PANEL
		JScrollPane scrollPane_1 = new JScrollPane(panelActivity);
		scrollPane_1.setBounds(0, 0, 615, 700);
		getContentPane().add(scrollPane_1);
		
		
		///// PANEL TOP -------------------------------------------------------------------------------
		panelTopDescription = new JPanel();
		panelTopDescription.setLayout(null);

		
		JLabel lblActivityName = new JLabel(this.activity.getTitle());
		lblActivityName.setBounds(195, 5, 175, 48);
		panelTopDescription.add(lblActivityName);
		lblActivityName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblActivityName.setHorizontalAlignment(SwingConstants.CENTER);
		
		
		JLabel lblDescription = new JLabel("Description :");
		lblDescription.setBounds(10, 52, 80, 41);
		panelTopDescription.add(lblDescription);
		
		JLabel textPane = new JLabel();
		textPane.setBounds(74, 52, 452, 121);
		panelTopDescription.add(textPane);
		textPane.setText(this.activity.getDescription());
		
		this.heigth = 184;
		
		panelTopDescription.setBounds(0, 0, 582, 184);
		panelActivity.add(panelTopDescription);
		
		//PANEL TASK  ----------------------------------------------------------------
		panelTask = new JPanel();
		panelTask.setLayout(null);
	
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JLabel lblTaskToDo = new JLabel("Task to do today");
			lblTaskToDo.setBounds(10, 10, 153, 14);
			panelTask.add(lblTaskToDo);
		}
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) {			
			btnAddTask = new JButton("Add task");
			btnAddTask.addActionListener(this);	
			btnAddTask.setBounds(255, 40 + ((23 * (list.size() + 1)) / 2 ), 90, 23);
			this.panelTask.add(btnAddTask);
		}
		
		
		//panelTask.setBounds(0, 183, 582, 200);

		panelActivity.add(panelTask);
		
		//PANEL TASKLIST ------------------------------------------------------------
		
		
		panelTaskList = new JPanel();
		panelTaskList.setLayout(null);
		
		this.initActivities(list);
		
		JLabel lblTaskList = new JLabel("Task list");
		lblTaskList.setBounds(10, 10, 89, 23);
		this.panelTaskList.add(lblTaskList);
	
		panelActivity.add(panelTaskList);

		//PANEL COMMENT -------------------------------------------------------------
		panelComment = new JPanel();
		
		panelComment.setLayout(null);
		
		lblAddComment = new JLabel("Add comment ");
		lblAddComment.setBounds(10, 10, 120, 14);
		panelComment.add(lblAddComment);
		

		textPaneCommentContent = new JTextPane();
		textPaneCommentContent.setBounds(32, 46, 519, 64);
		panelComment.add(textPaneCommentContent);
		
		btnAddComment = new JButton("Add comment");
		btnAddComment.setBounds(230, 115, 140, 23);
		panelComment.add(btnAddComment);
		btnAddComment.addActionListener(this);
		
		this.initComments();
		
		panelActivity.add(panelComment);
		
		setSize(630, 700);
		this.setLocationRelativeTo(null);
	}
	
	public void initActivities(List<Task> list) {
		int idx = 1;	
		panelTaskList.removeAll();
		for (Task t : list) {
			this.addCheckBox(t, idx);
			idx ++;
		}
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			panelTask.setBounds(0, 183, 600, 80 + (23 * (list.size() + 1 ))/2);
		}else{
			panelTask.setBounds(0, 183, 0, 0);
		}
		panelTaskList.setBounds(0, panelTask.getY() + panelTask.getHeight(), 600,23+ 40 * (list.size() + 1 ));
		this.heigth = this.heigth + (40 * (list.size() + 1));

		panelTaskList.repaint();
	}
	
	public void addCheckBox(Task t, int idx) {
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JCheckBox chckbxNewCheckBox = new JCheckBox(t.getName());
			chckbxNewCheckBox.putClientProperty("task", t);
			chckbxNewCheckBox.addActionListener(this);
			chckbxNewCheckBox.setSelected(t.isChecked());
			if (idx == 1) {
				chckbxNewCheckBox.setBounds(31, 35, 200, 23);
			}
			else if (idx%2 == 1) {
				chckbxNewCheckBox.setBounds(31, (10 + (25 * ((idx + 1)/2) )), 200, 23);
			}
			else {
				chckbxNewCheckBox.setBounds(370, 10 + (25 * (idx/2) ), 200, 23);
			}
			this.panelTask.add(chckbxNewCheckBox);
		}


		if(user.getPseudo().equals(activity.getUser().getPseudo()) || t.getVisibility() == true) { 
			this.addPanelTask(t, idx);
		}
	}
	
	public void addPanelTask(Task t, int idx) {
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 60 + 35 * (idx-1), 580, 46);
	
		panel.setLayout(null);
		
		JLabel lblTaskName = new JLabel(t.getName());
		lblTaskName.setFont(new Font("Tahoma", Font.BOLD, 12));
		lblTaskName.setBounds(10, 11, 150, 24);
		panel.add(lblTaskName);
		
		if(user.getPseudo().equals(activity.getUser().getPseudo())) { 
			JButton btnNewButton = new JButton("Delete");
			btnNewButton.addActionListener(this);
			btnNewButton.putClientProperty("task", t);
			btnNewButton.setBounds(450, 14, 89, 23);
			panel.add(btnNewButton);
		}
		
		JLabel lblNewLabel = new JLabel(t.getStartDate() + "/" + t.getEndDate());
		lblNewLabel.setBounds(155, 18, 140, 14);
		panel.add(lblNewLabel);
		
		JButton btnNewButton_1 = new JButton("See");
		btnNewButton_1.addActionListener(this);
		btnNewButton_1.putClientProperty("task", t);
		btnNewButton_1.setBounds(340, 14, 89, 23);
		panel.add(btnNewButton_1);
		
		panelTaskList.add(panel);
		
	}
	
	public void initComments() {
		List<Comment> list = this.af.getAllComments(this.activity);
		int idx = 1; 
		for (Comment comment : list) {
			this.addPanelComment(comment, idx);
			idx ++;
		}
		System.out.println(panelComment.getHeight());
		
		this.panelComment.setBounds(0, this.panelTaskList.getY() + 
				this.panelTaskList.getHeight() + 5, 615, list.size() * 100 + 200);
		
		System.out.println(panelComment.getHeight());
		panelActivity.setPreferredSize(new Dimension(615,this.panelComment.getY()
				+ this.panelComment.getHeight()));
		panelActivity.repaint();
	}
	
	public void addPanelComment(Comment comment, int idx) {					
		JPanel panel = new JPanel();
		panel.setBounds(10, 150 + (idx-1) * 100, 580, 100);
	
		panel.setLayout(null);
		
		JLabel lblDateComment = new JLabel("Posted the " + comment.getPostingDate());
		lblDateComment.setBounds(23, 7, 209, 20);
		panel.add(lblDateComment);
		
		JLabel lblPseudoComment = new JLabel("By : " + comment.getUser().getPseudo());
		lblPseudoComment.setBounds(175, 7, 209, 20);
		panel.add(lblPseudoComment);
		
		JTextPane textPaneContentComment = new JTextPane();
		textPaneContentComment.setText(comment.getContent());
		textPaneContentComment.setBounds(23, 30, 519, 60);
		textPaneContentComment.setEditable(false);
		panel.add(textPaneContentComment);		
		
		this.panelComment.add(panel);
	}
	
	public void detectTaskRessourceUIClose() {
		ActivityUI myActUI = new ActivityUI(this.user, this.activity);
		myActUI.setVisible(true);
		this.dispose();
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {	
		if ( e.getSource() == this.btnAddComment ) {
			if (this.formComplete()) {
				this.af.createComment(this.textPaneCommentContent.getText(), activity, user);
				initComments();
			}
		}
		else if (e.getSource() == this.btnAddTask) {
			CreateTaskUI tr = new CreateTaskUI(this.activity,this);
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
				TaskUI taskUI = new TaskUI((Task) button.getClientProperty("task"));
				taskUI.setVisible(true);
				
			}
			else {
				this.af.deleteTask((Task) button.getClientProperty("task"));
				Component[] com = button.getParent().getComponents();
				for (int a = 0; a < com.length; a++) {
				     com[a].setEnabled(false);
				}
			}
		}	
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
