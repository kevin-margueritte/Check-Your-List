package UI;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.List;

import javax.swing.DefaultButtonModel;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

import facade.ProfilUserFacade;
import model.activity.Activity;
import model.person.User;
import model.person.JDBC.UserJDBC;

public class ProfilUserUI extends JFrame implements ActionListener {
	
	private ProfilUserFacade pf;
	private User u;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ProfilUserUI frame = new ProfilUserUI();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	public ProfilUserUI() {
		setResizable(false);
		getContentPane().setLayout(null);
		/**
		 * Set User
		 */
		this.u = new UserJDBC("titi");
		this.u.readByPseudo();
		
		this.pf = new ProfilUserFacade();
		this.initFrame();
	}
	
	public void initFrame() {
		List<Activity> list = this.pf.getAllActivities(this.u);
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
		lblNameActivity.setBounds(23, 11, 99, 20);
		panel.add(lblNameActivity);
		
		JButton btnSee = new JButton("See");
		btnSee.putClientProperty("activity", act);
		btnSee.setBounds(175, 7, 89, 23);
		btnSee.addActionListener(this);
		panel.add(btnSee);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.setBounds(294, 7, 89, 23);
		btnDelete.putClientProperty("activity", act);
		btnDelete.addActionListener(this);
		panel.add(btnDelete);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		JButton button = (JButton) e.getSource();
		if ( button.getText().equals("See") ) {
			System.out.println("See : " + button.getClientProperty("activity") );
		}
		else {
			System.out.println("Delete : " + button.getClientProperty("activity"));
			this.pf.deleteActivity((Activity) button.getClientProperty("activity"));
			this.initFrame();
		}
	}
	
}
