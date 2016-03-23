package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.util.Iterator;

import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.SwingConstants;

import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;

@SuppressWarnings("serial")
public class ActivityUI extends JFrame {
	
	private Activity activity;
	private User user;
	
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
		setSize(547,462);
	}
}
