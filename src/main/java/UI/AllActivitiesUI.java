package UI;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import facade.ActivityFacade;
import model.activity.Activity;
import model.activity.JDBC.ActivityJDBC;
import model.person.User;

public class AllActivitiesUI extends JFrame implements ActionListener {

	//private JPanel contentPane;
	private ActivityFacade af;
	private User u;

	/**
	 * Launch the application.
	 */
	/*
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					AllActivitiesUI frame = new AllActivitiesUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	*/

	/**
	 * Create the frame.
	 */
	public AllActivitiesUI(User u) {
		setResizable(false);
		getContentPane().setLayout(null);
		
		JLabel lblTitle = new JLabel("Activities");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(10, 11, 427, 14);
		getContentPane().add(lblTitle);
		
		this.u = u;
		this.af = new ActivityFacade();
		this.initFrame();
	}
	
	public void initFrame() {
		Activity a = (Activity) new ActivityJDBC();
		List<Activity> list = this.af.getAllActivities(a);
		int idx = 1;
		for (Activity act : list) {
			this.addPanelActivity(act, idx);
			idx ++;
		}
		
		setSize(453, (38 * (list.size() + 1)) + 50);
	}
	
	public void addPanelActivity(Activity act, int idx) {		
		JPanel panel = new JPanel();
		panel.setBounds(10, idx * 38, 414, 40);
		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNameActivity = new JLabel(act.getTitle());
		lblNameActivity.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblNameActivity.setBounds(23, 18, 250, 20);
		panel.add(lblNameActivity);
		
		JButton btnSee = new JButton("See");
		btnSee.putClientProperty("activity", act);
		btnSee.setBounds(275, 17, 89, 23);
		btnSee.addActionListener(this);
		panel.add(btnSee);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("See") ) {
			ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
			frame.setVisible(true);
		}		
	}

}
