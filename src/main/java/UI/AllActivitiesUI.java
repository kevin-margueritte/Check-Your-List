package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
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

// TODO: Auto-generated Javadoc
/**
 * The Class AllActivitiesUI.
 */
public class AllActivitiesUI extends JFrame implements ActionListener {

	/** The af. */
	//private JPanel contentPane;
	private ActivityFacade af;
	
	/** The u. */
	private User u;
	
	/** The panel activity. */
	private List<JPanel> panelActivity;

	/**
	 * Launch the application.
	 *
	 * @param u the u
	 */
	
	/*public static void main(String[] args) {
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
	}*/
	

	/**
	 * Create the frame.
	 */
	public AllActivitiesUI(User u) {
		setResizable(false);
		this.panelActivity = new ArrayList<JPanel>();
		getContentPane().setLayout(null);
		this.u =u;
		
		JLabel lblTitle = new JLabel("Activities");
		lblTitle.setHorizontalAlignment(SwingConstants.CENTER);
		lblTitle.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblTitle.setBounds(10, 11, 427, 14);
		getContentPane().add(lblTitle);
	
		this.af = new ActivityFacade();
		this.initFrame();
	}
	
	/**
	 * Inits the frame.
	 */
	public void initFrame() {
		Activity a = (Activity) new ActivityJDBC();
		List<Activity> list = this.af.getAllActivities(a);
		for (JPanel p : this.panelActivity) {
			this.remove(p);
		}
		int idx = 1;
		for (Activity act : list) {
			this.addPanelActivity(act, idx);
			idx ++;
		}
		

		setSize(470, (40 * (list.size() + 1)) + 50);
		this.setLocationRelativeTo(null);
	}
	
	/**
	 * Adds the panel activity.
	 *
	 * @param act the act
	 * @param idx the idx
	 */
	public void addPanelActivity(Activity act, int idx) {		
		JPanel panel = new JPanel();

		this.panelActivity.add(panel);
		panel.setBounds(10, idx * 38, 450, 40);

		getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblNameActivity = new JLabel(act.getTitle());
		lblNameActivity.setFont(new Font("Tahoma", Font.BOLD, 14));

		lblNameActivity.setBounds(23, 18, 300, 20);

		panel.add(lblNameActivity);
		
		JButton btnSee = new JButton("See");
		btnSee.putClientProperty("activity", act);

		btnSee.setBounds(350, 17, 89, 23);

		btnSee.addActionListener(this);
		panel.add(btnSee);
	}

	/* (non-Javadoc)
	 * @see java.awt.event.ActionListener#actionPerformed(java.awt.event.ActionEvent)
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("See") ) {
			ActivityUI frame = new ActivityUI(this.u, (Activity) button.getClientProperty("activity"));
			frame.setVisible(true);
		}		
	}

}
