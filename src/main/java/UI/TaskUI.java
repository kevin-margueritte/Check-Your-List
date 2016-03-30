package UI;

import java.awt.EventQueue;
import java.awt.Font;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.SwingConstants;

import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.person.User;
import model.person.JDBC.UserJDBC;
import model.task.Task;

public class TaskUI extends JFrame {
	
	private Task task;
	
	public static void main(String args[]) {
		TaskUI.launch();
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
					Activity act = new ActivityJDBC(u);
					act.setTitle("a");
					TaskUI frame = new TaskUI(act.readAllTask().get(0));
					frame.setLocationRelativeTo(null);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public TaskUI(Task task) {
		this.task = task;
		getContentPane().setLayout(null);
		
		JLabel titleTask = new JLabel("New label");
		titleTask.setHorizontalAlignment(SwingConstants.CENTER);
		titleTask.setFont(new Font("Tahoma", Font.BOLD, 18));
		titleTask.setBounds(10, 11, 414, 22);
		getContentPane().add(titleTask);
		
		JLabel lblDescription = new JLabel("Description");
		lblDescription.setFont(new Font("Tahoma", Font.PLAIN, 13));
		lblDescription.setHorizontalAlignment(SwingConstants.CENTER);
		lblDescription.setBounds(10, 75, 414, 14);
		getContentPane().add(lblDescription);
		
		JLabel txtDescription = new JLabel(this.task.getDescription());
		txtDescription.setHorizontalAlignment(SwingConstants.CENTER);
		txtDescription.setBounds(10, 100, 414, 22);
		getContentPane().add(txtDescription);
		
		JLabel lblNewLabel_1 = new JLabel("Frequency");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_1.setBounds(10, 133, 414, 14);
		getContentPane().add(lblNewLabel_1);
		
		JLabel frqText = new JLabel(this.task.getFrequency());
		frqText.setHorizontalAlignment(SwingConstants.CENTER);
		frqText.setBounds(10, 158, 414, 14);
		getContentPane().add(frqText);
		
		JLabel lblPeriod = new JLabel("From " + this.task.getStartDate() + " to " + this.task.getEndDate());
		lblPeriod.setHorizontalAlignment(SwingConstants.CENTER);
		lblPeriod.setFont(new Font("Tahoma", Font.PLAIN, 12));
		lblPeriod.setBounds(10, 44, 414, 14);
		getContentPane().add(lblPeriod);
		
		JPanel panelProducts = new JPanel();
		panelProducts.setBounds(10, 183, 414, 139);
		getContentPane().add(panelProducts);
		panelProducts.setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(0, 0, 414, 139);
		panelProducts.add(scrollBar);
	}
}
